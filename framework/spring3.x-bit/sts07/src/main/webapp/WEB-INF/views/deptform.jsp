<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
<script type="text/javascript" src="../resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
</head>
<body style="padding-top: 70px;">

<!-- validation -->
<c:if test="${bean ne null}">
	<c:if test="${bean.deptno == 0}">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Error</strong> dname을 입력하세요.
	</div>
	</c:if>
</c:if>

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
					<li class="active dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							DEPT <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${root}dept/list">LIST</a></li>
							<li><a href="${root}dept/add">INSERT</a></li>
						</ul>
					</li>
					<li class="dropdown">
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
				<div class="jumbotron">
					<h1>${title}</h1>
					<p>...</p>
					<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="${action}" method="${method}">
					<c:if test="${title ne 'INSERT'}">
					<div class="form-group">
						<label for="deptno">deptno</label>
						<input type="text" class="form-control" id="deptno" name="deptno" value="${bean.deptno}" readonly="readonly">
						<!-- value : validation -->
					</div>
					</c:if>
					<div class="form-group">
						<label for="dname">dname</label>
						<input type="text" class="form-control" id="dname" name="dname" value="${bean.dname}" ${disabled}>
						<!-- value : validation -->
					</div>
					<div class="form-group">
						<label for="loc">loc</label>
						<input type="text" class="form-control" id="loc" name="loc" value="${bean.loc}" ${disabled}>
					</div>
					<button type="submit" class="btn btn-default">${btn1}</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
