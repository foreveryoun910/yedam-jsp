package co.k.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.common.Command;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.serviceImpl.MemberServiceImpl;
import co.k.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원리스트
		MemberService memberDao = new MemberServiceImpl();
		List<MemberVO> list = memberDao.memberSelectList();
		request.setAttribute("members", list);
		return "member/memberList";
	}

}
