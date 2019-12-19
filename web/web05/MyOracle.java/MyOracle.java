package com.bit.web05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	private static MyOracle my = new MyOracle();	// #1 객체를 가지고 시작하기 때문에 null값이 나오지 않는다.
	private Connection conn;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "scott";
	private String password = "tiger";
	
	public MyOracle() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			if (my.conn.isClosed()) {				// #2 따라서 커넥션이 끊어지는 경우는 있어도 null값이 나오는 경우는 없다.
				my = new MyOracle();				// 커넥션 생성 시점에 커넥션이 끊어졌다면 객체를 새로 생성하여 진행하면 된다.
			}										// null값을 체크할 필요가 없고, 만일 null일 경우 오류가 날 수 있기 때문에 보다 안전하다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return my.conn;
	}
}
