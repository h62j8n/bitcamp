<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
		 href="/sts02/css/bootstrap.min.css" />
<script type="text/javascript" src="/sts02/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/sts02/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${param.err ne null }">
<div class="alert alert-danger" role="alert">${param.err }</div>
</c:if>

<div class="container">
<div class="row">
  	<div class="col-md-12">
	  	<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="/sts02/">
		        <div>비트교육센터</div>
		      </a>
		    </div>
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav">
			        <li><a href="/sts02/">HOME</a></li>
			        <li><a href="/sts02/dept/list.bit">DEPT</a></li>
			        <li class="active"><a href="/sts02/emp/list.bit">E M P</a></li>
			        <c:if test="${sessionScope.login eq null }">
			        <li><a href="/sts02/login.bit">LOGIN</a></li>
			        </c:if>
			        <c:if test="${sessionScope.login ne null }">
			        <li><a href="/sts02/logout.bit">LOGOUT</a>
			        </li>
			        </c:if>
			    </ul>
			    <c:if test="${sessionScope.login ne null }">
			    <p class="navbar-text"> ${login }님 환영합니다 </p>
			    </c:if>
		    </div>
		  </div>
		</nav>
  	</div>
</div>
<div class="row">
  	<div class="col-md-12">
	<!-- content start -->
	
	<form class="form-horizontal" action="insert.bit" method="post">
		<div class="form-group">
		    <label for="name" class="col-sm-2 control-label">name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="name" id="name" placeholder="name">
		    </div>
		</div>
		
		<div class="form-group">
		    <label for="pay" class="col-sm-2 control-label">pay</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="pay" id="pay" placeholder="pay">
		    </div>
		</div>
		
		<div class="form-group">
		    <label for="deptno" class="col-sm-2 control-label">deptno</label>
		    <div class="col-sm-10">
		      <select name="deptno"  class="form-control">
		      	<c:forEach items="${list }" var="bean">
		      	<option value="${bean.deptno }"> ${bean.dname }</option>
		      	</c:forEach>
		      </select>
		    </div>
		</div>
		
		<div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Sign in</button>
		    </div>
		</div>
	</form>	
	
	<!-- content end -->
	</div>
</div>
</div>
</body>
</html>









