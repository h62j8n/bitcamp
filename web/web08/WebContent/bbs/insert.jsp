<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.bit.web08.Bbs01Dto"></jsp:useBean>
	<jsp:setProperty property="sub" name="bean" />
	<jsp:setProperty property="content" name="bean" />
	<p>제목 : <jsp:getProperty property="sub" name="bean" /></p>
	<p>내용 : <jsp:getProperty property="content" name="bean" /></p>
</body>
</html>