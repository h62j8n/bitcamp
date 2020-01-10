<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg1="page data";
	String msg2="request data";
	String msg3="session data";
	String msg4="application data";
	
	pageContext.setAttribute("obj", msg1);
	request.setAttribute("obj", msg2);
	session.setAttribute("obj",msg3);
	application.setAttribute("obj", msg4);
	%>
	<h1>디폴트 스코프 값은?${obj }</h1>
	<h2> page 스코프 값은?${pageScope.obj }</h2>
	<h2> request 스코프 값은?${requestScope.obj }</h2>
	<h2> session 스코프 값은?${sessionScope.obj }</h2>
	<h2> application 스코프 값은?${applicationScope.obj }</h2>
</body>
</html>
















