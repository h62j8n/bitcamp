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
	out.print(user.getNick()+"�� ȯ���մϴ�.");
	out.print("<a href=\"logout.jsp\" class=\"comm_btn\">�α׾ƿ�</a>");
} else {
%>
	<a href="login.jsp" class="comm_btn">�α���</a>
<%
}
%>
	<h1>�Խ���</h1>
	<a href="add.jsp" class="comm_btn">�ۼ�</a>
	<%@ page import = "java.sql.*, java.util.*, com.bit.web05.*" %>
	<%
	String sql = "SELECT num, sub, (SELECT nick FROM bbs01user B WHERE B.id = A.id) as \"nick\", nalja FROM bbs01 A ORDER BY A.num DESC";
	// ORDER BY = ������ �ִ� ���� �Ҵ�
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
//			���� �޾ƿ� Ÿ���� ���������̺��� Ÿ�԰� �޶� �����ϴ�.
//			row[0] = rs.getString("num");
			bean.setNum(rs.getInt("num"));
			bean.setSub(rs.getString("sub"));
			bean.setNick(rs.getString("nick"));
//			���ڿ� ����
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
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>��¥</th>
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
	<!-- ���� ���� �� Test.java ���Ͽ��� ������ ��ü�̹Ƿ� ���ΰ�ħ�ص� �ð� ��ȭ�� ���� -->
	<h2><%= new java.util.Date() %></h2>
	<!-- ������ ���ΰ�ħ �� ������ �����ϱ� ������ �ð��� ������Ʈ �ȴ� -->
	
	<h2>conn1 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<h2>conn2 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<!-- ������ ��ü�ΰ�? -->
	<h2>close? = <%= com.bit.web05.MyOracle.getConnection().isClosed() %></h2>
	<!-- ��ü�� Ŭ����Ǿ��°�? -->
	<h2>close <% com.bit.web05.MyOracle.getConnection().close(); %></h2>
	<!-- Ŭ���� �غ��� -->
	<h2>conn3 = <%= com.bit.web05.MyOracle.getConnection() %></h2>
	<h2>close? <%= com.bit.web05.MyOracle.getConnection().isClosed() %></h2>
	<!-- �ٽ� Ŀ�ؼ� ��ü�� �޾Ƽ� Ŭ����Ǿ����� Ȯ���غ��� -->
</body>
</html>