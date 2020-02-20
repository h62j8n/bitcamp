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
/*	# 기존의 쿼리문과 Statement객체 처리
 *	String sql = "INSERT INTO bbs02 (num, id, sub, content, nalja, num_ref)"
 *				+ " values (bbs02_seq.NEXTVAL, '"+id+"', '"+sub+"', '"+content+"', SYSDATE, bbs02_seq.CURRVAL)";
 */
 
 // # ? 쿼리문과 prepareStatement객체 처리
	String sql = "INSERT INTO bbs02 (num, id, sub, content, nalja, num_ref)"
			+ " values (bbs02_seq.NEXTVAL, ?, ?, ?, SYSDATE, bbs02_seq.CURRVAL)";
	try {
		conn = getConnection();
/*	# 기존의 쿼리문과 Statement객체 처리
 *		stmt = conn.createStatement();
 *		stmt.executeUpdate(sql);
 */
 
//		# ? 쿼리문과 prepareStatement객체 처리
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);				// getParameter를 통해 받은 값을 첫번째 물음표(id컬럼)에 입력
		pstmt.setString(2, sub);
		pstmt.setString(3, content);
		pstmt.executeUpdate();
		
	} finally {
/*	# 기존의 쿼리문과 Statement객체 처리
 *		if (stmt != null) stmt.close();
 */
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
	
	response.sendRedirect("/web07/");
%>
</body>
</html>