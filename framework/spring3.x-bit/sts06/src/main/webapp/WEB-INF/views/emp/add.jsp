<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>INSERT</h1>
	<form method="POST">
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name">
		</div>
		<div>
			<label for="pay">금액</label>
			<input type="text" name="pay" id="pay">
		</div>
		<div>
			<button type="submit">입력</button>
		</div>
	</form>
</body>
</html>