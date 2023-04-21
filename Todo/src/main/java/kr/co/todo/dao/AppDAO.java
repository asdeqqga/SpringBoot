package kr.co.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.todo.vo.TodoVO;

@Mapper
@Repository
public interface AppDAO {
	
	public void insertTodo(TodoVO vo);
	public List<TodoVO> selectTodos();
	public TodoVO selectTodo(int TodoNUM);
	public void deleteTodo(int TodoNUM);
	public void deleteTodoAll();

}
