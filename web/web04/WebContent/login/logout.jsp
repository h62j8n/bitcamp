<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	if (request.getMethod().equals("POST")) {
		session.setAttribute("login", null);
		response.sendRedirect("form.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../template/header.jsp" %>
<%@ include file="../template/menu.jsp" %>
<h1>�α׾ƿ�</h1>
<form method="post">
	<table width="200" align="center">
		<tr>
			<td>�α׾ƿ��Ͻðڽ��ϱ�?</td>
		</tr>
		<tr>
			<td><input type="submit" value="Ȯ��"></td>
		</tr>
	</table>
</form>
<%@ include file="../template/footer.jsp" %>
</body>
</html>