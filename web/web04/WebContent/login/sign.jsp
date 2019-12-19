<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nick = request.getParameter("nick");
	
	Connection conn = null;
	Statement stmt = null;
	String sql ="INSERT INTO BBS01USER VALUES (bbs01user_seq.NEXTVAL, '"+id+"', '"+pw+"', '"+nick+"')";
	if (request.getMethod().equals("POST")) {
		try {
			conn = BitOracle.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			session.setAttribute("login", true);
			session.setAttribute("id", id);
			session.setAttribute("nick", nick);
			response.sendRedirect("success.jsp");
		} finally {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
	} else if (session.getAttribute("login") != null) {
		response.sendRedirect("success.jsp");
		return;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jsp" %>
<%@ include file="../template/menu.jsp" %>
<h1>회원가입</h1>
<form method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="pw">
			</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td>
				<input type="text" name="nick">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="가입">
			</td>
		</tr>
	</table>
</form>
<%@ include file="../template/footer.jsp" %>
</body>
</html>