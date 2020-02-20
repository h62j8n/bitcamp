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
<%@ page import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
int num = 0;
Date nalja = null;
String nick = null;
int cnt = 0;
String sub = null;
String content = null;

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try {
	conn = BitOracle.getConnection();
	stmt = conn.createStatement();
	if (request.getMethod().equals("GET")) {
		num = Integer.parseInt(request.getParameter("idx"));
		String sql = "SELECT A.NUM, A.NALJA, B.NICK, A.CNT, A.SUB, A.CONTENT FROM BBS01 A, BBS01USER B WHERE A.ID = B.ID AND NUM="+num;
		
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			num = rs.getInt("num");
			nalja = rs.getDate("nalja");
			nick = rs.getString("nick");
			cnt = rs.getInt("cnt");
			sub = rs.getString("sub");
			content = rs.getString("content");
		}
	} else if (request.getMethod().equals("POST")) {
		num = Integer.parseInt(request.getParameter("num"));
		sub = request.getParameter("sub");
		content = request.getParameter("content");
		String sql = "update bbs01 set sub='"+sub+"',content='"+content+"' where num="+num;
		int result = stmt.executeUpdate(sql);
		
		if (result > 0) {
			response.sendRedirect("detail.jsp?idx="+num);
		} else {
			response.sendRedirect("edit.jsp?idx="+num);
		}
	}
} finally {
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (conn != null) conn.close();
}
%>
<div class="bbs_list">
	<h1>수정 페이지</h1>
	<form method="post">
		<table width="85%" border="0">
			<tr>
				<td width="150">글번호</td>
				<td>
					<input type="hidden" name="num" value="<%= num %>">
					<%= num %>
				</td>
				<td width="150">날짜</td>
				<td><%= nalja %></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><%= nick %></td>
				<td>조회수</td>
				<td><%= cnt %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="sub" value="<%= sub %>"></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="content"><%= content %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<ul class="comm_btns">
						<li><input type="submit" value="수정"></li>
						<li><input type="reset" value="취소"></li>
					</ul>
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../template/footer.jsp" %>
</body>
</html>