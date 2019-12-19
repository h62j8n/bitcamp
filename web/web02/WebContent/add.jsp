<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<style>
form > div {overflow: hidden; margin-bottom: 15px;}

</style>
	<h1>입력페이지</h1>
	<form action="insert.jsp">
		<div>
			<span>국어</span>
			<input type=text" name="kor">
		</div>
		<div>
			<span>영어</span>
			<input type=text" name="eng">
		</div>
		<div>
			<span>수학</span>
			<input type=text" name="math">
		</div>
		<div>
			<button type="submit">입력하기</button>
			<button type="reset">취소하기</button>
		</div>
	</form>
</body>
</html>