<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p align="center">
		<a href="<%= request.getParameter("path") %>main.jsp">[HOME]</a>
		<a href="<%= request.getParameter("path") %>bbs/list.jsp">[BBS]</a>
		<a href="">[LOGIN]</a>
		<a href="">[ETC]</a>
	</p>
</body>
</html>