package co.yedam.shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO extends DAO {
	PreparedStatement psmt;
	
	// 삭제
	public void deleteItem(String itemNo) {
		String sql = "delete from shop where item_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, itemNo);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {disconnect();}
	}
	
	
	// 한건입력
	public void insertItem(ShopVO vo) {
		String sql = "insert into shop(item_no, item_name, item_desc, like_it, price, price_off, image) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false); // 이 설정주면 auto commit 안 됨.
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemNo());
			psmt.setString(2, vo.getItemName());
			psmt.setString(3, vo.getItemDesc());
			psmt.setDouble(4, vo.getLikeIt());
			psmt.setInt(5, vo.getPrice());
			psmt.setInt(6, vo.getPriceOff());
			psmt.setString(7, vo.getImage());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
			
			conn.commit(); // 모두 처리가 되면 커밋.
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 에러가 나면 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		} finally {disconnect();}
	}
	
	// 전체리스트
	public List<ShopVO> getItemList() {
		List<ShopVO> list = new ArrayList<ShopVO>();
		try {
			PreparedStatement psmt = conn.prepareStatement("select * from shop");
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setItemNo(rs.getString("item_no"));
				vo.setItemName(rs.getString("item_name"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setLikeIt(rs.getDouble("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setPriceOff(rs.getInt("price_off"));
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {disconnect();}
		return list;
	}
}
