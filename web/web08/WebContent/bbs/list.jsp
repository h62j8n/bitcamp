<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.bit.web08.*, java.util.ArrayList, java.text.SimpleDateFormat, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../template/header.jsp">
		<jsp:param value="../" name="path" />
	</jsp:include>
	<jsp:include page="../template/menu.jsp">
		<jsp:param value="../" name="path" />
	</jsp:include>
	<h2>게시판 목록</h2>
	<a href="add.jsp">[입 력]</a>
	<table width="500">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
		<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String sql = "SELECT * FROM bbs01 ORDER BY num desc";
		

		
		ArrayList<Bbs01Dto> list = Bbs01Dao.list();
		for (int i=0; i<list.size(); i++) {
			Bbs01Dto bean = list.get(i);
		%>
		<tr>
			<td><%= bean.getNum() %></td>
			<td><%= bean.getSub() %></td>
			<td><%= bean.getContent() %></td>
			<td><%= sdf.format(bean.getNalja()) %></td>
			<td><%= bean.getCnt() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>