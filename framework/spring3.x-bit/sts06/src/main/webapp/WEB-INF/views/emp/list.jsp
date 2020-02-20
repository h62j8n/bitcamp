<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>LIST</h1>
	<p><a href="add">입력</a></p>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${list}" var="bean">
		<c:url value="detail" var="one">
			<c:param name="sabun" value="${bean.sabun}"></c:param>
		</c:url>
		<tr>
			<td>${bean.sabun}</td>
			<td><a href="${one}">${bean.name}</a></td>
			<td>${bean.nalja}</td>
			<td>${bean.pay}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>