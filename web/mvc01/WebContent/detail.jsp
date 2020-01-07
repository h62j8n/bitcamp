<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.mvc01.model.*, com.bit.mvc01.model.Emp01Dto" %>
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
		#content h2 {}
		#content h2~div {width: 90%; margin: 0 auto; text-align: center;}
		#content h2~div > span {display: inline-block; width: 40%; border-bottom: 1px solid gray;}
		#content h2~div > span:first-child {background: gray;}
		#content h2~div > a {display: inline-block; width: 30%; height: 40px; border: 1px solid gray; border-radius: 10px; text-decoration: none; text-align: center; line-height: 40px; margin-top: 10px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#content h1~div > a').last().on("click", function() {
				window.history.back();
				console.log("test");
				return false;
			});
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
				<h2>상세 페이지</h2>
				<%
				Emp01Dto bean = (Emp01Dto)request.getAttribute("bean");
				%>
				<div>
					<span>사번</span>
					<span><%= bean.getSabun() %></span>
				</div>
				<div>
					<span>이름</span>
					<span><%= bean.getName() %></span>
				</div>
				<div>
					<span>입사일</span>
					<span><%= bean.getNalja() %></span>
				</div>
				<div>
					<span>금액</span>
					<span><%= bean.getPay() %></span>
				</div>
				<div>
					<span>비고</span>
					<span><%= bean.getEtc() %></span>
				</div>
				<div>
					<a href="edit.html?idx=<%= bean.getSabun() %>">수정</a>
					<a href="delete.html?idx=<%= bean.getSabun() %>">삭제</a>
					<a href="#">뒤로</a>
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