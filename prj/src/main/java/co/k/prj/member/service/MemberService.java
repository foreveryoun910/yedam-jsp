package co.k.prj.member.service;

import java.util.List;

import co.k.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 전체회원리스트
	MemberVO memberSelect(MemberVO vo); // 회원조회
	MemberVO memberLogin(MemberVO vo); // 로그인
	int memberInsert(MemberVO vo); // 회원가입
	int memberUpdate(MemberVO vo); // 회원정보변경
	int memberDelete(MemberVO vo); // 회원탈퇴
}
