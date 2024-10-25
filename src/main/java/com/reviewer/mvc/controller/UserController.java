package com.reviewer.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewer.mvc.model.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("userpage")
	public String userPage() {
		return "/user/userpage";
	}

	@GetMapping("login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("login")
	public String login() {
		return "";
	}
	
	@GetMapping("logout")
	public String logout() {
		
		return "/";
	}
	
}
