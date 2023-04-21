package kr.co.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.todo.Service.*;
import kr.co.todo.vo.TodoVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppController {

	@Autowired
    private AppService service;
	
	@GetMapping("/app/todos")
    public List<TodoVO> todos() {
    	return service.selectTodos();
    }
    
	@PostMapping("/app/todo")
    public void todo(@RequestBody TodoVO vo) {
		log.info("content : " + vo.getTodoContent());
		service.insertTodo(vo);
    }
	
	@DeleteMapping("/app/clear")
    public void clear() {
		service.deleteTodoAll();
    }
	
}