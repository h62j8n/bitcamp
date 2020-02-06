<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 의 표현</h1>
	<%
		String msg="출력";
		pageContext.setAttribute("msg", msg);
	%>
	<p>
		<div>java:<%=pageContext.getAttribute("msg") %></div>
		<div>EL :${msg }</div>
	</p>
	<div>
		<%
			String[] msgs={"a","ab","abc","abcd"};
			pageContext.setAttribute("msgs", msgs);
			String[] arr1=(String[])pageContext.getAttribute("msgs");
		%>
		<ul>
			<li><%=arr1[0] %></li>
			<li><%=arr1[1] %></li>
			<li><%=arr1[2] %></li>
			<li><%=arr1[3] %></li>
		</ul>
		<ul>
			<li>${msgs[0] }</li>
			<li>${msgs[1] }</li>
			<li>${msgs[2] }</li>
			<li>${msgs[3] }</li>
		</ul>
		
		<%
			ArrayList list=new ArrayList();
			list.add("1");
			list.add("12");
			list.add("123");
			list.add("1234");
			pageContext.setAttribute("alist", list);
			ArrayList arr2=(ArrayList)pageContext.getAttribute("alist");
		%>
		<ul>
			<li><%=arr2.get(0) %></li>
			<li><%=arr2.get(1) %></li>
			<li><%=arr2.get(2) %></li>
			<li><%=arr2.get(3) %></li>
		</ul>
		<ul>
			<li>${alist.get(0) }</li>
			<li>${alist.get(1) }</li>
			<li>${alist.get(2) }</li>
			<li>${alist.get(3) }</li>
		</ul>
		<%
			java.util.HashMap map=new HashMap();
			map.put("key1", "val1");
			map.put("key2", "val2");
			map.put("key3", "val3");
			map.put("key4", "val4");
			pageContext.setAttribute("hmap", map);
			HashMap arr3=(HashMap)pageContext.getAttribute("hmap");
		%>
		<ul>
			<li><%=arr3.get("key1") %></li>
			<li><%=arr3.get("key2") %></li>
			<li><%=arr3.get("key3") %></li>
			<li><%=arr3.get("key4") %></li>
		</ul>
		<ul>
			<li>${hmap.key1 }</li>
			<li>${hmap.key2 }</li>
			<li>${hmap.key3 }</li>
			<li>${hmap.key4 }</li>
		</ul>
	</div>
	
	<jsp:useBean id="bean" class="com.bit.mvc03.utils.JavaBean" scope="application"></jsp:useBean>
	<jsp:setProperty property="su1" name="bean" value="1234"/>
	<jsp:setProperty property="su2" name="bean" value="3.14"/>
	<jsp:setProperty property="boo" name="bean" value="true"/>
	<jsp:setProperty property="ch" name="bean" value="가"/>
	<jsp:setProperty property="msg" name="bean" value="한글"/>
	
	<%
		//pageContext.setAttribute("dto", bean);
		//com.bit.mvc03.utils.JavaBean dto;
		//dto=(com.bit.mvc03.utils.JavaBean)pageContext.getAttribute("dto");
	%>
	<ul>
		<li><%=bean.getSu1() %></li>
		<li><%=bean.getSu2() %></li>
		<li><%=bean.isBoo() %></li>
		<li><%=bean.getCh() %></li>
		<li><%=bean.getMsg() %></li>
	</ul>
	
	<ul>
		<li>${bean.su1 }</li>
		<li>${bean.su2 }</li>
		<li>${bean.boo }</li>
		<li>${bean.ch }</li>
		<li>${bean.msg }</li>
	</ul>
</body>
</html>












