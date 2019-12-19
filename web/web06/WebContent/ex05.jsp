<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ex05 page</h1>
	<jsp:useBean id="bean" class="com.bit.bean.JavaBean" scope="session"></jsp:useBean>
	<p>num : <jsp:getProperty property="num" name="bean" /></p>
</body>
</html>