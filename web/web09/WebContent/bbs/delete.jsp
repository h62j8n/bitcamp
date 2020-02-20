<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	if (request.getMethod().equals("POST")) {
		com.bit.model.Bbs01Dao dao = null;
		dao = new com.bit.model.Bbs01Dao();
		dao.delete(num);
%>
<jsp:forward page="../index.jsp?p=list"></jsp:forward>
<%
}
%>
<body>
	<h1>삭제 확인</h1>
	<form method="post">
		<input type="hidden" name="p" value="delete">
		<input type="hidden" name="num" value="<%= request.getParameter("num") %>">
		<p>삭제하시겠습니까?</p>
		<input type="submit" value="확인">
	</form>
</body>
</html>