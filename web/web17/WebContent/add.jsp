<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.web17.*" %>
<%
	String sub = request.getParameter("sub");
	String id = request.getParameter("id");
	String content = request.getParameter("content");
	BbsDao dao = new BbsDao();
	dao.add(sub, id, content);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>

</body>
</html>