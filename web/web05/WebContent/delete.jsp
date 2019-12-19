<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://localhost:8080/web05/layout.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*, com.bit.web05.*" %>
	<%!
	Connection conn;
	Statement stmt;
	ResultSet rs;
	%>
	<%
	Object obj = session.getAttribute("login");
	if (obj == null) {
		response.sendRedirect("/web05/");
	}
	Bbs01userBean user = (Bbs01userBean) obj;
	String loginId = user.getId();
	
	int num = Integer.parseInt(request.getParameter("num"));
	String sql = "SELECT COUNT(*) FROM bbs01 WHERE num = " + num + " AND id = '" + loginId + "'";
	
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			if (rs.getInt(1) == 0) {				// �� ���� �ƴ϶��
				response.sendRedirect("/web05/");
			}
		}
		if (request.getMethod().equals("POST")) {	// �� ���������� ���� Ȯ���� ������
			sql = "DELETE FROM bbs01 WHERE num = "+num;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			response.sendRedirect("/web05/");
		}
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	%>
	<h1>����</h1>
	<form method="post">
		<p><%= num %>�� ���� �����Ͻðڽ��ϱ�?</p>
		<p>
			<input type="hidden" name="num" value="<%= num %>">
			<input type="submit" value="Ȯ��" class="comm_btn">
		</p>
	</form>
</body>
</html>