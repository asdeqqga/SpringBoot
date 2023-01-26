package kr.co.farmstory.controller;


import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("list")
    public String list() {
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

}
