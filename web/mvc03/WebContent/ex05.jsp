<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL문법2</h1>
	<h2>제어문(조건문)</h2>
	
	<c:set var="su1" value="3" />
	<c:set var="su2" value="3"/>
	<div>
		<c:if test="${su1 gt  su2 }">su1이 더 큽니다</c:if>
		<c:if test="${su1 lt su2 }">su1이 더 크지 않습니다</c:if>
		<c:if test="${su1 eq su2 }">같습니다</c:if>
	</div>
	<c:set var="su3" value="5"/>
	<div>
		<c:choose>
			<c:when test="${su3 eq 0 }">su3=0</c:when>
			<c:when test="${su3 eq 1 }">su3=1</c:when>
			<c:when test="${su3 eq 2 }">su3=2</c:when>
			<c:when test="${su3 eq 3 }">su3=3</c:when>
			<c:otherwise>
				몰라
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>




















