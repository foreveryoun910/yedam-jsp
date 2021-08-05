package co.k.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		try {
			String resource = "config/mybatis-config.xml"; // 리소스 위치 잡아주기
			InputStream inputStream = Resources.getResourceAsStream(resource); // 리소스 읽어오기 - key, value로 읽어온다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("DB 연결 성공!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
