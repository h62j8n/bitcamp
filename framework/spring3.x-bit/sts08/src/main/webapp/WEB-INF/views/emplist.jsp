<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.css">
<script type="text/javascript" src="${root}/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${root}/js/bootstrap.js"></script>
</head>
<body style="padding-top: 70px;">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${root}">h62j8n</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${root}">HOME</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							DEPT <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${root}dept/list">LIST</a></li>
							<li><a href="${root}dept/add">INSERT</a></li>
						</ul>
					</li>
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							EMP <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${root}emp/list">LIST</a></li>
							<li><a href="${root}emp/add">INSERT</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						LIST <small>EMP table row (${total})</small>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>날짜</th>
						<th>금액</th>
					</tr>
					<c:forEach items="${list}" var="bean">
					<tr>
						<td><a href="detail/${bean.sabun}">${bean.sabun}</a></td>
						<td><a href="detail/${bean.sabun}">${bean.name}</a></td>
						<td><a href="detail/${bean.sabun}">${bean.nalja}</a></td>
						<td><a href="detail/${bean.sabun}">${bean.pay}</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
