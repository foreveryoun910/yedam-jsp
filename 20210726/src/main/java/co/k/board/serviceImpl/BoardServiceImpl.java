package co.k.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.k.board.dao.DAO;
import co.k.board.service.BoardService;
import co.k.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 게시판 목록 가져오기
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board order by bid desc";
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bid")); // 테이블의 컬럼명과 같게 써준다(대소문자 구분x)
				vo.setbTitle(rs.getString("btitle"));
				//vo.setbContent(rs.getString("bcontent")); // 게시글 목록에 글 내용은 불러올 필요x
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 한 행 가져오기 (게시글 하나 조회하기, 상세조회)
		String sql = "select * from board where bid = ?";
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid")); // 테이블의 컬럼명과 같게 써준다(대소문자 구분x)
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent")); // 게시글 목록에 글 내용은 불러올 필요x
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				
				hitUpdate(vo.getbId()); // 조회수 증가 메소드 // 그 아이디(게시글번호)의 조회수를 증가한다?
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return vo;
	}

	private void hitUpdate(int id) {
		// TODO 조회수 증가 (게시글을 읽으면 조회수가 증가한다)
		String sql = "update board set bhit = bhit + 1 where bid = ?";
		// conn = DAO.getConnection(); // 이미 열려 있으니까 커넥션 필요없음
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); // 넘어온 id를 담아준다
			psmt.executeUpdate(); // int n = psmt.executeUpdate(); : ok
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // void 타입이라서 return도 필요없음

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO 게시글 작성
		String sql = "insert into board(bid, btitle, bcontent, bwriter, bdate) values(b_seq.nextval, ?, ?, ?, ?)";
		int n = 0;
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO 한 행 삭제 (게시글 삭제)
		String sql = "delete from board where bid = ?";
		int n = 0;
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return n;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO 게시글 제목, 내용 수정
		String sql = "update board set btitle = ?, bcontent = ? where bid = ?";
		int n = 0;
		conn = DAO.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return n;
	}

	
	
	private void close() {
		// TODO 연결 종료
		
		try { // 역순으로 닫아준다(rs를 제일 마지막에 여니까 제일 먼저 닫아줌)
			if(rs != null) { // rs가 열려있으면
				rs.close();
			}
			if(psmt != null) { // psmt가 열려있으면
				psmt.close();
			}
			if(conn != null) { // conn이 열려있으면
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
