package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입 처리
		MemberService dao = new MemberServiceImpl();	
		MemberVO vo = new MemberVO();
		String[] hobbies = request.getParameterValues("hobbies"); // 여기 있는 변수는 form에 있는 변수(checkout으로 입력받은)
		String hobby = "";
		for(String str : hobbies) { // 여러 개 입력받은 거(배열으로 들어오는?) 처리해주기 위해서..
			hobby += str + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		vo.setHobby(hobby);
		int n = dao.memberInsert(vo);
		String view;
		if(n != 0) {
			view = "memberList.do";
		} else {
			request.setAttribute("message", "입력 실패!");
			view = "member/memberInsertFail";
		}
				
		return view;
	}

}
