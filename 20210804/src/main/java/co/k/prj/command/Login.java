package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.common.Command;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.serviceImpl.MemberServiceImpl;
import co.k.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPassword("1234");
		vo.setCheck("login");
		request.setAttribute("member", memberDao.memberSelect(vo));
		return "member/loginResult";
	}

}
