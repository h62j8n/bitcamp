<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.web17.*, java.util.ArrayList" %>

<bbs>
	<%
	BbsDao dao = new BbsDao();
	ArrayList<BbsDto> list = dao.getList();
	for(int i=0; i<list.size(); i++){
		BbsDto bean = list.get(i);
	%>
	<record>
		<num><%= bean.getNum() %></num>
		<sub><%= bean.getSub() %></sub>
		<id><%= bean.getId() %></id>
		<nalja><%= bean.getNalja() %></nalja>
	</record>
	<%
	}
	%>
</bbs>
