package com.bit.day25;

import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;

public class Ex01 {
	public static void main(String[] args) {
		oracle.jdbc.driver.OracleDriver driver = null;					// 오라클 드라이버 (외부 라이브러리)
		driver = new OracleDriver();									// 드라이버 객체 생성
		
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		
//		String url = "jdbc:oracle:thin:@ip:port:sid/";			// 접속할 url (jdbc:oracle:thin: 까지 고정값)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";		// 1521: 오라클 설치 시 세팅한 리스너포트, xe: 설치한 오라클 db이름
		Properties info = new Properties();						// 계정정보
		info.put("user", "scott");
		info.put("password", "tiger");
		
		try {
			conn = java.sql.DriverManager.getConnection(url, info);		// 자바에서 제공하는 sql 포메팅
			System.out.println("접속 성공");
			
//			String sql = "delete from dept where deptno=90";
//			String sql = "update dept set dname = '마케팅', loc = '대전' where deptno = 90";
			String sql = "insert into dept (deptno, dname, loc) values ('90', '임시', '제주')";
			
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);				// 정상 수행 시 1, 수행하지 못했을 경우 0
			if (result > 0) {
				System.out.println("작업성공 ("+result+")");
			} else {
				System.out.println("작업실패 ("+result+")");
			}
			
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
			
		} finally {
			try {
				if (stmt != null) stmt.close();					// 정상적으로 종료 필수
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
