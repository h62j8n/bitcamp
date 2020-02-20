<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	
	int num=Integer.parseInt(request.getParameter("num"));
	com.bit.model.Bbs01Dao dao=new com.bit.model.Bbs01Dao();
	com.bit.model.Bbs01Dto bean=dao.getBean(num);
	%>
	<h1>수정페이지</h1>
	<form action="bbs/update.jsp" method="post">
		<input type="hidden" name="num" value="<%=bean.getNum()%>">
		<table>
			<tr>
				<td>글번호</td>
				<td><%=bean.getNum() %></td>
				<td>글쓴이</td>
				<td><%=bean.getId() %></td>
				<td>날짜</td>
				<td><%=bean.getNalja() %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="5"><input type="text" name="sub" value="<%=bean.getSub()%>"></td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="content" rows="5" cols="50"><%=bean.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="submit" value="수 정">
					<input type="reset" value="취 소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>




