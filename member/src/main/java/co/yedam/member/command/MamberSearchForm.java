package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MamberSearchForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 단순 폼 호출 (조회할 폼을 호출하는 역할만)
		return "member/memberSearchForm";
	}

}
