<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp test page</h1>
	<%
	int a = 100;
	a++;
	out.println("jsp 파일에 출력 "+a);
	System.out.println("콘솔에 출력 "+a);
	%>
</body>
</html>