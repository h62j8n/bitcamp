<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/" var="root"></c:url>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
		var sock = new SockJS('${root}echo');
		
		sock.onmessage = function(msg) {
			$('#target').append(msg.data+'<br>');
		}
		$(function() {
			$('button').on('click', function() {
				sock.send($('input').val());
				$('input').val('');
			});
		});
	</script>
</head>
<body>
	<h1>Echo Server</h1>
	<div>
		<input type="text">
		<button>전송</button>
	</div>
	<p id="target"></p>
</body>
</html>
