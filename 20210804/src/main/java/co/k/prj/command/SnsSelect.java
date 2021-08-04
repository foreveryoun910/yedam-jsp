package co.k.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.k.prj.board.service.BoardService;
import co.k.prj.board.serviceImpl.BoardServiceImpl;
import co.k.prj.board.vo.SnsVO;
import co.k.prj.common.Command;

public class SnsSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO sns select
		BoardService boardDao = new BoardServiceImpl();
		SnsVO vo = new SnsVO();
		vo.setSNo(1);
//		vo.setsNo(Integer.valueOf(request.getParameter("sNo")));
//		form에서 sNo를 받아와서 쓸 때 이렇게 써야 함!!
		request.setAttribute("list", boardDao.snsSelect(vo));
		
		return "board/snsSelect";
	}

}
