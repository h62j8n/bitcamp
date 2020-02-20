<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>받는 페이지</h1>
	<%
	java.util.Enumeration<String> en;
	en = request.getParameterNames();
	
	while (en.hasMoreElements()) {
		String name = en.nextElement();
//		String param = request.getParameter(name);
//		System.out.println(name+" : "+param);
		String[] params = request.getParameterValues(name);
		if (params != null) {
			for (int i=0; i<params.length; i++) {
				out.print("<p>"+name+" : "+params[i]+"</p>");
			}
		}
	}
	
	java.util.Map map = request.getParameterMap();
	java.util.Set keys = map.keySet();
	java.util.Iterator ite = keys.iterator();
	while (ite.hasNext()) {
		String name = (String)ite.next();
		String[] array = (String[])map.get(name);
		System.out.println(name+" : "+java.util.Arrays.toString(array));
	}
	%>
</body>
</html>