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
<div class="bbs_list">
	<h1>목록</h1>
	<p class="comm_btn"><a href="add.jsp">입력</a></p>
	<table>
		<tr>
			<th width="10%">번호</th>
			<th width="60%">제목</th>
			<th width="20%">작성자</th>
			<th width="10%">조회수</th>
		</tr>
		<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
		<%
		// String sql = "SELECT * FROM BBS01 ORDER BY NUM DESC";
		String sql = "SELECT A.NUM, B.NICK, A.SUB, A.CNT FROM BBS01 A, BBS01USER B WHERE A.ID = B.ID ORDER BY NUM DESC";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = BitOracle.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
		%>
		<tr>
			<td><%= rs.getInt("num") %></td>
			<td><a href="detail.jsp?idx=<%= rs.getInt("num") %>"><%= rs.getString("sub") %></a></td>
			<td><%= rs.getString("nick") %></td>
			<td><%= rs.getInt("cnt") %></td>
		</tr>
		<%
			}
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (BitOracle.getConnection() != null)
				BitOracle.getConnection().close();
		}
		%>
	</table>
	<p class="comm_btn"><a href="add.jsp">입력</a></p>
	<%@ include file="../template/footer.jsp" %>
</div>
</body>
</html>