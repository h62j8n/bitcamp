<%@page import="com.bit.model.Bbs01Dao"%>
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
// post방식 한글 처리
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="bean" class="com.bit.model.Bbs01Dto"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
	Bbs01Dao dao=new Bbs01Dao();
	dao.update(bean.getNum(),bean.getSub(), bean.getContent());
	response.sendRedirect("../?p=detail&num="+bean.getNum());
%>
</body>
</html>