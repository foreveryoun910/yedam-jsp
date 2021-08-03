package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.common.Command;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.serviceImpl.MemberServiceImpl;
import co.k.prj.member.vo.MemberVO;

public class MemberSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원조회
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = memberDao.memberSelect(vo);
		request.setAttribute("member", vo);
		
		return "member/memberSelect";
	}

}
