<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="template/header.jsp">
		<jsp:param value="./" name="path" />
	</jsp:include>
	
	<!-- menu -->
	<jsp:include page="template/menu.jsp">
		<jsp:param value="./" name="path" />
	</jsp:include>
	
	<!-- content -->
	<h2>환영합니다</h2>
	<p>6개월동안 고생해보세요</p>
	
	<!-- footer -->
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>