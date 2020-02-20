<%@page import="java.sql.*"%>
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
			<td width="75"><a href="index.jsp" style="color:#ffffff"><img alt="" src="imgs/menu1.jpg"></a></td>
			<td width="76"><a href="sec.jsp" style="color: #ffffff"><img alt="" src="imgs/menu2.jpg"></a></td>
			<td width="59"><a href="list.jsp" style="color: #ffffff"><img alt="" src="imgs/menu3.jpg"></a></td>
			<td width="59"><img alt="" src="imgs/menu4.jpg"></td>
			<td width="70"><img alt="" src="imgs/menu5.jpg"></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="7">
			<h1>게시판</h1>
			<table align="center" width="80%" border="1" cellspacing="0">
				<tr>
					<th bgcolor="dddddd">글번호</th>
					<th bgcolor="dddddd">제목</th>
					<th bgcolor="dddddd">글쓴이</th>
					<th bgcolor="dddddd">조회수</th>		
				</tr>
				<%
				String search = request.getParameter("search");
				if(search==null)
					search="sub";
				String keyword = request.getParameter("keyword");
				if(keyword==null)
					keyword="";
				
				int show=5;
				int p=1;
				String param = request.getParameter("p");
				if(param!=null){
					p = Integer.parseInt(param);
				}

				int start = (p-1)*show +1;
				int end = start+show-1;
				int total=0;
				
				String sql="select * from ";
				sql+="(select ROWNUM as rn,NUM,SUB,ID,CNT from";
				sql+="(SELECT NUM,SUB,ID,CNT FROM BBS01 where "
							+search+" LIKE '%"+keyword+"%' ORDER BY NUM DESC))";
				sql+=" where rn between "+start+" and "+ end;
				
                String driver="oracle.jdbc.driver.OracleDriver";
                String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
                String user="scott";
                String password="tiger";
                
                Connection conn=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                   Class.forName(driver);
                   conn=DriverManager.getConnection(url, user, password);
                   stmt=conn.createStatement();
                   rs=stmt.executeQuery("select count(*) from bbs01");
                   if(rs.next())
                	   total = rs.getInt(1);
                   
                   stmt=conn.createStatement();
                   rs=stmt.executeQuery(sql);
                   while(rs.next()){
				%>
				<a href="detail.jsp?idx=<%=rs.getObject(2) %>">
				<tr>
					<td><center><%=rs.getObject(2) %></center></td>
					<td><center><%=rs.getObject(3) %></center></td>
					<td><center><%=rs.getObject(4) %></center></td>
					<td><center><%=rs.getObject(5) %></center></td>		
				</tr>
				</a>
				
				<%
					}
				}finally{
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
					if(conn != null)
						conn.close();
				}
				%>

			</table>
			<br>
			<center>
			<br>
			<%
			int su = 5;
			int limit=total/show+1;
			if(total%show==0)
				limit--;
			int forstart=(p-1)/su*su+1;
			int forend=forstart+(su-1);
			if(limit<forend)
				forend = limit;
			int i=0;
			if(forstart!=1){
			%>
			<a href="list.jsp?p=<%=forstart-1%>">[prev]</a>
			<%
			}
			for(i = forstart ;i<=forend;i++){%>
				<a href="list.jsp?p=<%=i%>">[<%=i%>]</a>
			<%
			} 
			if(limit>forend){
			%>			
			<a href="list.jsp?p=<%=i%>">[next]</a>
			<%} %>
			<br>
			<select name="search">
				<option value="sub">제목</option>
				<option value="content">내용</option>
				<option value="id">글쓴이</option>
			</select>
			<form action="">
				<input type="text" name="keyword">
				<input type="submit" value="검색">
			</form>
			</center>
			<p><a href="add.jsp">[글 쓰기]</a></p>
			</td>
		</tr>
		<tr>
			<td colspan="7"><img alt="" src="imgs/footer.jpg"></td>
		</tr>

	</table>
</body>
</html>