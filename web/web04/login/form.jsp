<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
if (request.getMethod().equals("POST")) {
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String sql = "select count(*) as cnt, max(nick) as nick from bbs01user where id='"+id+"' and pw='"+pw+"'";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	int result = 0;
	String nick = null;
	try {
		conn = BitOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			result = rs.getInt("cnt");
			nick = rs.getString("nick");
		}
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	if (result > 0) {
		session.setAttribute("login", true);
		session.setAttribute("id", id);
		session.setAttribute("nick", nick);
		response.sendRedirect("success.jsp");
	} else {
		response.sendRedirect("form.jsp");
	}
} else if (session.getAttribute("login") != null) {
	// page < request < session < application
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
<h1>로그인</h1>
<form method="post">
	<table align="center">
		<tr>
			<td>id</td>
			<td>
				<input type="text" name="id">
			</td>
		</tr>
		<tr>
			<td>pw</td>
			<td>
				<input type="password" name="pw">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="sign.jsp">회원가입</a>
			</td>
		</tr>
	</table>
</form>
<%@ include file="../template/footer.jsp" %>
</body>
</html>