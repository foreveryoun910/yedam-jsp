package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.k.prj.common.Command;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.serviceImpl.MemberServiceImpl;
import co.k.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO login 과정을 처리하는 곳
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 세션객체 호출, true/false (default: true)
		System.out.println(session.getId() + "============="); // 유효아이디 확인, 브라우저가 종료되기 전까지 유지된다.
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		String page = "";
		// boolean의 초기값은 false
		if(vo.getName() != null) { // !vo.getName().isEmpty()
			session.setAttribute("name", vo.getName()); // 세션에 담아준다. name이라는 이름에 getName을
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId()); // 세션에 담곘다는 것 -> 한번 실행하면 쭉 세션을 가지고 있겠다는 것
			// ex) 지금 로그인 실행 중에 세션에 넣고 있으니까 로그인하면 세션 쭉 유지하겠다는 뜻?
			page = "member/loginSuccess";
		} else {
			String message = "아이디가 존재하지 않거나 패스워드가 틀립니다.";
			request.setAttribute("message", message);
			page = "member/memberError";
		}
		return page;
	}

}
