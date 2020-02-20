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
		// �� Ÿ�� ���ڸ� ���� �� �Ǵٸ� �����ڸ� ȣ���Ͽ� DB�� ����
		this(map.get("driver"), map.get("url"), map.get("user"), map.get("password"));
	}
	
	public ArrayList<Emp02Dto> selectAll() throws SQLException {
		ArrayList<Emp02Dto> list = new ArrayList<Emp02Dto>();
		
		String sql = "SELECT * FROM EMP02 ORDER BY SABUN";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// bean ��ü ������ �����ϴ� �ۼ� ���
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
