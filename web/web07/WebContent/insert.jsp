<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="connection.jspf" %>
<%
	String id = request.getParameter("id");
	String sub = request.getParameter("sub");
	String content = request.getParameter("content");
/*	# ������ �������� Statement��ü ó��
 *	String sql = "INSERT INTO bbs02 (num, id, sub, content, nalja, num_ref)"
 *				+ " values (bbs02_seq.NEXTVAL, '"+id+"', '"+sub+"', '"+content+"', SYSDATE, bbs02_seq.CURRVAL)";
 */
 
 // # ? �������� prepareStatement��ü ó��
	String sql = "INSERT INTO bbs02 (num, id, sub, content, nalja, num_ref)"
			+ " values (bbs02_seq.NEXTVAL, ?, ?, ?, SYSDATE, bbs02_seq.CURRVAL)";
	try {
		conn = getConnection();
/*	# ������ �������� Statement��ü ó��
 *		stmt = conn.createStatement();
 *		stmt.executeUpdate(sql);
 */
 
//		# ? �������� prepareStatement��ü ó��
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);				// getParameter�� ���� ���� ���� ù��° ����ǥ(id�÷�)�� �Է�
		pstmt.setString(2, sub);
		pstmt.setString(3, content);
		pstmt.executeUpdate();
		
	} finally {
/*	# ������ �������� Statement��ü ó��
 *		if (stmt != null) stmt.close();
 */
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
	
	response.sendRedirect("/web07/");
%>
</body>
</html>