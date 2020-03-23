<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>download page</h1>
	<div>
		<p>sabun:${sabun}</p>
		<c:forEach items="${files}" var="file">
			<p><a href="download/${file}">download</a></p>
		</c:forEach>
	</div>
</body>
</html>