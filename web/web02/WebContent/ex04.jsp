<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	java.util.Enumeration<String> en;
	en = request.getHeaderNames();
	
	while (en.hasMoreElements()) {
		String name = en.nextElement();
		System.out.print(name+" : ");
		String value = request.getHeader(name);
		System.out.println(value);
	}
	%>
</body>
</html>