package com.bit.mvc01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	private static Connection conn;
	private final static String driver = "oracle.jdbc.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String user = "scott";
	private final static String password = "tiger";
	
	private MyOracle() {
		
	}
	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
