<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.mvc01.model.Emp01Dto, java.util.ArrayList" %>
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
		#content {}
		#content table {border-collapse: collapse; width: 90%; margin: 0 auto;}
		#content table, #content table th, #content table td {border: 1px solid gray;}
		#content table td > a {display: block; height: 40px;}
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
				<h2>리스트 페이지</h2>
				<a href="add.html">입력</a>
				<table>
					<thead>
						<tr>
							<th>사번</th>
							<th>이름</th>
							<th>입사일</th>
							<th>금액</th>
						</tr>
					</thead>
					<tbody>
<%
ArrayList<Emp01Dto> list = null;
list = (ArrayList<Emp01Dto>)request.getAttribute("alist");
for (Emp01Dto bean : list) {
%>
						<tr>
							<td><a href="detail.html?idx=<%= bean.getSabun() %>"><%= bean.getSabun() %></a></td>
							<td><a href="detail.html?idx=<%= bean.getSabun() %>"><%= bean.getName() %></a></td>
							<td><a href="detail.html?idx=<%= bean.getSabun() %>"><%= bean.getNalja() %></a></td>
							<td><a href="detail.html?idx=<%= bean.getSabun() %>"><%= bean.getPay() %></a></td>
						</tr>
<%
}
%>
					</tbody>
				</table>
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