package co.k.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAO {
	private static SqlSessionFactory sqlSession;
	
	private DAO() {}; // 싱글톤
	
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource); // 여기에 resource 파일을 집어넣는다.
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream); // resource가 들어있는 inputStream을 session에 넣는다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
