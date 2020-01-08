package com.bit.mvc02.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Emp02Dao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Emp02Dao(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	}
	
	public Emp02Dao(Map<String, String> map) throws ClassNotFoundException, SQLException {
		// 맵 타입 인자를 받을 때 또다른 생성자를 호출하여 DB에 연결
		this(map.get("driver"), map.get("url"), map.get("user"), map.get("password"));
	}
	
	public ArrayList<Emp02Dto> selectAll() throws SQLException {
		ArrayList<Emp02Dto> list = new ArrayList<Emp02Dto>();
		
		String sql = "SELECT * FROM EMP02 ORDER BY SABUN";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// bean 객체 생성을 생략하는 작성 방식
				list.add(new Emp02Dto(rs.getInt("sabun"), rs.getString("name"), rs.getDate("nalja"), rs.getInt("deptno")));
			}
			
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return list;
	}
	
	public Emp02Dto selectOne(int sabun) throws SQLException {
		String sql = "SELECT * FROM EMP02 WHERE SABUN = ?";
		Emp02Dto bean = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bean = new Emp02Dto(rs.getInt("sabun"), rs.getString("name"), rs.getDate("nalja"), rs.getInt("deptno"));
			}
			
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}
		
		return bean;
	}
}
