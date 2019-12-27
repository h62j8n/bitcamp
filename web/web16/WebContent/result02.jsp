<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>

<%
	int cnt = 0;
	String name = null;
	
	String sql = "SELECT COUNT(IDX), MAX(ID) FROM BBS01USER WHERE ID = ? AND PW = ?";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName(driver);
	try {
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, request.getParameter("id"));
		pstmt.setString(2, request.getParameter("pw"));
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = rs.getInt(1);
			name = rs.getString(2);
		}
		
	} finally {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
%>

<logins>
	<login>
		<result><%= cnt %></result>
		<name><%= name %></name>
	</login>
</logins>
