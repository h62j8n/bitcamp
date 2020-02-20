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
				<h2>DEPT INSERT PAGE</h2>
				<form action="insert.html" method="post">
					<div>
						<label for="dname">부서명</label>
						<input type="text" name="dname" id="dname">
					</div>
					<div>
						<label for="loc">지역</label>
						<select name="loc" id="loc">
							<option>서울</option>
							<option>부산</option>
							<option>대전</option>
							<option>대구</option>
							<option>광주</option>
							<option>기타</option>
						</select>
					</div>
					<div>
						<button type="submit">입력</button>
						<button type="reset">취소</button>
						<button type="button">뒤로</button>
					</div>
				</form>
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