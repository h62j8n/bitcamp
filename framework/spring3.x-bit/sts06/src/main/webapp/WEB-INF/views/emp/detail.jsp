<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>EDIT</h1>
	<div>
		<div>
			<span>사번</span>
			<span>${bean.sabun}</span>
		</div>
		<div>
			<span>이름</span>
			<span>${bean.name}</span>
		</div>
		<div>
			<span>날짜</span>
			<span>${bean.nalja}</span>
		</div>
		<div>
			<span>금액</span>
			<span>${bean.pay}</span>
		</div>
		<p>
			<a href="edit?idx=${bean.sabun}">수정</a>
			<a href="delete?idx=${bean.sabun}">삭제</a>
		</p>
	</div>
</body>
</html>