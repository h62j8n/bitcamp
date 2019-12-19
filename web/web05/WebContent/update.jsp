<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, com.bit.web05.*" %>
<%!
	Connection conn;
	Statement stmt;
%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String sub = request.getParameter("sub");
	String content = request.getParameter("content");
	String sql="UPDATE bbs01 SET sub = '"+sub+"', content = '"+content+"' WHERE NUM = "+num;
	
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		if (stmt.executeUpdate(sql) > 0) {
			response.sendRedirect("detail.jsp?num="+num);
		} else {
			response.sendRedirect("edit.jsp?num="+num);
		}
	} finally {
		if (conn != null) conn.close();
		if (stmt != null) stmt.close();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>