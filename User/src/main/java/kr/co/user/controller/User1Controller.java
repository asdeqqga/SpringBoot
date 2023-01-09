package kr.co.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.user.service.User1Service;
import kr.co.user.vo.User1VO;

@Controller
@RequestMapping
public class User1Controller {

	@Autowired
	private User1Service service;
	
	@GetMapping("/user1/list")
	public String list(Model model) {
		List<User1VO> users = service.selectUser1s(); 
		model.addAttribute("users", users);
		return "/user1/list";
	}
	
	
	@GetMapping("/user1/register")
	public String register(Model model, User1VO user) {
		model.addAttribute("user", user);
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(User1VO user) {
		service.insertUser1(user);
		return "redirect:/user1/list";
	}
	
	
	@GetMapping("/user1/modify")
	public String modify(String uid, Model model) {
		User1VO user = service.selectUser1(uid);
		model.addAttribute("user", user);
		return "/user1/modify";
	}
	
	@PostMapping("/user1/modify")
	public String modify(User1VO user) {
		service.updateUser1(user);
		return "redirect:/user1/list";
	}
		
	@GetMapping("/user1/delete")
	public String delete(String uid) {
		service.deleteUser1(uid);
		return "redirect:/user1/list";
	}
}
