package kr.co.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ch07.service.User3Service;
import kr.co.ch07.vo.User3VO;


@Controller
@RequestMapping
public class User3Controller {
	
	@Autowired
	private User3Service service;
	
	@GetMapping("/user3/list")
	public String list(Model model) {
		List<User3VO> users = service.selectUser3s();
		model.addAttribute("users", users);
		return "/user3/list";
	}
	
	@GetMapping("/user3/register")
	public String register(Model model, User3VO user) {
		model.addAttribute("user", user);
		return "/user3/register";
	}
	
	@PostMapping("/user3/register")
	public String register(User3VO user) {
		service.insertUser3(user);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/modify")
	public String modify(String uid, Model model) {
		User3VO user = service.selectUser3(uid);
		model.addAttribute("user", user);
		return "/user3/modify";
	}
	
	@PostMapping("/user3/modify")
	public String modify(User3VO user) {
		service.updateUser3(user);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/delete")
	public String delete(String uid) {
		service.deleteUser3(uid);
		return "redirect:/user3/list";
	}
	
}
