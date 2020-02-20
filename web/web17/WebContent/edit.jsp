<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/css/reset.css">
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap">
	<link rel="stylesheet" type="text/css" href="source/css/bit_grid.css">
	<link rel="stylesheet" type="text/css" href="source/css/layout.css">
	<script type="text/javascript">
		var detail, msg1, msg2, msg3, msg4, msg5, btnEdit;
		var xhr;
		
		function myAjax () {
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open("get", "detail.jsp?num=<%= request.getParameter("num") %>");
			xhr.send();
		}
		
		function callback() {
			var msg;
			if (xhr.readyState == 4 && xhr.status == 200) {
				msg = xhr.responseText;
				// msg = JSON.parse(msg);
			}
			var obj = JSON.parse(msg);
			var arr = obj.root;
			msg1.innerText = arr[0].num;
			msg2.innerText = arr[0].id;
			msg3.innerText = arr[0].nalja;
			msg4.innerText = arr[0].sub;
			msg5.innerText = arr[0].content;
		};
		
		window.onload = function() {
			detail = document.querySelector(".detail");
			msg1 = detail.getElementsByTagName("span")[1];
			msg2 = detail.getElementsByTagName("span")[3];
			msg3 = detail.getElementsByTagName("span")[5];
			msg4 = detail.getElementsByTagName("span")[7];
			msg5 = detail.getElementsByTagName("pre")[0];
			edit = detail.getElementsByTagName("a")[0];
			myAjax();
			edit.onClick = function() {
				
			};
		};
	</script>
</head>
<body>
	<div class="container">
		<div id="header" class="row">
			<div class="grid12">
				<h1>비트교육센터</h1>
			</div>
		</div>
		<div id="menu" class="row">
			<div class="grid12">
				<ul>
					<li><a href="index.html">HOME</a></li>
					<li><a href="list.html">BBS</a></li>
					<li><a href="#">LOGIN</a></li>
					<li><a href="#">ETC</a></li>
				</ul>
			</div>
		</div>
		<div id="content" class="row">
			<div class="grid12">
				<div class="detail">
					<h2>게시물 상세</h2>
					<div>
						<p>
							<span>번호</span>
							<span></span>
						</p>
						<p>
							<span>작성자</span>
							<span></span>
						</p>
						<p>
							<span>날짜</span>
							<span></span>
						</p>
					</div>
					<div>
						<p>
							<span>제목</span>
							<span></span>
						</p>
					</div>
					<div>
						<pre></pre>
					</div>
					<div class="btns_box">
						<button type="button">수정</button>
						<button type="button">삭제</button>
					</div>
					<form id="editForm">
						
					</form>
				</div>
			</div>
		</div>
		<div id="footer" class="row">
			<div class="grid12">
				<p>비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)</p>
				<p>Copyright &copy; 비트캠프 All rights reserved.</p>
			</div>
		</div>
	</div>
</body>
</html>