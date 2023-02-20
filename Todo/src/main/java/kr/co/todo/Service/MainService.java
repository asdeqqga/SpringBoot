package kr.co.todo.service;

import kr.co.todo.dao.MainDAO;
import kr.co.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MainService {

    @Autowired
    private MainDAO dao;


    /**
     * 투두 리스트 생성
     */
    public int insertTodoList(TodoVO vo) {
         return dao.insertTodoList(vo);
    }

    /**
     * 투두 리스트 불라오기
     * 리스트 불러온후 상태 값에 따라 분리
     * @return 1, 2, 3
     */
    public Map<Integer, List<TodoVO>> selectTodoList() {
        List<TodoVO> list = dao.selectTodoList();
        return list.stream().collect(Collectors.groupingBy(TodoVO::getTodoStatus));
    }

    /**
     * 투두리스트 업데이트
     */
    public int updateTodoList(Map<String, String> data) {
        return dao.updateTodoList(data);
    }


    /**
     * 투두리스트 삭제
     */
    public int deleteTodoList(TodoVO vo) {
        return dao.deleteTodoList(vo);
    }


}
