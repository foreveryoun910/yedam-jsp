package co.yedam.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO main.do 요청시 처리하는 곳
		// DB 작업
		// 결과
		return "main/home"; // 보여줄 페이지 선택
	}

}
