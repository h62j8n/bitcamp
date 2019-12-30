<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.web17.*" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	BbsDao dao = new BbsDao();
	BbsDto bean = dao.getBean(num);
	
	out.print("{\"root\":[");
	out.print("	{\"num\":"+bean.getNum());
	out.print(",\"id\":\""+bean.getId()+"\"");
	out.print(",\"nalja\":\""+bean.getNalja().toString()+"\"");
	out.print("	,\"sub\":\""+bean.getSub()+"\"");
	out.print("	,\"content\":\""+bean.getContent()+"\"}");
	out.print("]}");
%>

