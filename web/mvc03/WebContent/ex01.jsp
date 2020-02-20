<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

	table{
		width: 80%;
	}
	th,td{
		border:1px solid gray;
	}

</style>
<title>Insert title here</title>
</head>
<body>
	<h1>EL 표현식</h1>
	<p>${1234+100}</p>
	<h2>자료형</h2>
	<table>
		<tr>
			<th>자료형</th>
			<th>표현식</th>
			<th>java</th>
			<th>el</th>
		</tr>
		<tr>
			<td>문자열</td>
			<td>＄{"abc"}</td>
			<td><%="abc" %></td>
			<td>${"abc" }</td>
		</tr>
		<tr>
			<td>문자열</td>
			<td>＄{'abc'}</td>
			<td><%="abc" %></td>
			<td>${'abc' }</td>
		</tr>
		<tr>
			<td>숫자(정수)</td>
			<td>＄{1234}</td>
			<td><%=1234 %></td>
			<td>${1234 }</td>
		</tr>
		<tr>
			<td>숫자(실수)</td>
			<td>＄{3.14}</td>
			<td><%=3.14 %></td>
			<td>${3.14 }</td>
		</tr>
		<tr>
			<td>boolean</td>
			<td>＄{true }</td>
			<td><%=true %></td>
			<td>${true }</td>
		</tr>
		<tr>
			<td>boolean</td>
			<td>＄{false }</td>
			<td><%=false %></td>
			<td>${false }</td>
		</tr>
		<tr>
			<td>NULL</td>
			<td>＄{null}</td>
			<td><%
			Object obj=null;
			out.println(obj); %></td>
			<td>${null }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{1+2}</td>
			<td><%=1+2 %></td>
			<td>${1+2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{5-2}</td>
			<td><%=5-2 %></td>
			<td>${5-2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{6*2}</td>
			<td><%=6*2 %></td>
			<td>${6*2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{6/2}</td>
			<td><%=6/2 %></td>
			<td>${6/2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{5/2}</td>
			<td><%=5/2 %></td>
			<td>${5/2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{5%2}</td>
			<td><%=5%2 %></td>
			<td>${5%2 }</td>
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{5 div 2}</td>
			<td><%=5/2 %></td>
<<<<<<< HEAD
			<td><!-- ${5 div 2 } --></td>
=======
			<td>${5 div 2 }</td>
>>>>>>> 0b9268d46ce442e29a716da2162ffb8bd68f1646
		</tr>
		<tr>
			<td>연산</td>
			<td>＄{5 mod 2}</td>
			<td><%=5%2 %></td>
			<td>${5 mod 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{100==100}</td>
			<td><%=100==100 %></td>
			<td>${100==100 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{100 eq 100}</td>
			<td><%=100==100 %></td>
			<td>${100 eq 100 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3>2}</td>
			<td><%=3>2 %></td>
			<td>${3>2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3 gt 2}</td>
			<td><%=3>2 %></td>
			<td>${3 gt 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3<2}</td>
			<td><%=3<2 %></td>
			<td>${3<2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3 lt 2}</td>
			<td><%=3<2 %></td>
			<td>${3 lt 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3>=2}</td>
			<td><%=3>=2 %></td>
			<td>${3>=2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3 ge 2}</td>
			<td><%=3>=2 %></td>
			<td>${3 ge 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3<=2}</td>
			<td><%=3<=2 %></td>
			<td>${3<=2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td>＄{3 le 2}</td>
			<td><%=3<=2 %></td>
			<td>${3 le 2 }</td>
		</tr>
		<tr>
			<td></td>
			<td>＄{null}</td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>












