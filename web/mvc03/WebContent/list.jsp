<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.table{
		
	}
	.table a{
		text-decoration: none;
	}
	.table>.record{}
	.table .record>span{
		display: inline-block;
		width: 24%;
		height: 30px;
		line-height: 30px;
	}
	.table>.thead>span{
		background-color: gray;
		text-align: center;
		font-weight: bold;
	}
	.table .tbody{
		border-bottom-color: gray;
		border-bottom-style: dotted;
		border-bottom-width: 1px;
	}
	.table .tbody>span{
		text-align: center;
	}
	.table .tbody>span:nth-child(1)
	,.table .tbody>span:nth-child(4)
	{
		text-align: right;
	}
	#content h2+div{
		text-align: right;
	}
</style>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script type="text/javascript">

</script>
<title>Insert title here</title>
</head>
<body>
<c:url value="/" var="root"/>
<div id="header">
	<h1>비트교육센터</h1>
</div>
<div id="menu">
	<a href="${root }index.html">HOME</a>
	<a href="${root }intro.html">INTRO</a>
	<a href="${root }emp/list.html">E M P</a>
	<a href="${root }login/login.html">LOGIN</a>
</div>
<div id="content">
	<h2>리스트 페이지</h2>
	<div>
		<a href="add.html">입력</a>
	</div>
	<div class="table">
		<div class="record thead">
			<span>사번</span>
			<span>이름</span>
			<span>날짜</span>
			<span>금액</span>
		</div>
		<c:forEach items="${alist }" var="bean">
		<a href="detail.html?idx=${bean.sabun }">
			<div class="record tbody">
				<span>${bean.sabun }</span>
				<span>${bean.name }</span>
				<span>${bean.nalja }</span>
				<span>${bean.pay }</span>
			</div>
		</a>
		</c:forEach>
	</div>
</div>
<div id="footer">
	<address>서울 강남구 테헤란로5길 11 YOO빌딩 3층</address>
	Copyright &copy; 비트캠프 All rights reserved.
</div>
</body>
</html>










