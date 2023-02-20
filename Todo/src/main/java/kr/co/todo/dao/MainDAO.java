package kr.co.todo.dao;

import kr.co.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
@Repository
public interface MainDAO {
    /**
     * 리스트 생성
     */

    public int insertTodoList(TodoVO vo);
    /**
     * 리스트 불라오기
     */

    public List<TodoVO> selectTodoList();

    /**
     * 리스트 업데이트
     */
    public int updateTodoList(Map<String, String> data);

    /**
     * 투두리스트 삭제
     */
    public int deleteTodoList(TodoVO vo);

}