<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){
		$('.weather').hide();
		alert($('wf').first().text());
	});

</script>
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 문법4</h1>
	<h2>기타기능</h2>
	<c:url value="http://daum.net" var="daum">
		<c:param name="idx">1234</c:param>
		<c:param name="keyword">java</c:param>
		<c:param name="page">10</c:param>
	</c:url>
	<c:url value="/" var="root"></c:url>
	
	<%
		String top=request.getContextPath();
		System.out.println(top+"/");
	%>
	<ul>
		<li><a href="http://naver.com">naver</a></li>
		<li><a href="${daum }">daum</a></li>
		<li><a href="${root }">root</a></li>
		<li><a href="${root }"><c:url value="/bbs/"></c:url></a></li>
	</ul>
	
	<p>여기서부터</p>
	<div class="weather">
	<c:import url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109"></c:import>
	</div>
	<p>이상의 내용을 가져옵니다</p>
</body>
</html>


















