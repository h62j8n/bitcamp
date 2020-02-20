<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="java.sql.*, com.bit.web05.*" %>
<%!
	// 필드 선언 (디폴트 초기화), 좋은 패턴은 아닙니다.
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	// 인젝션 디펜스
	public String check(String msg) {
		msg = msg.replace("--", "­­");	// 대체문자는 인코딩이 불가능한 특수문자이다.
		msg = msg.replace("(", "（");
		msg = msg.replace(")", "）");
		msg = msg.replace("\'", "＇");
		return msg;
	}
%>
<%
if (request.getMethod().equals("POST")) {
	String id = check(request.getParameter("id"));
	String pw = check(request.getParameter("pw"));
	String sql = "SELECT COUNT(id) as \"loginCnt\", MAX(nick), MAX(id) FROM bbs01user WHERE id='"+id+"' AND pw='"+pw+"'";
	
	Bbs01userBean bean = new Bbs01userBean();
	
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			bean.setLoginCnt(rs.getInt(1));
			bean.setNick(rs.getString(2));
			bean.setId(rs.getString(3));
		}
		if (bean.getLoginCnt() > 0) {
			session.setAttribute("login", bean);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://localhost:8080/web05/layout.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="post">
		<p>id : <input type="text" name="id"></p>
		<p>pw : <input type="password" name="pw"></p>
		<input type="submit" value="로그인" class="comm_btn">
	</form>
</body>
</html>