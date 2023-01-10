package kr.co.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.user.service.MemberService;
import kr.co.user.vo.MemberVO;

@Controller
@RequestMapping
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberVO> users = service.selectMembers();
		model.addAttribute("users", users);
		return "/member/list";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVO vo) {
		service.insertMember(vo);
		return "redirect:/member/list";
	}
	
	
}
