<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

	.err{
		color:red;
		font-style: italic;
	}

</style>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$('.err').each(function(){
			if($(this).text()!=''){
				$(this).prev().css('border','1px solid red').focus();
				
			}
		});
	});
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
	<h2>입력페이지</h2>
	<form method="post">
		<div>
			<label for="name">이름</label>
			<input type="text" id="name" name="name" value="${vals[0] }" />
			<span class="err">${err[0] }</span>
		</div>
		<div>
			<label for="pay">금액</label>
			<input type="text" id="pay" name="pay" value="${vals[1] }" />
			<span class="err">${err[1]}</span>
		</div>
		<div>
			<label for="etc">기타</label>
			<input type="text" id="etc" name="etc" value="${vals[2] }" />
		</div>
		
		<div>
			<button type="submit">입력</button>
			<button type="reset">취소</button>
			<button type="button">뒤로</button>
		</div>
	</form>
</div>
<div id="footer">
	<address>서울 강남구 테헤란로5길 11 YOO빌딩 3층</address>
	Copyright &copy; 비트캠프 All rights reserved.
</div>
</body>
</html>










