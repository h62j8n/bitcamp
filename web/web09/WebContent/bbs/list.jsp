<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>
	<a href="./?p=add">[글쓰기]</a>
	<table align="center" border="1" cellspacing="0" width="90%">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		<%@ page import="com.bit.model.*" %>
		<%
		Bbs01Dao dao=new Bbs01Dao();
		java.util.ArrayList<Bbs01Dto> list=null;
		list=dao.getList();
		for(int i=0; i<list.size(); i++){
			Bbs01Dto bean=list.get(i);
		%>
		<tr>
			<td><%=bean.getNum() %></td>
			<td><a href="./?p=detail&num=<%=bean.getNum() %>"><%=bean.getSub() %></a></td>
			<td><%=bean.getId() %></td>
			<td><%=bean.getNalja() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>












