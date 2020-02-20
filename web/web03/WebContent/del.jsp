<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	int num=0;
	try{
	num = Integer.parseInt(request.getParameter("idx"));
	}catch(NumberFormatException e){
		response.sendRedirect("list.jsp");
	}
	String sql= "delete from bbs01 where num="+num;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		response.sendRedirect("list.jsp");
	}finally{
		if(stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();		
	}
%>
</body>
</html>