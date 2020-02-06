<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>LIST PAGE</h1>
	<a href="add.html">입력 (업로드)</a>
	<a href="list.html">목록 (다운로드)</a>
	<a href="add2.html">입력2 (트랜잭션)</a>
	<a href="list.html">목록2 (트랜잭션)</a>
	<%@ page import="java.util.ArrayList, com.bit.mvc04.model.Emp05Dto" %>
	<%
	ArrayList<Emp05Dto> list = (ArrayList<Emp05Dto>)request.getAttribute("list");
	for (Emp05Dto bean : list) {
	%>
	<div>
		<span><%= bean.getSabun() %></span>
		<span><%= bean.getName() %></span>
		<a href="upload/<%= bean.getFile1() %>" target="_blank">[<%= bean.getOrigin() %>]</a>
		<a href="down?file=<%= bean.getFile1() %>&origin=<%= bean.getOrigin() %>">[<%= bean.getOrigin() %>]</a>
	</div>
	<%
	}
	%>
	<div>
		
	</div>
</body>
</html>