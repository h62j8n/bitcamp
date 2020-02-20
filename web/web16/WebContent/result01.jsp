<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
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
		if (cnt > 0) {
	%>
			<h2><%= name %>님 로그인하셨습니다.</h2>
	<%
		} else {
	%>
			<h2>Error</h2>
	<%
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>