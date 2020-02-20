<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	<title>Insert title here</title>
</head>
<body>
	<div class="btn-group btn-group-justified" role="group" aria-label="...">
		<a href="./index.action" class="btn btn-default">HOME</a>
		<a href="./intro.action" class="btn btn-default">INTRO</a>
		<a href="./list.action" class="btn btn-danger">BBS</a>
		<a href="./login.action" class="btn btn-default">LOGIN</a>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h1>LIST</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="insert.action">
					<div class="form-group">
						<label for="sabun">사번</label>
						<input type="text" class="form-control" id="sabun" name="sabun" value="${param.sabun}">
						<!-- 
						<input type="text" class="form-control" id="sabun" name="sabun" value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>">
						 -->
					</div>
					<div class="form-group">
						<label for="name">이름</label>
						<input type="text" class="form-control" id="name" name="name" value="${param.name}">
						
					</div>
					<div class="form-group">
						<label for="pay">금액</label>
						<input type="text" class="form-control" id="pay" name="pay" value="${param.pay}">
					</div>
					<div class="form-group">
						${errMsg}
					</div>
					<button type="submit" class="btn btn-danger">입력</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>