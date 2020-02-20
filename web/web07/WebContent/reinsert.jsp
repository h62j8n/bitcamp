<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="connection.jspf" %>
<%
	String id = request.getParameter("id");
	String sub = request.getParameter("sub");
	String content = request.getParameter("content");
	int ref = Integer.parseInt(request.getParameter("ref"));
	int no = Integer.parseInt(request.getParameter("no"));
	int lev = Integer.parseInt(request.getParameter("lev"));
	
	PreparedStatement pstmt2 = null;
	// 같거나 큰 "?"는 다 증가시킨다.
	String sql = "UPDATE bbs02 SET num_no = num_no+1 WHERE num_no >= ?";
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		sql = "INSERT INTO bbs02 VALUES (bbs02_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, sub);
		pstmt.setString(3, content);
		pstmt.setInt(4, ref);
		pstmt.setInt(5, no);
		pstmt.setInt(6, lev+1);
		pstmt.executeUpdate();
		
	} finally {
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
	
	response.sendRedirect("/web07/");
%>
</body>
</html>