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
				<h1>상세보기</h1> <%
 	String param = request.getParameter("idx");
 	String sql = "select num,nalja,id,cnt,sub,content from bbs01 where num="
 			+ param;
 	String driver = "oracle.jdbc.driver.OracleDriver";
 	String url = "jdbc:oracle:thin:@localhost:1521:xe";
 	String user = "scott";
 	String password = "tiger";

 	Connection conn = null;
 	Statement stmt = null;
 	ResultSet rs = null;
 	try {
 		Class.forName(driver);
 		conn = DriverManager.getConnection(url, user, password);
 		stmt = conn.createStatement();
 		int result = stmt
 				.executeUpdate("update bbs01 set cnt=cnt+1 where num="
 						+ param);
 		if (result > 0) {
 			stmt = conn.createStatement();
 			rs = stmt.executeQuery(sql);
 			if (rs.next()) {
 %>
				<table width="80%" align="center">
					<tr>
						<td width="80" bgcolor="#dddddd">글번호</td>
						<td><%=rs.getInt(1)%></td>
						<td width="80" bgcolor="#dddddd">날짜</td>
						<td><%=rs.getDate(2).toString()%></td>
					</tr>
					<tr>
						<td width="80" bgcolor="#dddddd">글쓴이</td>
						<td><%=rs.getObject(3)%></td>
						<td width="80" bgcolor="#dddddd">조회수</td>
						<td><%=rs.getObject(4)%></td>
					</tr>
					<tr>
						<td width="80" bgcolor="#dddddd">제목</td>
						<td colspan="3"><%=rs.getObject(5)%></td>
					</tr>
					<tr>
						<td colspan="4" bgcolor="#dddddd"><%=rs.getString(6).replace("\n", "<br>")%></td>
					</tr>
					<tr>
						<td colspan="4" bgcolor="#dddddd" align="center">
						<a href="list.jsp?idx=<%=rs.getInt("num")%>">[리스트]</a>
						<a href="edit.jsp?idx=<%=rs.getInt("num")%>">[수 정]</a>
						<a href="del.jsp?idx=<%=rs.getInt("num")%>">[삭 제]</a>
						</td>
					</tr>
					<tr>
						<td colspan="4"><img alt="" src="imgs/footer.jpg"></td>
					</tr>

				</table> <%
 	}
 		}
 	} finally {
 		if (rs != null)
 			rs.close();
 		if (stmt != null)
 			stmt.close();
 		if (conn != null)
 			conn.close();
 	}
 %>
			</td>
		</tr>
	</table>
</body>
</html>