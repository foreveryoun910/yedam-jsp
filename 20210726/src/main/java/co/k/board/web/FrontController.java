package co.k.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.board.command.BoardList;
import co.k.board.command.BoardSelect;
import co.k.board.command.Command;
import co.k.board.command.DeleteBoard;
import co.k.board.command.HomeCommand;
import co.k.board.command.InsertBoard;
import co.k.board.command.InsertForm;
import co.k.board.command.UpdateForm;

@WebServlet("*.do") // 어노테이션을 활용해 servlet mapping 해주는 방법
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO 사용할 Command를 정의 (Command 초기화, 생성한다는 개념)
		map.put("/home.do", new HomeCommand()); // 홈
		map.put("/boardList.do", new BoardList()); // 게시글 목록 (전체조회)
		map.put("/boardSelect.do", new BoardSelect()); // 게시글 상세조회
		map.put("/insertForm.do", new InsertForm()); // 게시글 입력폼
		map.put("/insertBoard.do", new InsertBoard()); // 게시글 입력
		map.put("/deleteBoard.do", new DeleteBoard()); // 게시글 삭제
		map.put("/updateForm.do", new UpdateForm()); // 게시글 수정
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 실제 수행 부분을 분석하고, 실행하고, 리턴페이지를 돌려준다
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command command = map.get(path); // map에 key값으로 path 넣어주기
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
