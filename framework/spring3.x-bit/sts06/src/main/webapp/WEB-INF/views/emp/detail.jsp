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
			<span>���</span>
			<span>${bean.sabun}</span>
		</div>
		<div>
			<span>�̸�</span>
			<span>${bean.name}</span>
		</div>
		<div>
			<span>��¥</span>
			<span>${bean.nalja}</span>
		</div>
		<div>
			<span>�ݾ�</span>
			<span>${bean.pay}</span>
		</div>
		<p>
			<a href="edit?idx=${bean.sabun}">����</a>
			<a href="delete?idx=${bean.sabun}">����</a>
		</p>
	</div>
</body>
</html>