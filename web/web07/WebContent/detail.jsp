<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"  import="com.bit.dto.Bbs02Bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="connection.jspf" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String sql = "SELECT * FROM bbs02 WHERE num = ?";
	Bbs02Bean bean = new Bbs02Bean();
	
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			bean.setNum(rs.getInt("num"));
			bean.setId(rs.getString("id"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setSub(rs.getString("sub"));
			bean.setContent(rs.getString("content"));
			bean.setNum_ref(rs.getInt("num_ref"));
			bean.setNum_no(rs.getInt("num_no"));
			bean.setNum_lev(rs.getInt("num_lev"));
		}
		
	} finally {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
%>
	<h1>게시물 상세</h1>
	<p>번호 : <%= bean.getNum() %></p>
	<p>작성자 : <%= bean.getId() %></p>
	<p>날짜 : <%= bean.getNalja() %></p>
	<p>제목 : <%= bean.getSub() %></p>
	<p><%= bean.getContent() %></p>
	<p>
		<a href="edit.jsp?num=<%= bean.getNum() %>">수정</a>
		<a href="del.jsp?num=<%= bean.getNum() %>">삭제</a>
		<a href="readd.jsp?ref=<%= bean.getNum_ref() %>&no=<%= bean.getNum_no() %>&lev=<%= bean.getNum_lev() %>">답글</a>
	</p>
</body>
</html>