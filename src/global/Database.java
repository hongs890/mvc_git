package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @date  : 2016. 7. 1.
 * @author: 배근홍
 * @file  : Database.java
 * @story  :
 */
public class Database {
	private Connection con;
	private String driver,url,id,pw;
	
	public Database(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	public Connection getConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
