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
	<h1>상세페이지</h1>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String sql = "SELECT A.id, A.num, B.nick, A.nalja, A.cnt, A.sub, A.content "
				+"FROM bbs01 A INNER JOIN bbs01user B ON A.id = B.id WHERE A.num = "+num;
		
		JavaBean bean = new JavaBean();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
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
	%>
	
	<p>번호 : <%= bean.getNum() %></p>
	<p>
		작성자 : <%= bean.getNick() %><br>
		날짜 : <%= bean.getNalja() %><br>
		조회 : <%= bean.getCnt() %><br>
	</p>
	<p>제목 : <%= bean.getSub() %></p>
	<p><%= bean.getContent() %></p>
	<%
		Object obj = (Bbs01userBean) session.getAttribute("login");
		if (obj != null) {								// 로그인을 했다면
			Bbs01userBean login = (Bbs01userBean) obj;
			String wId = bean.getId();
			String loginId = login.getId();
			if (wId.equals(loginId)) {					// 게시물 작성자가 맞다면
	%>
	<p>
	<a href="edit.jsp?num=<%= bean.getNum() %>" class="comm_btn">수정</a>
	<a href="delete.jsp?num=<%= bean.getNum() %>" class="comm_btn">삭제</a>
	</p>
	<%
			}
		}
	%>
</body>
</html>