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
		#content table {border-collapse: collapse; width: 1024px; margin: 0 auto;}
		#content th, #content td {border: 1px solid gray;}
		#content tbody tr:hover {background: darkseagreen;}
		#content td a {display: block; height: 35px;}
	</style>
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
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
				<h2>DEPT LIST PAGE</h2>
				<a href="add.html">입력</a>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>부서명</th>
							<th>지역</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					<%@ page import="java.util.ArrayList, com.bit.mvc02.dept.model.Dept02Dto" %>
					<%
					ArrayList<Dept02Dto> list = null;
					list = (java.util.ArrayList<Dept02Dto>)request.getAttribute("list");
					for (Dept02Dto bean : list) {
					%>
						<tr>
							<td>
								<a href=""><%= bean.getDeptno() %></a>
							</td>
							<td>
								<a href=""><%= bean.getDname() %></a>
							</td>
							<td>
								<a href=""><%= bean.getLoc() %></a>
							</td>
							<td>
								<form action="delete.html" method="post">
									<input type="hidden" name="deptno" value="<%= bean.getDeptno() %>">
									<button type="submit">삭제</button>
								</form>
							</td>
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