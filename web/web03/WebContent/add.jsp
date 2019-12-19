<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>
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
			<form action="insert.jsp" align="center">
			<table>
			<tr>
			<td bgcolor="dddddd">제목</td>
			<td><input type="text" name="sub"></td>
			</tr>
			<tr>
			<td bgcolor="dddddd">글쓴이</td>
			<td><input type="text" name="id"></td>
			</tr>
			<tr>
			<td bgcolor="dddddd">내 용</td>
			<td><textArea cols="50" rows="5" name="content"></textArea></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="글쓰기">
			<input type="reset" value="취 소">
			</table>
			</form>
			</td>
		</tr>
		<tr>
			<td colspan="7"><img alt="" src="imgs/footer.jpg"></td>
		</tr>

	</table>
</body>
</html>