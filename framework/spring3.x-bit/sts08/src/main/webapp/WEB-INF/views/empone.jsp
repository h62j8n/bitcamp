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
<script type="text/javascript">
	// edit
	$(function() {
		$('form').one('submit', function() {
			$('button[type="reset"]').off('click', delRecord);	// 이벤트 오프
			
			$('.page-header').html('<h1>EDIT <small>EMP table row</small></h1>')
			$('#name, #pay').removeAttr('disabled');
			return false;
		});
		$('button[type="reset"]').on('click', delRecord);
	});
	
	// delete
	function delRecord() {
		var param = {'sabun': ${bean.sabun}};
		$.post('../delete', param, function(){
			window.location.replace('../list');
		});
	}
</script>
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
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">EMP</a></li>
					<li>DETAIL</li>
					<li class="active">${bean.sabun}</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						DETAIL <small>EMP table row</small>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="../edit" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="sabun" class="col-sm-2 control-label">사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="sabun" id="sabun" value="${bean.sabun}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="name" id="name" value="${bean.name}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="nalja" class="col-sm-2 control-label">날짜</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="nalja" id="nalja" value="${bean.nalja}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label for="pay" class="col-sm-2 control-label">금액</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="pay" id="pay" value="${bean.pay}" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<div class="btn-group btn-group-justified" role="group">
							<button type="button" class="btn btn-default" onclick="historyback()">BACK</button>
							<button type="submit" class="btn btn-primary">EDIT</button>
							<button type="reset" class="btn btn-default">DELETE</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
