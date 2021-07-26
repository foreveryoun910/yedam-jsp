package co.k.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.board.service.BoardService;
import co.k.board.serviceImpl.BoardServiceImpl;
import co.k.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 입력
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbWriter(request.getParameter("bWriter"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n = dao.boardInsert(vo);
		
		String page = "";
		if(n != 0) {
			page = "boardList.do";
		} else {
			page = "board/boardErrorPage";
		}
		return page;
	}

}
