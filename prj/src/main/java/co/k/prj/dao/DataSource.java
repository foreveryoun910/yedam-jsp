package co.k.prj.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource(); // 싱글톤 클래스 생성
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSource() {} // 생성자, 외부에서 생성하지 못하도록 private로 생성자 생성해둠
	
	public static DataSource getInstance() { // 외부에서는 getInstance를 통해서만 사용 가능
		return dataSource;
	}
	
	public Connection getConnection() {
		configure(); // 외부 properties 파일을 읽어온다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void configure() {
		Properties properties = new Properties(); //외부 properties 파일을 읽어오는 객체
		String resource = getClass().getResource("/db.properties").getPath();
		
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
