package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.k.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃
		HttpSession session = request.getSession();
		String message = session.getAttribute("name") + "님 정상 로그아웃 되었습니다.";
		session.removeAttribute("name"); // name 없앰 --> 유효아이디는 살아있다!
		session.removeAttribute("author"); // author 없앰 --> 유효아이디는 살아있다!
		//session.invalidate(); // session을 완전히 삭제한다. // .remove: session은 두고 그 안의 내용만 삭제, 세션 유효 아이디는 남겨두는 것??? ex)로그인 안 하고 장바구니에 넣어놓은 거 로그인해도 고대로 있는 것!
		request.setAttribute("message", message);
		return "member/memberError";
	}

}
