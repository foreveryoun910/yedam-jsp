package co.k.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.board.service.BoardService;
import co.k.board.serviceImpl.BoardServiceImpl;
import co.k.board.vo.BoardVO;

public class DeleteBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 삭제
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		String page = "";
		return page;
	}

}
