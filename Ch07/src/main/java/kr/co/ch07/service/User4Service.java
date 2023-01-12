package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User4DAO;
import kr.co.ch07.repository.User4Repo;
import kr.co.ch07.vo.User4VO;

@Service
public class User4Service {
	
	@Autowired
	private User4DAO dao;
	
	@Autowired
	private User4Repo repo;

	public void insertUser4(User4VO vo) {
		// Mybatis
		//dao.insertUser1(vo);
		
		// JPA
		repo.save(vo);		
	}
	
	public User4VO selectUser4(String uid) {
		// Mybatis
		//User1VO user = dao.selectUser1(uid);
		
		// JPA
		User4VO user = repo.findById(uid).get();
		
		return user;
	}
	
	public List<User4VO> selectUser4s() {
		// Mybatis
		//List<User1VO> users = dao.selectUser1s();
		
		// JPA
		List<User4VO> users = repo.findAll();
		
		return users;
	}
	public void updateUser4(User4VO vo) {
		// Mybatis
		//dao.updateUser1(vo);
		
		// JPA
		repo.save(vo);
	}
	public void deleteUser4(String uid) {
		// Mybatis
		//dao.deleteUser1(uid);
		
		// JPA
		repo.deleteById(uid);
	}
}
