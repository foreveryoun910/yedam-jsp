package co.k.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.k.prj.board.service.BoardMapper;
import co.k.prj.board.service.BoardService;
import co.k.prj.board.vo.CommentsVO;
import co.k.prj.board.vo.SnsVO;
import co.k.prj.common.DataSource;

public class BoardServiceImpl implements BoardService {
	// Mybatis를 통해 데이터베이스를 연결한다.
	private SqlSession sqlSession = DataSource.getInstance().openSession();
	// Mapper Interface 사용한다.
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<SnsVO> snsSelectList() {
		return map.snsSelectList();
	}

	@Override
	public List<SnsVO> snsSelect(SnsVO vo) {
		return map.snsSelect(vo);
	}

	@Override
	public CommentsVO commentsSelect(CommentsVO vo) {
		return map.commentsSelect(vo);
	}

	@Override
	public int snsInsert(SnsVO vo) {
		return map.snsInsert(vo);
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		return map.commentsInsert(vo);
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		return map.snsUpdate(vo);
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		return map.commentsUpdate(vo);
	}

	@Override
	public int snsDelete(SnsVO vo) {
		return map.snsDelete(vo);
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		return map.commentsDelete(vo);
	}

}
