<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>th, td {padding: 5px 0;}</style>
</head>
<body>
	<h1>jsp ����</h1>
	<!-- html�� �ּ��� �ҽ����⿡ ���´�. -->
	<table width="500" border="1" style="text-align: center; border-collapse: collapse">
		<tr>
	<%
	for (int i=2; i<10; i++) {
		out.println("<th>"+i+"��</th>");
	}
	%>
		</tr>
	<%
	// �ڹ� �ڵ� �ۼ� �κ�. �ڹ��� �ּ��� �ܺο� ������� �ʴ´�.
	for (int i=1; i<10; i++) {
		out.println("<tr>");
		for (int j=2; j<10; j++) {
			out.println("<td>"+j+"x"+i+"="+(j*i)+"</td>");
		}
		out.println("</tr>");
	}
	%>
	</table>
</body>
</html>