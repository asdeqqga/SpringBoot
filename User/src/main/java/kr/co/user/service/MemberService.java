package kr.co.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.user.dao.MemberDAO;
import kr.co.user.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	public MemberVO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	
	public List<MemberVO> selectMembers(){
		return dao.selectMembers();
	}
}
