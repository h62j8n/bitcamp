<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
table {text-algn: center; border-collapse: collapse;}
th {padding: 5px; border-bottom: 2px solid #000; font-size: 12px;}
td {padding: 5px; border-bottom: 1px solid #000; font-size: 15px;}
input[type=text] {width: 30px; border: none; text-align: center;}
input[type=submit] {border: 1px solid #000; padding: 5px 10px; background: #000; color: #fff;}
input[type=submit].btn_ud {background: none; color: #000}
</style>
</head>
<body>
	<h1>학생성적관리 프로그램</h1>
	<table>
		<tr>
			<th width="40">학번</th>
			<th width="70">국어</th>
			<th width="70">영어</th>
			<th width="70">수학</th>
			<th width="70" colspan="2">편집</th>
		</tr>
<%
	oracle.jdbc.driver.OracleDriver driver = null;
	driver = new oracle.jdbc.driver.OracleDriver();
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	java.util.Properties info = new java.util.Properties();
	info. setProperty("user", "scott");
	info. setProperty("password", "tiger");
	
	String sql = "select * from stu01 order by num";
	java.sql.Connection conn = null;
	java.sql.Statement stmt = null;
	java.sql.ResultSet rs = null;
	try {
		conn = java.sql.DriverManager.getConnection(url, info);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
%>
		<tr>
			<form action="update.jsp">
				<td><input type="text" name="num" value="<%= rs.getObject(1) %>" readonly="readonly"></td>
				<td><input type="text" name="kor" value="<%= rs.getObject(2) %>"></td>
				<td><input type="text" name="eng" value="<%= rs.getObject(3) %>"></td>
				<td><input type="text" name="math" value="<%= rs.getObject(4) %>"></td>
				<td><input type="submit" value="수정" class="btn_ud"></td>
			</form>
			<td>
				<form action="delete.jsp" method="post">
					<input type="hidden" name="num" value="<%= rs.getObject(1) %>">
					<input type="submit" value="삭제" class="btn_dl">
				</form>
			</td>
		</tr>
<%
		}
	} catch (Exception e) {
		e.printStackTrace();
%>
		<tr>
			<td colspan="4">네트워크 통신이 원활하지 않습니다.<br>잠시 후 다시 접속해주세요.</td>
		</tr>
<%
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
%>
	</table>
	<p><a href="add.jsp">[입 력]</a></p>
</body>
</html>