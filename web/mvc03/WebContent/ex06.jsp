<%@page import="java.util.ArrayList"%>
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
	<h1>JSTL 문법3</h1>
	<h2>제어문(반복문)</h2>
	<c:forEach begin="5" end="10" var="obj" varStatus="status">
		<p>${obj }출력-${status.index },${status.count },${status.first }:${status.last }</p>  
	</c:forEach>
	
	<%
		ArrayList list=new ArrayList();
		list.add("a");
		list.add("ab");
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		pageContext.setAttribute("alist", list);
	%>
	<ul>
		<c:forEach items="${alist }" var="msg" varStatus="status">
			<li>${status.count}.[${status.index}].${msg }-${status.current }</li>
		</c:forEach>
	</ul>
	
	
	<h2>스트링토큰</h2>
	<c:set var="msgs" value="java,db,web,spring"/>
	<c:forTokens items="${msgs }" delims="," var="msg">
		<p>${msg}</p>
	</c:forTokens>
	
</body>
</html>

















