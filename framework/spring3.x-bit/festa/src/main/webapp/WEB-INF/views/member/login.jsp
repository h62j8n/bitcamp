<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta property="og:image"
	content="${root }resources/images/ico/logo.png">
<script type="text/javascript"
	src="${root }resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${root }resources/js/site.js"></script>
<script type="text/javascript" src="${root }resources/js/util.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="${root }resources/css/site.css">
<link rel="shortcut icon" href="${root }resources/favicon.ico">
<title>FESTA</title>
<script type="text/javascript">
	$('#btn_submit2').on("click", function() {
				$.post('${root}member/login', 'id=' + $('#id').val() + '&pw='+ $('#pw').val(), function(data) {
					if (data == '0') {
						location.href = "${root}user/";
					} else if (data == '1') {
						location.href = "${root}member/stop";
					} else if (data == '2') {
						location.href = "${root}member/kick";
					} else if (data == '3') {
						location.href = "${root}admin/";
					} else if (data == '4') {
						location.href = "${root}";
					}
				});
				return false;
			});
</script>
</head>
<body>
	<!-- #1단계팝업 로그인 -->
	<div class="login_wrap pop_wrap">
		<h2>
			<img src="${root }resources/images/ico/logo.png" alt="FESTA">
		</h2>
		<!-- 로그인 { -->
		<section id="log1" class="login_area act">
			<div>
				<h3 class="snd_only">로그인</h3>
				<form id="loginForm" name="loginForm" action="${root }member/login"
					method="post" class="comm_form">
					<div class="ip_box">
						<input id="id" name="id" type="email"
							placeholder="email@address.com">
					</div>
					<div class="ip_box">
						<input id="pw" name="pw" type="password" placeholder="password">
					</div>
					<c:if test="${data == 4 }">
					<p class="f_message rst">아이디 혹은 비밀번호를 다시 확인해주세요.</p>
					</c:if>
					<button type="submit" name="btn_submit2" id="btn_submit2"
						class="comm_btn sbm">로그인</button>
				</form>
				<dl class="lg_sns">
					<dt>SNS계정 간편 로그인</dt>
					<dd>
						<button type="button">
							<img src="${root }resources/images/ico/shp_kakao.png"
								alt="카카오 계정으로 로그인">
						</button>
					</dd>
					<dd>
						<button type="button">
							<img src="${root }resources/images/ico/shp_naver.png"
								alt="네이버 계정으로 로그인">
						</button>
					</dd>
				</dl>
				<ul class="lg_find">
					<li><a href="${root }member/join.html">회원가입</a></li>
					<li>
						<button type="button" class="btn_move" data-layer="log2">아이디</button>
						/
						<button type="button" class="btn_move" data-layer="log3">비밀번호</button>
						찾기
					</li>
				</ul>
			</div>
		</section>
		<!-- } #1단계팝업 로그인 -->
		<!-- #1단계팝업 아이디 찾기 { -->
		<section id="log2" class="find_area">
			<div>
				<h3 class="pop_tit">아이디 찾기</h3>
				<form class="comm_form">
					<div class="ip_box">
						<input type="text" id="festaFid1" name="" required="required">
						<label for="festaFid1" class="comm_label">이름</label>
					</div>
					<div class="ip_btd ip_box">
						<input type="text" id="festaFid2" name="" required="required">
						<label for="festaFid2" class="comm_label">생년월일<span>을
								입력해주세요 (예: 19940415)</span></label>
					</div>
					<p class="f_message rst">
						<!-- 일치하는 회원정보가 없습니다. -->
					</p>
					<ul class="comm_buttons">
						<li><button type="button" class="btn_move comm_btn cnc">취소</button></li>
						<li><button type="button" class="comm_btn sbm btn_pop2"
								data-layer="findId">확인</button></li>
					</ul>
				</form>
			</div>
		</section>
		<!-- } #1단계팝업 아이디찾기 -->
		<!-- #1단계팝업 비밀번호찾기 { -->
		<section id="log3" class="find_area">
			<div>
				<h3 class="pop_tit">비밀번호 찾기</h3>
				<form class="comm_form">
					<div class="ip_box">
						<input type="email" id="festaFpw1" name="" required="required">
						<label for="festaFpw1" class="comm_label">아이디<span>(이메일)</span></label>
					</div>
					<div class="ip_btd ip_box">
						<input type="text" id="festaFpw2" name="" required="required">
						<label for="festaFpw2" class="comm_label">생년월일<span>을
								입력해주세요 (예: 19940415)</span></label>
					</div>
					<p class="f_message rst">
						<!-- 일치하는 회원정보가 없습니다. -->
					</p>
					<ul class="comm_buttons">
						<li><button type="button" class="btn_move comm_btn cnc">취소</button></li>
						<li><button type="button" class="comm_btn sbm btn_pop2"
								data-layer="resetPw">확인</button></li>
					</ul>
				</form>
			</div>
		</section>
		<!-- } #1단계팝업 비밀번호 찾기 -->
		<button type="button" class="btn_close">
			<em class="snd_only">창 닫기</em>
		</button>
	</div>
	<!-- #2단계팝업 아이디찾기 결과 { -->
	<div id="findId" class="fstPop">
		<div class="id_wrap pop_wrap">
			<h3 class="pop_tit">비밀번호 변경</h3>
			<div class="info_box">
				<p>회원님의 정보와 일치하는 아이디는 다음과 같습니다.</p>
				<ul>
					<li>아이디 : user01@email.com</li>
					<li>가입일 : 2020-01-01</li>
				</ul>
			</div>
			<ul class="comm_buttons">
				<li><button type="button"
						class="btn_move comm_btn cfm btn_close btn_move">로그인 하기</button></li>
				<li><button type="button"
						class="comm_btn sbm btn_close btn_move" data-layer="log3">비밀번호
						찾기</button></li>
			</ul>
		</div>
	</div>
	<!-- } #2단계팝업 아이디찾기 결과 -->
	<!-- #2단계팝업 비밀번호 변경 { -->
	<div id="resetPw" class="fstPop">
		<div class="pw_wrap pop_wrap">
			<h3 class="pop_tit">비밀번호 변경</h3>
			<div class="info_box">
				<p>새로운 비밀번호를 설정해주세요.</p>
			</div>
			<form class="comm_form">
				<div class="ip_box">
					<input type="password" id="festaFpw3" name="" required="required">
					<label for="festaFpw3" class="comm_label">비밀번호<span>
							8~13자 이내, 영문(대소문자)+숫자 조합</span></label>
					<p class="f_message">
						<!-- 비밀번호 유효성 검사 -->
					</p>
				</div>
				<div class="ip_box">
					<input type="password" id="festaFpw4" name="" required="required">
					<label for="festaFpw4" class="comm_label">비밀번호 확인</label>
					<p class="f_message">
						<!-- 비밀번호 확인 검사 -->
					</p>
				</div>
				<p class="f_message rst">
					<!-- 일치하는 회원정보가 없습니다. -->
				</p>
				<ul class="comm_buttons">
					<li><button type="button" class="comm_btn sbm btn_pop2"
							data-layer="ok">확인</button></li>
				</ul>
			</form>
		</div>
	</div>
	<!-- #2단계팝업 비밀번호 변경 { -->
	<!-- #3단계팝업 처리완료 { -->
	<div id="ok" class="fstPop">
		<div class="confirm_wrap pop_wrap">
			<p class="pop_tit">처리가 완료되었습니다.</p>
			<ul class="comm_buttons">
				<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
			</ul>
		</div>
	</div>
	<!-- } #3단계팝업 처리완료 -->
	<script type="text/javascript">
		loginMove();
		btnPop('btn_pop2');
	</script>
</body>
</html>