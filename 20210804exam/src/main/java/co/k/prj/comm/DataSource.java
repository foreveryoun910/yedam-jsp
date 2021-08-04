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
			// resource의 경로는 pom.xml의 <resources>에서 루트 경로를 설정해줬다.
			String resource = "mybatis-config.xml"; // mybatis-config.xml 또는 /mybatis-config.xml 전부 가능
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
