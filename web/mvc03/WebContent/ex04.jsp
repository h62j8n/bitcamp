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
	<h1>JSTL 문법1</h1>
	<div>
		<c:out value="1234"></c:out>
		<c:out value="abc">출력</c:out>
		<c:out value="${null }">출력</c:out>
		<c:out value="${'test' }">출력</c:out>
	</div>
	<div>
		<c:set var="su1">4321</c:set>
		<c:out value="${su1 }"/>
		<c:set var="su2" value="3.14"/>
		<c:out value="${su2 }"/>
		<c:set var="su1" value="9999" scope="request"/>
		<span>${requestScope.su1 }</span>
		<span>${pageScope.su1 }</span>
	</div>
	<jsp:useBean id="bean" class="com.bit.mvc03.utils.JavaBean"/>
	<c:set target="${bean }" property="su1" value="1004" />
	<c:set target="${bean }" property="su2" value="3.14"/>
	<c:set target="${bean }" property="boo" value="true"/>
	<c:set target="${bean }" property="ch" value="#"/>
	<c:set target="${bean }" property="msg" value="abcdefg"/>
	<c:set target="${bean }" property="nalja" value="<%=new java.util.Date() %>"/>
	<ul>
		<li>${bean.su1 }</li>
		<li>${bean.su2 }</li>
		<li>${bean.boo }</li>
		<li>${bean.ch }</li>
		<li>${bean.msg }</li>
		<li>${bean.nalja }</li>
	</ul>
</body>
</html>






















