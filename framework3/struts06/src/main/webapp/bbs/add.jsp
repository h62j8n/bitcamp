<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
	integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
	crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					<div>비트교육센터</div>
				</a>
			</div>
			<!-- end navbar-header -->
			<p class="navbar-text navbar-right">
				<a href="home.bit" class="navbar-link">[HOME]</a> <a
					href="intro.bit" class="navbar-link">[INTRO]</a> <a
					href="bbs/list.bit" class="navbar-link">[B B S]</a> <a href="#"
					class="navbar-link">[LOGIN]</a>
			</p>
		</div>
		<!-- end container-fluid -->
	</nav>
	<div class="jumbotron">
		<h1>List Page!</h1>
		<a href="add.bit" class="btn btn-default" role="button">입력</a>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-6">item1</div>
			<div class="page-header">
				<h2>
					입력페이지 <small>emp02 content</small>
				</h2>
			</div>
			<form class="form-horizontal" action="insert.bit" method="post">
				<div class="form-group">
					<label for="sabun">사번</label> <input
						type="text" class="form-control" name="sabun" id="sabun"
						placeholder="사번" value=${bean.sabun }>
						<label for="name">이름</label> <input
						type="text" class="form-control" name="name" id="name"
						placeholder="이름" value="${bean.name }">
						<label for="pay">금액</label> <input
						type="text" class="form-control" name="pay" id="pay"
						placeholder="금액" value="${bean.pay }">
						
				</div>
				<button type="submit" class="btn btn-default">입력</button>
				<button type="reset" class="btn btn-default">취소</button>
			</form>
			
					<!-- 	<s:form action="insert">
				<s:textfield name="bean.sabun" label="sabun" />
				<s:textfield name="bean.name" label="name" />
				<s:textfield name="bean.pay" label="pay" />
				<s:submit />
			</s:form> -->
		</div>
	</div>
</body>
</html>