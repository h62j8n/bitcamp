<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�亯�� �ۼ�</h1>
<%
	int ref = Integer.parseInt(request.getParameter("ref"));
	int no = Integer.parseInt(request.getParameter("no"));
	int lev = Integer.parseInt(request.getParameter("lev"));
%>
	<form action="reinsert.jsp">
		<p>
			<input type="hidden" name="ref" value="<%= ref %>">
			<input type="hidden" name="no" value="<%= no %>">
			<input type="hidden" name="lev" value="<%= lev %>">
			���� : <input type="text" name="sub">
		</p>
		<p>�ۼ��� : <input type="text" name="id"></p>
		<p><textarea name="content" rows="5" cols="50"></textarea></p>
		<p><input type="submit" value="�ۼ�"></p>
	</form>
</body>
</html>