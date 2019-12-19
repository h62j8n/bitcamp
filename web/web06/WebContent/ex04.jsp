<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>usebean page</h1>
	<jsp:useBean id="bean" class="com.bit.bean.JavaBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="num" name="bean" value="1234" />
	<jsp:setProperty property="msg" name="bean" value="abcd" />
	<p>num : <jsp:getProperty name="bean" property="num" /></p>
	<p>msg : <jsp:getProperty name="bean" property="msg" /></p>
</body>
</html>