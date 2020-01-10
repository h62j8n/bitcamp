<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script type="text/javascript">

</script>
<title>Insert title here</title>
</head>
<body>
<c:url value="/" var="root"/>
<div id="header">
	<h1>비트교육센터</h1>
</div>
<div id="menu">
	<a href="${root }index.html">HOME</a>
	<a href="${root }intro.html">INTRO</a>
	<a href="${root }emp/list.html">E M P</a>
	<a href="${root }login/login.html">LOGIN</a>
</div>
<div id="content">
	<img alt="" src="imgs/big01.jpg"/>
</div>
<div id="footer">
	<address>서울 강남구 테헤란로5길 11 YOO빌딩 3층</address>
	Copyright &copy; 비트캠프 All rights reserved.
</div>
</body>
</html>










