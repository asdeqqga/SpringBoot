package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.MemberDAO;
import kr.co.ch09.dao.User1DAO;
import kr.co.ch09.vo.User1VO;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}
	public MemberVO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	public List<MemberVO> selectMembers() {
		return dao.selectMembers();
	}
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	public void deleteMember(String uid) {
		dao.deleteMember(uid);
	}
}