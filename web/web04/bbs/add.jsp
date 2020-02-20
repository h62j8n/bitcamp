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
<h1>입력 페이지</h1>
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
	String nick = null;
	if (session.getAttribute("login") == null) {	// 로그인한 사람만 글을 작성할 수 있다.
		response.sendRedirect("../login/form.jsp");
	}
	String sub = request.getParameter("sub");
	String id = request.getParameter("id");
	String content = request.getParameter("content");
	String sql ="INSERT INTO BBS01 VALUES (BBS01_SEQ.NEXTVAL, '"+sub+"', '"+id+"', '"+content+"', SYSDATE, 0)";
//	System.out.println(sql);
	Connection conn = null;
	Statement stmt = null;
	// form의 method가 post라면 list.jsp로 리다이렉트
	if (request.getMethod().equals("POST")) {
		try {
			conn = BitOracle.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} finally {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		response.sendRedirect("list.jsp");
	}
%>
<form method="post">
	<table width="85%" align="center">
		<tr>
			<td width="10%">제목</td>
			<td><input type="text" name="sub"></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td>
				<input type="hidden" name="id" value="<%= session.getAttribute("id") %>">
				<%= session.getAttribute("nick") %>
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="입력">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
<%@ include file="../template/footer.jsp" %>
</body>
</html>