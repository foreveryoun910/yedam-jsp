package co.k.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.k.prj.common.DAO;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	// DAO 역할을 하는 것
	private SqlSession sqlSession = DAO.getInstance().openSession();
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO 회원리스트
		return sqlSession.selectList("memberSelectList"); // member-map에서 설정해준 이름
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO 회원조회
		return sqlSession.selectOne("memberSelect", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 회원가입
		return sqlSession.insert("memberInsert", vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 회원정보수정
		return sqlSession.update("memberUpdate", vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 회원탈퇴
		return sqlSession.delete("memberDelete", vo);
	}

}
