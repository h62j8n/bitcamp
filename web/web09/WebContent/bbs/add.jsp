<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="bbs/insert.jsp">
		<p>제목:<input type="text" name="sub"></p>
		<p>글쓴이:<input type="text" name="id"></p>
		<p><textarea name="content" rows="5" cols="50"></textarea></p>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>