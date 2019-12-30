<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.web17.*" %>

<%
	String sub = request.getParameter("sub");
	String content = request.getParameter("content");
	int num = Integer.parseInt(request.getParameter("num"));
	
	BbsDao dao = new BbsDao();
	dao.update(sub, content, num);
%>