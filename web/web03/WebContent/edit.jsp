<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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
	<table align="center" width="800" border="0" cellspacing="0">
		<tr>
			<td colspan="7"><img alt="" src="imgs/header.jpg"></td>
		</tr>
		<tr>
			<td></td>
			<td width="75"><a href="index.jsp" style="color: #ffffff"><img
					alt="" src="imgs/menu1.jpg"></a></td>
			<td width="76"><a href="sec.jsp" style="color: #ffffff"><img
					alt="" src="imgs/menu2.jpg"></a></td>
			<td width="59"><a href="list.jsp" style="color: #ffffff"><img
					alt="" src="imgs/menu3.jpg"></a></td>
			<td width="59"><img alt="" src="imgs/menu4.jpg"></td>
			<td width="70"><img alt="" src="imgs/menu5.jpg"></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="7">
				<h1>수정 페이지</h1>
				<form action="update.jsp">
					<%
				String param = request.getParameter("idx");
				String driver = "oracle.jdbc.driver.OracleDriver";
				String sql = "select * from bbs01 where num="+param;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password="tiger";
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, user, password);
					stmt=conn.createStatement();
					rs= stmt.executeQuery(sql);
					
					if(rs.next()){
				
				%>
					<table align="center" width="80%">
						<tr>
							<td align="center" width="80" bgcolor="#dddddd">글번호</td>
							<td><input type="hidden" name="num" value="<%=rs.getInt("num")%>" readonly="readonly"><%=rs.getInt("num") %></td>
							<td align="center" width="80" bgcolor="#dddddd">날짜</td>
							<td><%=rs.getDate("nalja") %></td>
						</tr>
						<tr>
							<td align="center" width="80" bgcolor="#dddddd">글쓴이</td>
							<td><%=rs.getString("id") %></td>
							<td align="center" width="80" bgcolor="#dddddd">조회수</td>
							<td><%=rs.getInt("cnt") %></td>
						</tr>
						<tr>
							<td align="center" width="80" bgcolor="#dddddd">제목</td>
							<td colspan="3"><input type="text" name="sub" value="<%=rs.getString("sub")%>"></td>
						</tr>
						<tr>
							<td colspan="4"><textarea rows="5" cols="100%" name="content"><%=rs.getString("content")%></textarea></td>
						</tr>
						<tr>
							<td colspan="4" align="center" bgcolor="#dddddd"><input
								type="submit" value="수 정"> <input type="reset"
								value="취 소"></td>
						</tr>
					</table>
					<%
					}
				}finally{
					if(rs!=null)
						rs.close();
					if(stmt!= null)
						stmt.close();
					if(conn!=null)
						conn.close();
				}
					%>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="7"><img alt="" src="imgs/footer.jpg"></td>
		</tr>

	</table>
</body>
</html>