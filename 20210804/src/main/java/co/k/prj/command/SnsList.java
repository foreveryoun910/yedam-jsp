package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.board.service.BoardService;
import co.k.prj.board.serviceImpl.BoardServiceImpl;
import co.k.prj.common.Command;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO sns 목록 가져오기
		BoardService boardDao = new BoardServiceImpl(); // 초기화
//		List<SnsVO> list = new ArrayList<SnsVO>();
//		list = boardDao.snsSelectList();
		request.setAttribute("list", boardDao.snsSelectList());
		
		return "board/snsList";
	}

}
