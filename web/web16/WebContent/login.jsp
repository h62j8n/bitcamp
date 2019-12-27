<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
		form {width: 400px;}
		form > div > label {display: inline-block; width: 50px;}
		form > div > input {width: 220px;}
		form > div > button {width: 300px;}
	</style>
</head>
<body>
	<h1>login</h1>
	<form action="result01.jsp">
		<div>
			<label for="id">ID</label>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<label for="pw">PW</label>
			<input type="password" name="pw" id="pw">
		</div>
		<div>
			<button type="submit" >로그인</button>
		</div>
	</form>
</body>
</html>