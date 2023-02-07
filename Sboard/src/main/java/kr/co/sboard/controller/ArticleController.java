package kr.co.sboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.farmstory.vo.SearchCondition;
import kr.co.sboard.utils.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.security.MyUserDetails;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;

	@GetMapping("list")
	public String list(@AuthenticationPrincipal MyUserDetails myUser, Model model, String pg, SearchCondition sc) {
		
		UserEntity user = myUser.getUser();

		int totalCnt = service.selectCountTotal();


		PageHandler pageHandler = new PageHandler(totalCnt, sc);

		
		List<ArticleVO> articles = service.selectArticles(start);

		model.addAttribute("ph", pageHandler);

		return "list";
	}
	
	@GetMapping("modify")
	public String modify() {
		return "modify";
	}
	
	@GetMapping("view")
	public String view(@RequestParam("no") int no, Model model) {
		ArticleVO article = service.selectArticle(no);
		model.addAttribute("article", article);
		return "view";
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	public String write(ArticleVO vo) {
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
	@GetMapping("download")
	public ResponseEntity<Resource> download(int fno) throws IOException {
		FileVO vo = service.selectFile(fno);
		ResponseEntity<Resource> respEntity = service.fileDownload(vo);
		return respEntity;
	}
	
	
}