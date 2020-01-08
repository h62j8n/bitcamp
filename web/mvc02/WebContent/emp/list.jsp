<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/bitgrid.css">
	<style type="text/css">
		#header h1 {width: 263px; height: 86px; background-image: url("../imgs/logo.jpg"); text-indent: -999px;}
	</style>
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#content table > tbody").children().each(function(){
				var sabun;	
				$(this).children().each(function(idx){
				    if (idx == 0) sabun = $(this).text();
				    $(this).html("<a href=\"detail.html?sabun=" + sabun + "\">" + $(this).text() + "</a>");
				});
			});
		});
	</script>
</head>
<body>
	<div class="containerw">
		<div id="header" class="row">
			<div class="grid12">
				<h1>비트교육센터</h1>
			</div>
		</div>
		<div id="menu" class="row">
			<div class="grid12">
				<a href="../index.html">HOME</a>
				<a href="../intro.html">INTRO</a>
				<a href="../emp/list.html">EMP</a>
				<a href="../dept/list.html">DEPT</a>
				<a href="../login/login.html">LOGIN</a>
			</div>
		</div>
		<div id="content" class="row">
			<div class="grid12">
				<h2>EMP LIST PAGE</h2>
				<table>
					<thead>
						<tr>
							<th>사번</th>
							<th>이름</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
					<%@ page import="java.util.ArrayList, com.bit.mvc02.emp.model.Emp02Dto" %>
					<%
					ArrayList<Emp02Dto> list = (ArrayList<Emp02Dto>)request.getAttribute("list");
					for (Emp02Dto bean : list) {
					%>
						<tr>
							<td><%= bean.getSabun() %></td>
							<td><%= bean.getName() %></td>
							<td><%= bean.getNalja() %></td>
						</tr>
					<%
					}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<div id="footer" class="row">
			<div class="grid12">
				<address>서울 강남구 테헤란로 5길 11 YOO빌딩 3층</address>
				Copyright &copy; 비트캠프 All rights reserved.
			</div>
		</div>
	</div>
</body>
</html>