<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ex02</h1>
	<!-- 
	<p>id: <%= request.getAttribute("id") %></p>
	 -->
	 <p>id: ${bean.id}</p>
	 <p>pw: ${bean.pw}</p>
</body>
</html>