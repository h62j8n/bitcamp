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
	<h1>��������</h1>
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
	
	<p>��ȣ : <%= bean.getNum() %></p>
	<p>
		�ۼ��� : <%= bean.getNick() %><br>
		��¥ : <%= bean.getNalja() %><br>
		��ȸ : <%= bean.getCnt() %><br>
	</p>
	<p>���� : <%= bean.getSub() %></p>
	<p><%= bean.getContent() %></p>
	<%
		Object obj = (Bbs01userBean) session.getAttribute("login");
		if (obj != null) {								// �α����� �ߴٸ�
			Bbs01userBean login = (Bbs01userBean) obj;
			String wId = bean.getId();
			String loginId = login.getId();
			if (wId.equals(loginId)) {					// �Խù� �ۼ��ڰ� �´ٸ�
	%>
	<p>
	<a href="edit.jsp?num=<%= bean.getNum() %>" class="comm_btn">����</a>
	<a href="delete.jsp?num=<%= bean.getNum() %>" class="comm_btn">����</a>
	</p>
	<%
			}
		}
	%>
</body>
</html>