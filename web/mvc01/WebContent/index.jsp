<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.mvc01.model.Emp01Dto" %>
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
				<%
				Emp01Dto login = (Emp01Dto)session.getAttribute("login");
				if (login != null) {
				%>
				<div>
					<span><%= login.getName() %>님 환영합니다</span>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<div id="menu" class="row">
			<div class="tgrid_12">
				<a href="/mvc01/">HOME</a>
				<a href="/mvc01/intro.html">INTRO</a>
				<a href="/mvc01/list.html">BBS</a>
				<% if (login == null) { %>
				<a href="/mvc01/login.html">LOGIN</a>
				<% } else { %>
				<a href="/mvc01/logout.html">LOGOUT</a>
				<% } %>
			</div>
		</div>
		<div id="content" class="row">
			<div class="tgrid_12">
				<div class="bx">
					<div><img src="imgs/01.png"/></div>
					<div><img src="imgs/02.png"/></div>
					<div><img src="imgs/03.png"/></div>
					<div><img src="imgs/04.png"/></div>
					<div><img src="imgs/05.png"/></div>
					<div><img src="imgs/06.png"/></div>
				</div>
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