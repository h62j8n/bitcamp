<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="../template/header.jsp">
		<jsp:param value="../" name="path" />
	</jsp:include>
	
	<!-- menu -->
	<jsp:include page="../template/menu.jsp">
		<jsp:param value="../" name="path" />
	</jsp:include>
	
	<h2>게시글 작성</h2>
	<form action="insert.jsp">
		<p>제목 : <input type="text" name="sub"></p>
		<p><textarea name="content" rows="5" cols="50"></textarea></p>
		<input type="submit" value="입력">
	</form>
</body>
</html>