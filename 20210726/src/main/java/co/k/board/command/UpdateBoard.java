package co.k.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.board.service.BoardService;
import co.k.board.serviceImpl.BoardServiceImpl;
import co.k.board.vo.BoardVO;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 수정
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = dao.boardUpdate(vo);
		
		String page = "";
		if(n != 0) {
			page = "boardList.do";
		} else {
			page = "board/boardErrorPage";
		}
		return page;
	}

}
