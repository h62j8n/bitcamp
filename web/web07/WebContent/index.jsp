<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="com.bit.dto.Bbs02Bean, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="connection.jspf" %>
<%
/*	���������̼�
 *	int p = 2;
 *	int pStart = 10 * (p-1) + 1;	// 11
 *	int pEnd = pStart+9;			// 20
 */
 	int p = 1;
 	int pCnt = 10;
 	int pTotal = 0;
 	String word = "";
 	String param1 = request.getParameter("page");
 	String param2 = request.getParameter("pCnt");
 	String param3 = request.getParameter("word");
 	if (param1 != null) {
		p = Integer.parseInt(param1);
	}
 	if (param2 != null) {
		pCnt = Integer.parseInt(param2);
	}
 	if (param3 != null) {
 		word += param3 + "%";
 	}
 	int pStart=((p-1)*10)+1;
	int pEnd= pStart + 9;
	String sql = "SELECT * FROM (SELECT rownum AS rn, num, sub, id, nalja, num_lev"
			+ " FROM (SELECT num, sub, id, nalja, num_lev FROM bbs02"
			+ " ORDER BY num_ref DESC, num_no DESC)) WHERE rn BETWEEN "+pStart+" AND "+pEnd;
	ArrayList<Bbs02Bean> list = new ArrayList<Bbs02Bean>();
	
	try {
		conn = getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT count(*) FROM bbs02 WHERE sub LIKE '%"+word+"%'");
		if (rs.next()) {
			pTotal = rs.getInt(1);
		}
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			Bbs02Bean bean = new Bbs02Bean();
			bean.setNum(rs.getInt("num"));
			bean.setSub(rs.getString("sub"));
			bean.setId(rs.getString("id"));
			bean.setNalja(rs.getDate("nalja"));
			bean.setNum_lev(rs.getInt("num_lev"));
			list.add(bean);
		}
		
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
%>
<form>
	<select name="pCnt">
		<option value="5">5���� ����</option>
		<option value="10">10���� ����</option>
		<option value="15">15���� ����</option>
		<option value="20">20���� ����</option>
	</select>
	<input type="submit" value="����">
</form>
<table width="500" border="1">
	<tr>
		<th width="60">��ȣ</th>
		<th width="240">����</th>
		<th width="100">�ۼ���</th>
		<th width="100">��¥</th>
	</tr>
	<%
	for (int i=0; i<list.size(); i++) {
		Bbs02Bean bean = list.get(i);
	%>
	<tr>
		<td><%= bean.getNum() %></td>
		<td>
			<a href="detail.jsp?num=<%= bean.getNum() %>">
			<%
			// �亯�� ó��
			for (int j=0; j<bean.getNum_lev(); j++) {
				out.print("��");	// ������ŭ �鿩����
			}
			if (bean.getNum_lev() != 0) {
				out.print("�� ");	// �亯�� ��ũ
			}
			out.print(bean.getSub());
			%>
			</a>
		</td>
		<td><%= bean.getId() %></td>
		<td><%= bean.getNalja() %></td>
	</tr>
	<%
	}
	%>
</table>
<p>
<%
/* int start = p-2;	// p�� 5�� �� ���� ������ �ѹ��� �׻� ����� �δ� ����
 * int end = p+2;
 */
int gap = 5;
int start = (p - 1) / gap * gap + 1;
int end = start + (gap - 1);	// (pTotal-1)/pCnt+1

if (start != 1) {
	out.print("<a href=\"index.jsp?page=" + (start-1) + "&word="+word+"\">����</a>");
}
if (end > (pTotal-1)/pCnt+1) {
	end = (pTotal-1)/pCnt+1;
}
for (int i=start; i<end; i++) {
	String msg2 = "";
	if (p != i) {
		msg2 = "href=\"index.jsp?page=" + i + "\"&pCnt="+pCnt+"&word="+word+"\"";
	}
%>
	<a href="index.jsp?page=<%= i %>">[<%= i %>]</a>
<%
}
String msg = "";
if (end<(pTotal-1)/pCnt+1) {
	out.print("<a href=\"index.jsp?page="+(end+1)+"\">����</a>");
}
%>
</p>
<form>

</form>

<a href="add.jsp">�Է�</a>
</body>
</html>