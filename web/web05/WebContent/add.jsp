<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, com.bit.web05.*" %>
<%!
	Connection conn;
	Statement stmt;
%>
<%
Object obj = session.getAttribute("login");
if (obj == null) {
	response.sendRedirect("login.jsp");
} else if (request.getMethod().equals("POST")) {
	String sub = request.getParameter("sub");
	String content = request.getParameter("content");
	String id = ((Bbs01userBean)obj).getId();
	String sql = "INSERT INTO BBS01 VALUES (bbs01_seq.nextval, '"+sub+"', '"+id+"', '"+content+"', SYSDATE, 0)";
	
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		response.sendRedirect("/web05/");
	} finally {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://localhost:8080/web05/layout.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<h1>입력</h1>
	<form method="post">
		<p>제목 : <input type="text" name="sub"></p>
		<textarea name="content"></textarea>
		<p><input type="submit" value="입력" class="comm_btn"></p>
	</form>
</body>
</html>