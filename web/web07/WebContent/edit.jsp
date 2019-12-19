<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.bit.dto.Bbs02Bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="connection.jspf" %>
<%
	Bbs02Bean bean = new Bbs02Bean();
	int num = Integer.parseInt(request.getParameter("num"));
	String sql = null;
	try {
		conn = getConnection();
		
		if (request.getMethod().equals("GET")) {
			sql = "SELECT * FROM bbs02 WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setId(rs.getString("id"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
			}
		} else if (request.getMethod().equals("POST")) {
			String sub = request.getParameter("sub");
			String content = request.getParameter("content");
			
			sql = "UPDATE bbs02 SET sub = ?, content = ? WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
			
			response.sendRedirect("detail.jsp?num="+num);
		}
	} finally {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
%>
	<h1>게시물 수정</h1>
	<form method="post">
		<p>
			<input type="hidden" name="num" value="<%= bean.getSub() %>">
			번호 : <%= bean.getNum() %>
		</p>
		<p>작성자 : <%= bean.getId() %></p>
		<p>날짜 : <%= bean.getNalja() %></p>
		<p>제목 : <input type="text" name="sub" value="<%= bean.getSub() %>"></p>
		<p>
			<textarea name="content" rows="5" cols="50"></textarea>
		</p>
		<p><input type="submit" value="작성"></p>
	</form>
</body>
</html>