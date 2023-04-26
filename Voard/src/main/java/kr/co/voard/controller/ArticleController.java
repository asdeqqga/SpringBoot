package kr.co.voard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.voard.service.ArticleService;
import kr.co.voard.vo.ArticleVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class ArticleController {

	
	private ArticleService service;
	
	
	@PostMapping("/write")
	public void write(HttpServletRequest req, @RequestBody ArticleVO vo) {
		
		service.insertArticle(req, vo);
		
	}
	
	
}