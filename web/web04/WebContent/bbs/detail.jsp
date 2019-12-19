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
<h1>�� ������</h1>
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
	int num = Integer.parseInt(request.getParameter("idx"));
	String sql = "SELECT A.NUM, A.NALJA, B.NICK, A.CNT, A.SUB, A.CONTENT FROM BBS01 A, BBS01USER B WHERE A.ID = B.ID AND NUM="+num;
//	try�� (jdk 1.7 ���� ����)
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
		<td>�۹�ȣ</td>
		<td><%= rs.getInt("num") %></td>
		<td>��¥</td>
		<td><%= rs.getDate("nalja") %></td>
	</tr>
	<tr>
		<td>�۾���</td>
		<td><%= rs.getString("nick") %></td>
		<td>��ȸ��</td>
		<td><%= rs.getInt("cnt") %></td>
	</tr>
	<tr>
		<td>����</td>
		<td colspan="3"><%= rs.getString("sub") %></td>
	</tr>
	<tr>
		<td colspan="4"><%= rs.getString("content").replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td colspan="4">
			<ul class="comm_btns">
				<li><a href="edit.jsp?idx=<%= rs.getInt("num") %>">����</a></li>
				<li><a href="delete.jsp?idx=<%= rs.getInt("num") %>">����</a></li>
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