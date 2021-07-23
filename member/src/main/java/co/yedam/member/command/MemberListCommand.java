package co.yedam.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 전체 목록 보기
		MemberService dao = new MemberServiceImpl(); // 모델을 호출
		List<MemberVO> members = new ArrayList<MemberVO>(); // List 객체가 추상 클래스라서 -> ArrayList
		members = dao.memberSelectList(); // 결과값을 담을 그릇을 만든다(데이터를 가져온다)
		request.setAttribute("list", members); // 페이지에 값을 전달 // 페이지에서 쓸 이름: list, list에 members를 실어보낸다
		
		return "member/memberList"; // 보여줄 페이지 선택
	}

}
