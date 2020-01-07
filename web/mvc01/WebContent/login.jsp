<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bitgrid.css"/>
	<style type="text/css">
		#header p {width: 206px; height: 91px; background-image: url("imgs/logo.jpg"); text-indent: -9999px; margin: 0 auto;}
		#menu {background-color: gray; text-align: center;}
		#menu a {color: white; text-decoration: none; margin: 0 20px;}
		#menu a:hover {color: red;}
		#content form {width: 60%;}
		#content form > div {text-align: center;}
		#content form > div > label {display: inline-block; width: 40%; background: gray;}
		#content form > div > input {}
		#content form > div > button {width: 40%; margin: 10px 5px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.bx').bxSlider();
		});
	</script>
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div id="header" class="row">
			<div class="tgrid_12">
				<p>비트교육센터</p>
			</div>
		</div>
		<div id="menu" class="row">
			<div class="tgrid_12">
				<a href="/mvc01/">HOME</a>
				<a href="/mvc01/intro.html">INTRO</a>
				<a href="/mvc01/list.html">BBS</a>
				<a href="/mvc01/login.html">LOGIN</a>
			</div>
		</div>
		<div id="content" class="row">
			<div class="tgrid_12">
				<h2>로그인</h2>
				<form method="post">
					<div>
						<label for="sabun">사번</label>
						<input type="text" name="sabun" id="sabun">
					</div>
					<div>
						<label for="">이름</label>
						<input type="text" name="name" id="name">
					</div>
					<div>
						<button type="submit">로그인</button>
						<button type="reset">취소</button>
					</div>
				</form>
			</div>
		</div>
		<div id="footer" class="row">
			<div class="tgrid_12">
				<address>서울특별시 서초구 서초대로 74길 33 비트빌딩</address>
				COPYRIGHT © 2013 BITCOMPUTER ALL RIGHTS RESERVED.
			</div>
		</div>
	</div>
</body>
</html>