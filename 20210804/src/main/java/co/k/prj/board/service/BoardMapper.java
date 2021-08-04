package co.k.prj.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import co.k.prj.board.vo.CommentsVO;
import co.k.prj.board.vo.SnsVO;

public interface BoardMapper {
	// @Select("select * from sns")
	// 조건 없이 단순하게 select 하는 쿼리는 어노테이션 쓰고 불러오는 ibatis 문법 사용 가능(세미콜론 x)
	// 선호하지 않는 방법, 오류의 위험이 있음, 웬만하면 쓰지 말자!
	List<SnsVO> snsSelectList();
	
	List<SnsVO> snsSelect(SnsVO vo);
	CommentsVO commentsSelect(CommentsVO vo);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelete(CommentsVO vo);
}
