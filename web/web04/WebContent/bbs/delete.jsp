<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.bit.oracle.BitOracle, java.sql.*" %>
<%
if (request.getMethod().equals("POST")) {
	int num = Integer.parseInt(request.getParameter("num"));
	String sql = "delete from bbs01 where num="+num;
	Connection conn = null;
	Statement stmt = null;
	try {
		conn = BitOracle.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		response.sendRedirect("list.jsp");
	} finally {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
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
<div class="bbs_list">
	<h1>삭제 확인</h1>
	<form method="post">
		<table>
			<tr>
				<td>
					<input type="hidden" name="num" value="<%= request.getParameter("idx") %>">
					삭제하시겠습니까?
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
				<td><a href="javascript:history.back()">취소</a></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../template/footer.jsp" %>
</body>
</html>