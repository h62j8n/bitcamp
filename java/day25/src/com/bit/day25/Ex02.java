package com.bit.day25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;

public class Ex02 {
	public static void main(String[] args) {
		OracleDriver driver = null;
		driver = new OracleDriver();
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Properties info = new Properties();
		info.put("user", "scott");
		info.put("password", "tiger");
		
//		String sql = "select * from dept where deptno=10";
		String sql = "select * from dept";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(rs.next());			// true 반환. 커서 이동이 가능한 경우(= 레코드값이 있을 경우) true.
//			rs.next();								// 커서 이동. setType의 특성 상 커서 이동이 없으면 오류
			while (rs.next()) {
				System.out.print(rs.getObject(1)+"\t");
				System.out.print(rs.getObject(2)+"\t");
				System.out.println(rs.getObject(3));
			}
//			System.out.print(rs.getObject(1)+"\t");	// 주의 : 0부터가 아닌 1부터.
//			System.out.print(rs.getObject(2)+"\t");
//			System.out.println(rs.getObject(3));
			System.out.println(rs.next());			// false.
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
