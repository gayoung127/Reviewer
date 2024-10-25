package com.reviewer.mvc.controller;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewer.mvc.model.service.BoardService;

@Controller
//@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	private final ResourceLoader resourceLoader;
	
	public BoardController(BoardService boardService, ResourceLoader resourceLoader) {
		this.boardService = boardService;
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping({"/","/index", ""})
	public String main() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "/board/list";
	}

}
