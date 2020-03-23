<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function() {
			$('form button[type="button"]').on('click', function() {
				$('<input type="file" name="files">').appendTo('form>div:eq(1)');
			});
		});
	</script>
</head>
<body>
	<h1>Hello world!</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" />
		</div>
		<div>
			<label for="files">file</label>
			<input type="file" name="files" />
		</div>
		<button type="button">추가</button>
		<button type="submit">전송</button>
	</form>
</body>
</html>
