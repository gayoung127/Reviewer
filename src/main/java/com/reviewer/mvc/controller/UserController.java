package com.reviewer.mvc.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewer.mvc.model.dto.User;
import com.reviewer.mvc.model.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

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
	public String login(@ModelAttribute User loginUser, HttpSession session, HttpServletRequest request) {
		User user = userService.selectByIdAndPass(loginUser.getId(), loginUser.getPass());

		if (user != null) {
			session.setAttribute("loginUserId", user.getId());
			session.setAttribute("loginUserName", user.getName());

			return "redirect:/list";
		}
		
		request.setAttribute("message", "잘못된 정보입니다.");
		return "/user/loginForm";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("signup")
	public String signupForm() {
		return "/user/signupForm";
	}

	@PostMapping("signup")
	public String signup(@ModelAttribute User signupUser, HttpSession session, HttpServletRequest request) {
//		User user = userService.selectById(signupUser.getId());

		// user가 비어있으면 가입 가능한 것, 아니면 중복 아이디
//		if (user == null) {
			// 가입하기 위해서 db에 사용자 정보 저장
			Boolean result = userService.signup(signupUser);
			if (result) {
				return "redirect:/user/login";
			}
//		}
		// 중복 아이디 이므로 아이디 다시 입력할 수 있도록 한다
		request.setAttribute("message", "중복 아이디 입니다.");
		return "/user/signupForm";
	}

}
