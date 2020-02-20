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
   String p="main";
   String param1=request.getParameter("p");
   if(param1!=null){
      p=request.getParameter("p");
   }
      p="bbs/"+p+".jsp";
%>
<table width="800">
	<tr>
		<td colspan="7"><img src="imgs/logo.jpg"></td>
	</tr>
	<tr>
		<td></td>
		<td width="120"><a href="./?p=main"><img src="imgs/menu1.png"></a></td>
		<td width="128"><img src="imgs/menu2.png"></td>
		<td width="115"><a href="./?p=list"><img src="imgs/menu3.png"></a></td>
		<td width="114"><img src="imgs/menu4.png"></td>
		<td width="125"><img src="imgs/menu5.png"></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="7">
		<!-- content start -->
		<jsp:include page="<%=p %>"></jsp:include>
		<!-- content end -->
		</td>
	</tr>
	<tr>
		<td colspan="7"><img src="imgs/footer.png"></td>
	</tr>
</table>
</body>
</html>