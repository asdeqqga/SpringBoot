package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User3DAO;
import kr.co.ch07.repository.User3Repo;
import kr.co.ch07.vo.User3VO;

@Service
public class User3Service {
	
	@Autowired
	private User3DAO dao;
	
	@Autowired
	private User3Repo repo;

	public void insertUser3(User3VO vo) {
		// Mybatis
		//dao.insertUser1(vo);
		
		// JPA
		repo.save(vo);		
	}
	
	public User3VO selectUser3(String uid) {
		// Mybatis
		//User1VO user = dao.selectUser1(uid);
		
		// JPA
		User3VO user = repo.findById(uid).get();
		
		return user;
	}
	
	public List<User3VO> selectUser3s() {
		// Mybatis
		//List<User1VO> users = dao.selectUser1s();
		
		// JPA
		List<User3VO> users = repo.findAll();
		
		return users;
	}
	public void updateUser3(User3VO vo) {
		// Mybatis
		//dao.updateUser1(vo);
		
		// JPA
		repo.save(vo);
	}
	public void deleteUser3(String uid) {
		// Mybatis
		//dao.deleteUser1(uid);
		
		// JPA
		repo.deleteById(uid);
	}
}
