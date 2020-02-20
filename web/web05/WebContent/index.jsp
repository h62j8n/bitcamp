<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="http://localhost:8080/web05/layout.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%
Object obj = session.getAttribute("login");
if (obj != null) {
	Bbs01userBean user = (Bbs01userBean) obj;
	out.print(user.getNick()+"님 환영합니다.");
	out.print("<a href=\"logout.jsp\" class=\"comm_btn\">로그아웃</a>");
} else {
%>
	<a href="login.jsp" class="comm_btn">로그인</a>
<%
}
%>
	<h1>게시판</h1>
	<a href="add.jsp" class="comm_btn">작성</a>
	<%@ page import = "java.sql.*, java.util.*, com.bit.web05.*" %>
	<%
	String sql = "SELECT num, sub, (SELECT nick FROM bbs01user B WHERE B.id = A.id) as \"nick\", nalja FROM bbs01 A ORDER BY A.num DESC";
	// ORDER BY = 순서가 있는 동적 할당
	List<JavaBean> list = new ArrayList<JavaBean>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		conn = MyOracle.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			JavaBean bean = new JavaBean();
//			값을 받아올 타입이 데이터테이블의 타입과 달라도 무방하다.
//			row[0] = rs.getString("num");
			bean.setNum(rs.getInt("num"));
			bean.setSub(rs.getString("sub"));
			bean.setNick(rs.getString("nick"));
//			문자열 제어
//			row[3] = rs.getString("nalja").split(" ")[0].replace("-", "/").substring(2);
			bean.setNalja(rs.getDate("nalja"));
			list.add(bean);
		}
		
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	%>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
<%
	for (int i=0; i<list.size(); i++) {
		JavaBean bean = list.get(i);
%>
		<tr>
			<td><%= bean.getNum() %></td>
			<td><a href="detail.jsp?num=<%= bean.getNum() %>"><%= bean.getSub() %></a></td>
			<td><%= bean.getNick() %></td>
			<td><%= bean.getNalja() %></td>
		</tr>
<%
	}
%>
	</table>
	
	<h2><%= com.bit.web05.Test.nalja %></h2>
	<!-- 서버 실행 시 Test.java 파일에서 생성된 객체이므로 새로고침해도 시간 변화가 없다 -->
	<h2><%= new java.util.Date() %></h2>
	<!-- 서버를 새로고침 할 때마다 생성하기 때문에 시간이 업데이트 된다 -->
	
	<h2>conn1 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<h2>conn2 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<!-- 동일한 객체인가? -->
	<h2>close? = <%= com.bit.web05.MyOracle.getConnection().isClosed() %></h2>
	<!-- 객체가 클로즈되었는가? -->
	<h2>close <% com.bit.web05.MyOracle.getConnection().close(); %></h2>
	<!-- 클로즈 해보기 -->
	<h2>conn3 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<h2>close? <%= com.bit.web05.MyOracle.getConnection().isClosed() %></h2>
	<!-- 다시 커넥션 객체를 받아서 클로즈되었는지 확인해보기 -->
</body>
</html>