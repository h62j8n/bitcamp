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
	<jsp:useBean id="bean" class="com.bit.model.Bbs01Dto"></jsp:useBean>
	<jsp:setProperty property="*" name="bean"/>
	<p><jsp:getProperty property="sub" name="bean"/></p>
	<%
	
//	GET��� �ѱ� ó��
//	server.xml -> 8080��Ʈ ������ �߰�
//	URIEncoding="EUC-KR" jsp�� ��Ī�Ǵ� �ɸ��ͼ�
	Bbs01Dao dao=new Bbs01Dao();
	dao.insert(bean.getSub(), bean.getId(), bean.getContent());
	response.sendRedirect("../index.jsp?p=list");
	%>
</body>
</html>









