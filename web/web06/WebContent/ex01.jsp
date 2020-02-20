<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01 page</h1>
	<p>01 <%= request.getParameter("msg") %></p>
	<% int a = 1234; %>
	<jsp:include page="ex02.jsp">
		<jsp:param value="<%= a %>" name="abc" />
	</jsp:include>
	<p>01 content2</p>
	<p>01 content3</p>
	<p>01 content4</p>
	<p>01 content5</p>
</body>
</html>