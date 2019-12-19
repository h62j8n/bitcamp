<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>전달 받는 페이지</h1>
	<p>id : <%= request.getParameter("id") %></p>
	<p>pw : <%= request.getParameter("pw") %></p>
	<p>name : <%= request.getParameter("name") %></p>
	<%
	String[] arrHobby = request.getParameterValues("ch");
	String hobby = "";
	if (arrHobby != null) {
		for (int i=0; i<arrHobby.length; i++) {
			hobby += arrHobby[i]+" ";
		}
	}
	%>
	<p>hobby : <%= hobby %></p>
	<%
	String content = request.getParameter("content");
	content = content.replace("\n", "<br>");
	%>
	<p>radio : <%= request.getParameter("ra") %></p>
		<%
	String[] arrSelect = request.getParameterValues("ch");
	String select = "";
	if (arrSelect != null) {
		for (int i=0; i<arrSelect.length; i++) {
			select += arrSelect[i]+" ";
		}
	}
	%>
	<p>select : <%= select %></p>
	<p>content : <%= content %></p>
</body>
</html>