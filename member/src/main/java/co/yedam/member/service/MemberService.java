package co.yedam.member.service;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberSelectList(); // 회원전체목록 조회(R)
	MemberVO memberSelect(MemberVO vo); // 한명의 회원 조회(R)
	int memberInsert(MemberVO vo);		// 회원 추가(C)
	int memberDelete(MemberVO vo);		// 회원 삭제(D)
	int memberUpdate(MemberVO vo);		// 회원 정보 변경(U)
}
