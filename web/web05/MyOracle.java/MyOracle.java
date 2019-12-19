package com.bit.web05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	private static MyOracle my = new MyOracle();	// #1 ��ü�� ������ �����ϱ� ������ null���� ������ �ʴ´�.
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
			if (my.conn.isClosed()) {				// #2 ���� Ŀ�ؼ��� �������� ���� �־ null���� ������ ���� ����.
				my = new MyOracle();				// Ŀ�ؼ� ���� ������ Ŀ�ؼ��� �������ٸ� ��ü�� ���� �����Ͽ� �����ϸ� �ȴ�.
			}										// null���� üũ�� �ʿ䰡 ����, ���� null�� ��� ������ �� �� �ֱ� ������ ���� �����ϴ�.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return my.conn;
	}
}
