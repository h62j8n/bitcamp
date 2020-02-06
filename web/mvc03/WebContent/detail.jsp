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
	$(function(){
		$(':reset').hide();
		$('#content form').one('submit',function(){
			$('#name,#pay,#etc')
				.attr('type','text').prev().hide();
			$(':reset').show();
			return false;
		});
		$('button[type=button]').eq(0).click(function(){
			var del=confirm('사번 ${bean.sabun}번 사원을 삭제하시겠습니까?');
			if(del){
				$.post('delete.html','idx=${bean.sabun}',function(data){
					if(data=='ok') {
						alert("삭제성공");
						window.location.href='list.html';
					}else alert('삭제실패');
				},'text');
			}
		}).next().click(function(){
			history.back();
		});
		if(${err ne null})$('form').submit();
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
	<h2>Detail Page</h2>
	<form method="post">
		<div>
			<label for="sabun">사번</label>
			<span>${bean.sabun }</span>
			<input type="hidden" name="sabun" id="sabun" value="${bean.sabun }" readonly="readonly"/>
		</div>
		<div>
			<label for="name">이름</label>
			<span>${bean.name }</span>
			<input type="hidden" name="name" id="name" value="${bean.name }" />
			<span class="err">${err[0] }</span>
		</div>
		<div>
			<label for="nalja">날짜</label>
			<span>${bean.nalja }</span>
			<input type="hidden" name="nalja" id="nalja" value="${bean.nalja }" disabled="disabled" />
		</div>
		<div>
			<label for="pay">금액</label>
			<span>${bean.pay }</span>
			<input type="hidden" name="pay" id="pay" value="${bean.pay }" />
			<span class="err">${err[1] }</span>
		</div>
		<div>
			<label for="etc">기타</label>
			<span>${bean.etc }</span>
			<input type="hidden" name="etc" id="etc" value="${bean.etc }" />
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
			<button type="button">삭제</button>
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










