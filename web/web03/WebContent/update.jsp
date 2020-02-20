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
		String param1 = request.getParameter("num");
		String param2 = request.getParameter("sub");
		String param3 = request.getParameter("content");

		int num = 0;
		try{
			num=Integer.parseInt(param1);
		}catch(NumberFormatException e){
			out.print("<h1>ERROR</h1>");
			out.print("<h1>누구냐</h1>");
			return;
		}
		if(param1==null || param1.equals("")){
			out.print("<h1>ERROR</h1>");
			out.print("<h1>누구냐</h1>");
			return;
		}		
		
		String sub=param2.trim();
		
		if(sub.equals("")){
			response.sendRedirect("edit.jsp?idx="+num);
			return;
		}
		

		String content= param3.trim();
		String sql = "update bbs01 set sub='"+sub+"',content='"+content+"' where num="+num;
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="scott";
		String password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0)
				response.sendRedirect("detail.jsp?idx="+num);
			else
				response.sendRedirect("edit.jsp?idx="+num);
		}
		finally{
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}
	%>
</body>
</html>