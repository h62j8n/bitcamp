<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<%@ page import="com.bit.model.*" %>
	<jsp:useBean scope="page" id="bean" class="com.bit.model.Bbs01Dto"></jsp:useBean>
	<jsp:setProperty property="num" name="bean"/>
	<%
	Bbs01Dao dao=new Bbs01Dao();
	pageContext.setAttribute("bean",dao.getBean(bean.getNum()));
	%>
	<table>
		<tr>
			<td>글번호</td>
			<td><jsp:getProperty property="num" name="bean"/></td>
			<td>글쓴이</td>
			<td><jsp:getProperty property="id" name="bean"/></td>
			<td>날짜</td>
			<td><jsp:getProperty property="nalja" name="bean"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="5"><jsp:getProperty property="sub" name="bean"/></td>
		</tr>
		<tr>
			<td colspan="6"><jsp:getProperty property="content" name="bean"/></td>
		</tr>
		<tr>
			<td colspan="6">
				<a href="./?p=edit&num=<%=bean.getNum()%>">[수 정]</a>
				<a href="./?p=delete&num="<%=bean.getNum()%>>[삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>