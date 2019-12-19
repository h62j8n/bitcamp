<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jsp" %>
<%@ include file="../template/menu.jsp" %>
<h1>상세 페이지</h1>
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
	int num = Integer.parseInt(request.getParameter("idx"));
	String sql = "SELECT A.NUM, A.NALJA, B.NICK, A.CNT, A.SUB, A.CONTENT FROM BBS01 A, BBS01USER B WHERE A.ID = B.ID AND NUM="+num;
//	try문 (jdk 1.7 이후 문법)
//	try (Connection conn = BitOracle.getConnection()) {
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		conn = BitOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
%>
<table width="85%" align="center">
	<tr>
		<td>글번호</td>
		<td><%= rs.getInt("num") %></td>
		<td>날짜</td>
		<td><%= rs.getDate("nalja") %></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td><%= rs.getString("nick") %></td>
		<td>조회수</td>
		<td><%= rs.getInt("cnt") %></td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3"><%= rs.getString("sub") %></td>
	</tr>
	<tr>
		<td colspan="4"><%= rs.getString("content").replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td colspan="4">
			<ul class="comm_btns">
				<li><a href="edit.jsp?idx=<%= rs.getInt("num") %>">수정</a></li>
				<li><a href="delete.jsp?idx=<%= rs.getInt("num") %>">삭제</a></li>
			</ul>
		</td>
	</tr>
</table>
<%
		}
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
%>
<%@ include file="../template/footer.jsp" %>
</body>
</html>