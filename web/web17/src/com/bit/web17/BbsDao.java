package com.bit.web17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbsDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public BbsDao() throws ClassNotFoundException, SQLException {
		getConnection();
	} // 积己磊甫 烹秦 目池记 按眉 积己
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public ArrayList<BbsDto> getList() throws SQLException {
		String sql = "SELECT * FROM BBS01 ORDER BY NUM DESC";
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto bean = new BbsDto();
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setId(rs.getString("id"));
				list.add(bean);
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return list;
	}
	
	public void add(String sub, String id, String content) throws SQLException {
		String sql = "INSERT INTO BBS01 VALUES (BBS01_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	public BbsDto getBean(int num) throws SQLException {
		String sql = "SELECT * FROM BBS01 WHERE NUM = ?";
		BbsDto bean = new BbsDto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("sub"));
				bean.setId(rs.getString("id"));
				bean.setContent(rs.getString("content"));
				bean.setNalja(rs.getDate("nalja"));
			}
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bean;
	}
	
	public void update(String sub, String content, int num) throws SQLException {
		String sql = "UPDATE BBS01 SET SUB = ?, CONTENT = ?, WHERE NUM = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
		} finally {
			
		}
	}
}
