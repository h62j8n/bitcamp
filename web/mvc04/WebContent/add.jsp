<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>ADD PAGE</h1>
	<a href="add.html">입력 (업로드)</a>
	<a href="list.html">목록 (다운로드)</a>
	<a href="add2.html">입력2 (트랜젝션)</a>
	<a href="list.html">목록2 (트랜젝션)</a>
	<div>
		<h2>UPLOAD</h2>
		<form method="post" enctype="multipart/form-data">
			<div>
				<label for="sabun">사번</label>
				<input type="text" name="sabun" id="sabun">
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" name="name" id="name">
			</div>
			<div>
				<label for="file1">파일</label>
				<input type="file" name="file1" id="file1">
			</div>
			<div>
				<button type="submit">업로드</button>
			</div>
		</form>
	</div>
</body>
</html>