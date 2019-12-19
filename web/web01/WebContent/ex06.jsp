<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>파라미터 전달</h1>
	<p><a href="ex07.jsp?msg=abcd">[link]</a></p>
	<form action="ex07.jsp">
		<input type="text" name="msg">
		<input type="submit" value="전달">
	</form>
</body>
</html>