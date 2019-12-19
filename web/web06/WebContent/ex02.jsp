<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% int a = 4321; %>
	<h1>ex02 page</h1>
	<p>02 <%= request.getParameter("msg") %></p>
	<p>02 <%= request.getParameter("abc") %></p>
	<p>02 content3</p>
	<p>02 content4</p>
	<p>02 content5</p>
</body>
</html>