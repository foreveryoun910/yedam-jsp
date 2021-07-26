package co.k.board.service;

import java.util.List;

import co.k.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> boardSelectList(); // public을 안 쓰면 protected(default) 형식, 둘 다 ok
	public BoardVO boardSelect(BoardVO vo);
	public int boardInsert(BoardVO vo);
	public int boardDelete(BoardVO vo);
	public int boardUpdate(BoardVO vo);
}
