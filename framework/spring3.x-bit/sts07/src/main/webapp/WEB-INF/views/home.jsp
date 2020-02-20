<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
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
					<li class="active"><a href="${root}">HOME</a></li>
					<li class="dropdown">
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

				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="width: 512px; margin: 0 auto">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
				  
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active"><img src="resources/images/vegetables1.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables2.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables3.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables4.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables5.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables6.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables7.png" alt=""></div>
						<div class="item"><img src="resources/images/vegetables8.png" alt=""></div>
					</div>
				  
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					  <span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					  <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
