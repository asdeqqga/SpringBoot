package kr.co.todo.controller;

import kr.co.todo.service.MainService;
import kr.co.todo.vo.TodoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        // 최초 접근시 각 상태의 게시물 불러오기
        Map<Integer, List<TodoVO>> data = service.selectTodoList();

        // 전송
        model.addAttribute("data", data);
        
        return "index";
    }

    /**
     * 아이템 이동시 Update 처리
     */
    @ResponseBody
    @PostMapping("todoUpdate")
    public Map<String, Object> todoUpdate(@RequestBody Map<String, String> data) {
        // 리턴 할 값 선언
        int result = 0;

        // 들어오는 값으로 게시물 변화
        result = service.updateTodoList(data);
        
        // 리턴 하는 map 생성
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);
    
        // 리턴
        return resultMap;
    }

    /**
     *   투두리스트 생성
     */
    @ResponseBody
    @PostMapping("todoInsert")
    public Map<String, Object> todoInsert(@RequestBody TodoVO vo) {
        // 리턴 할 값 선언
        int result = 0;
        
        // 들어오는 값으로 row 생성
        result = service.insertTodoList(vo);
        log.info("todoNum : "+vo.getTodoNum());
        
        // 리턴하는 map 생성
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);
        resultMap.put("vo", vo);

        // 리턴
        return resultMap;
    }

    @ResponseBody
    @PostMapping("todoDelete")
    public Map<String, Object> todoDelete(@RequestBody TodoVO vo) {
        // 리턴 할 값 선언
        int result = 0;

        // 들어오는 값으로 row 생성
        result = service.deleteTodoList(vo);

        // 리턴하는 map 생성
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);

        // 리턴
        return resultMap;
    }

}
