<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>문제 발생</h1>
	<p>일시적인 문제가 발생하였습니다.</p>
	<p>잠시 후 다시 접속해주세요.</p>
	<p><%= exception.getMessage() %></p>
</body>
</html>