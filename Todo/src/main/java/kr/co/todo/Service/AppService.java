package kr.co.todo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.todo.dao.AppDAO;
import kr.co.todo.vo.TodoVO;

@Service
public class AppService {
	
	@Autowired
	private AppDAO dao;
	
	public void insertTodo(TodoVO vo) {
		dao.insertTodo(vo);
	}
	
	public List<TodoVO> selectTodos() {
		return dao.selectTodos();
	}
	
	public TodoVO selectTodo(int todoNUM) {
		return dao.selectTodo(todoNUM);
	}
	
	public void deleteTodo(int todoNUM) {
		dao.deleteTodo(todoNUM);
	}
	
	public void deleteTodoAll() {
		dao.deleteTodoAll();
	}

}
