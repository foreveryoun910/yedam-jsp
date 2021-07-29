package co.k.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.k.prj.dao.DataSource;
import co.k.prj.member.service.MemberService;
import co.k.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dataSource = DataSource.getInstance(); // dao 선언, 싱글톤 불러오는 법
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO 전체회원리스트
		String sql = "select * from member where state='Y'";
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				vo.setAuthor(rs.getString("author"));
				vo.setState(rs.getString("state").charAt(0));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO 회원조회
		String sql = "select * from member where id = ?";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				vo.setAuthor(rs.getString("author"));
				vo.setState(rs.getString("state").charAt(0));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return vo;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO 로그인
		String sql = "select name, author from member where id = ? and password = ? and state = 'Y'";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 회원가입
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 회원정보변경
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO 회원탈퇴
		return 0;
	}

	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
