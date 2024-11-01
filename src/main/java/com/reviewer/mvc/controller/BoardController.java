package com.reviewer.mvc.controller;

import java.util.List;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewer.mvc.model.dto.Board;
import com.reviewer.mvc.model.dto.Review;
import com.reviewer.mvc.model.dto.ReviewWrapper;
import com.reviewer.mvc.model.service.BoardService;
import com.reviewer.mvc.model.service.ReviewService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
//@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	private final ReviewService reviewService;
	private final ResourceLoader resourceLoader;
	
	public BoardController(BoardService boardService, ResourceLoader resourceLoader, ReviewService reviewService) {
		this.boardService = boardService;
		this.resourceLoader = resourceLoader;
		this.reviewService = reviewService;
	}
	
	@GetMapping({"/","/index", ""})
	public String main() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> boards = boardService.selectAll();
		model.addAttribute("boards", boards);
		
		return "/board/list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		Board board = boardService.getBoardByid(id);
		model.addAttribute("board", board);
		
		if(board != null) {
			List<Review> reviews = reviewService.getReviewsById(board.getBoardId());
			model.addAttribute("reviews", reviews);
		}
		
		return "/board/detail";
	}
	
	
	
	@GetMapping("/regist")
	public String registForm() {
		return "/board/registForm";
	}
	
	@PostMapping("regist")
	@Transactional
	public String regist(@ModelAttribute Board board, @ModelAttribute ReviewWrapper reviewWrapper) {
		boardService.writeBoard(board);
		
		List<Review> reviews = reviewWrapper.getReviews();
		double rating = 0;
		for(Review review : reviews) {
			review.setBoardId(board.getBoardId());
			reviewService.writeReview(review);
			rating += review.getFoodRating();
		}
		rating = rating / reviews. size();
		board.setReviewRating(rating);
		boardService.updateBoard(board);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	@Transactional
	public String deleteBoard(@PathVariable("id") int id) {
		boardService.deleteBoard(id);
		reviewService.deleteByBoardId(id);
		
		return "redirect:/list";
	}
	
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		Board board = boardService.getBoardByid(id);
		model.addAttribute("board", board);
		
		List<Review> reviews = reviewService.getReviewsById(id);
		model.addAttribute("reviews", reviews);
		
		return "/board/updateForm";
	}
	
	@PostMapping("/update")
	@Transactional
	public String update( @ModelAttribute Board board, @ModelAttribute ReviewWrapper reviewWrapper) {
		//기존 보드에 저장되어 있는 리뷰들 가져오기
		List<Review> updateReviews = reviewWrapper.getReviews();
		
		double newRating = 0;
		for(Review updateReview : updateReviews) {
			newRating += updateReview.getFoodRating();
		}
		newRating = newRating/ updateReviews.size();
		board.setReviewRating(newRating);
		boardService.updateBoard(board);
		reviewService.updateReviews(board.getBoardId(), updateReviews);
		//수정된 세부 페이지로 리다이렉트
		return "redirect:/detail/" + board.getBoardId();
	}
	
}
