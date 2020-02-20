<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		return;
	}
	
	JavaBean bean = new JavaBean();
	int num = Integer.parseInt(request.getParameter("num"));
	String sql = "SELECT A.id, A.num, B.nick, A.nalja, A.cnt, A.sub, A.content "
			+"FROM bbs01 A INNER JOIN bbs01user B ON A.id = B.id WHERE A.num = "+num;
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			bean.setId(rs.getString("id"));
			bean.setNum(rs.getInt("num"));
			bean.setNick(rs.getString("nick"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setCnt(rs.getInt("cnt"));
			bean.setSub(rs.getString("sub"));
			bean.setContent(rs.getString("content"));
		}
		
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	
	Bbs01userBean user = (Bbs01userBean) obj;
	if (!user.getId().equals(bean.getId())) {
		response.sendRedirect("/web05/");
	}
%>
	<h1>수정</h1>
	<form action="update.jsp" method="post">
		<input type="hidden" name="num" value="<%= bean.getNum() %>">
		<p>번호 : <%= bean.getNum() %></p>
		<p>작성자 : <%= bean.getNick() %></p>
		<p>날짜 : <%= bean.getNalja() %></p>
		<p>조회 : <%= bean.getCnt() %></p>
		<p>제목 : <input type="text" name="sub" value="<%= bean.getSub() %>"></p>
		<p><textarea name="content"><%= bean.getContent() %></textarea></p>
		<input type="submit" value="수정" class="comm_btn">
	</form>
</body>
</html>