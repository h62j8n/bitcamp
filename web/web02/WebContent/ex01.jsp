<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	form {width: 350px;}
	div {margin-bottom: 15px; overflow: hidden;}
	span {float: left;}
	.halfbox p, .halfbox input, .halfbox select {float: right; width: 250px;}
	.chkbox div {float: right; width: 250px; margin: 0;}
	.chkbox p {float: left; width: 80px;}
	textarea {width: 100%; box-sizing: border-box;}
	.btnbox {margin: 0 auto; width: 170px; overflow: hidden;}
	.btnbox button, .btnbox input {float: left; width: 70px;}
	.btnbox input {margin-left: 10px;}
</style>
</head>
<body>
	<h1>페이지 이동</h1>
	<p><a href="./">[home]</a></p>
	<p><a href="./ex02.jsp?id=guest">[ex02]</a></p>
	
	<form action="ex04.jsp" method="post">
		<div class="halfbox">
			<span>ID</span>
			<input type="hidden" name="id" value="guest">
			<!-- <p>Guest</p> -->
		</div>
		<div class="halfbox">
			<span>PW</span>
			<input type="password" name="pw">
		</div>
		<div class="halfbox">
			<span>Name</span>
			<input type="text" name="name">
		</div>
		<div class="chkbox">
			<span>Hobby</span>
			<div>
				<p><input type="checkbox" name="ch" value="cItem1">chk1</p>
				<p><input type="checkbox" name="ch" value="cItem2">chk2</p>
				<p><input type="checkbox" name="ch" value="cItem3">chk3</p>
			</div>
		</div>
		<div class="chkbox">
			<span>Radio</span>
			<div>
				<p><input type="radio" name="ra" value="ra1" checked="checked">ra1</p>
				<p><input type="radio" name="ra" value="ra2">ra2</p>
				<p><input type="radio" name="ra" value="ra3">ra3</p>
			</div>
		</div>
		<div class="halfbox">
			<span>Select</span>
			<select name="sel">
				<option value="option1">option1</option>
				<option value="option2">option2</option>
				<option value="option3">option3</option>
				<option value="option4">option4</option>
				<option value="option5">option5</option>
			</select>
		</div>
		<div>
			<span>Content</span>
			<textarea rows="3" name="content"></textarea>
		</div>
		<div class="btnbox">
			<button type="submit">전달</button>
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>