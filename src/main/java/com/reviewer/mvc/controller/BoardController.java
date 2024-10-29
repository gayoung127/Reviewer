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
import com.reviewer.mvc.model.service.BoardService;
import com.reviewer.mvc.model.service.ReviewService;


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
	public String regist(@ModelAttribute Board board, @ModelAttribute List<Review> reviews) {
		boardService.writeBoard(board);
		
		for(Review review : reviews) {
			review.setBoardId(board.getBoardId());
			reviewService.writeReview(review);
		}
		
		return "/list";
	}
	
}
