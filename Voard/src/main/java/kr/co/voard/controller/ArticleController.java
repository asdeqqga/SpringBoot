package kr.co.voard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("list")
	public Map<String, Object> list(String pg) {
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		long total = service.getTotalCount();
		int lastPage = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPage);
		
		List<ArticleVO> articles = service.selectArticles(start, "free");
		
//		model.addAttribute("articles", articles);
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("lastPage", lastPage);
//		model.addAttribute("pageStartNum", pageStartNum);
//		model.addAttribute("groups", groups);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("articles", articles);
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("pageStartNum", pageStartNum);
		resultMap.put("groups", groups);
		
		return resultMap;
	}
	
	@PostMapping("/write")
	public void write(HttpServletRequest req, @RequestBody ArticleVO vo) {
		
		service.insertArticle(req, vo);
		
	}
	
	
}