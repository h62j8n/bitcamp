<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta property="og:image" content="${root}resources/images/ico/logo.png">
	<script type="text/javascript" src="${root}resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${root}resources/js/util.js"></script>
	<script type="text/javascript" src="${root}resources/js/site.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" href="${root}resources/css/site.css">
	<link rel="shortcut icon" href="${root}resources/favicon.ico">
	<title>FESTA</title>
	<script type="text/javascript">
	$(function(){
		var container = $('.result_area .camp_list'),
		li = container.find('li'),
		btn = $('.btn_view_more');
		li.each(function(e) {
			if (e > 5) {
				$(this).hide();
			}
		});
		if (li.length < 1) {
			var empty = '<li class="fstEmpty">등록된 캠핑장이 없습니다.</li>';
			container.append(empty);
			btn.hide();
		}
		var hideOut = container.find('li:hidden').length;
		if (hideOut < 6) {
			btn.hide();
		}
		
		btn.on('click', function() {
			var start = container.find('li:visible').length;
			var end = container.find('li:hidden').length - 6;
			if (end < 1) {
				btn.hide();
			}
			for (var i=0; i<6; i++) {
				li.eq(start).show();
				start++;
			}
		});
		
		var top = $('.result_area').offset().top - 100;
		<c:if test="${!empty param.caaddrsel}">
		$('html, body').animate({scrollTop: top}, 0);
		</c:if>
	});
	</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="scrX">
			<div class="container">
				<h1>
					<a href="${root}"><em class="snd_only">FESTA</em></a>
				</h1>
				<form class="search_box" action="${root }search">
					<input type="text" name="keyword" placeholder="캠핑장 또는 그룹을 검색해보세요!">
					<button type="submit">
						<img src="${root }resources/images/ico/btn_search.png" alt="검색">
					</button>
				</form>
				<ul id="gnb">
					<li><a href="${root}camp/?caaddrsel=">캠핑정보</a></li>
					<li><a href="${root}hot/">인기피드</a></li>
					<li><a href="${root}news/?pronum=${login.pronum}">뉴스피드</a></li>
					<c:if test="${login eq null }">
					<li><a href="${root}member/login" class="btn_pop">로그인</a></li>
					</c:if>
					<c:if test="${login ne null }">
					<li><a href="${root}user/">마이페이지</a></li>
					</c:if>
				</ul>
				<c:if test="${login ne null }">
				<div id="userMenu" class="fstLyr">
					<button class="btn_menu">
						<em class="snd_only">나의 메뉴 더보기</em>
					</button>
					<dl class="menu_box" tabindex="0">
						<dt>
							<b>${login.proname }님 환영합니다.</b>
						</dt>
						<dd>
							<span class="btn_mylist">나의 그룹</span>
							<div class="my_list">
								<ul>
								<c:forEach items="${joinGroup }" var="joinGroup">
									<li><a href="${root }group/?grnum=${joinGroup.grnum}&pronum=${login.pronum}"> <span><img
												src="http://placehold.it/45x45" alt="입돌아간다 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
									</a></li>
								</c:forEach>
								</ul>
							</div>
						</dd>
						<dd>
							<span class="btn_mylist">나의 채팅</span>
							<div class="my_list">
								<ul>
								<c:forEach items="${joinGroup }" var="joinGroup">
									<li><a href=""> <span><img
												src="http://placehold.it/45x45" alt="입돌아간다 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
									</a></li>
								</c:forEach>
								</ul>
							</div>
						</dd>
						<dd>
							<span class="btn_mylist">나의 캠핑장</span>
							<div class="my_list">
								<ul>
								<c:forEach items="${bookMark }" var="bookMark">
									<li><a href="${root }camp?canum=${bookMark.camp.canum}"> <span><img
												src="http://placehold.it/45x45" alt="캠핑장 썸네일"></span> <b>${bookMark.camp.caname }</b>
									</a></li>
								</c:forEach>
								</ul>
							</div>
						</dd>
						<dd class="btn_logout">
							<form>
								<a href="${root}member/logout" class="btn_pop">로그아웃</a>
							</form>
						</dd>
					</dl>
				</div>
				</c:if>
				<button type="button" id="btnTop">
					<em class="snd_only">맨 위로</em>
				</button>
			</div>
		</div>
	</div>
	<!-- #캠핑정보 (메인) -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="camp_wrap list">
		<h2 class="snd_only">캠핑정보</h2>
		<!-- 컨텐츠영역 시작 { -->
		<section class="new_area">
			<div class="container">
				<h3 class="comm_tit">새로 등록된 <b>캠핑장</b></h3>
				<div class="camp_slide">
					<div>
						<ul class="camp_list swiper-wrapper">
							<c:forEach items="${newCampList}" var="newCamp">
							<li class="swiper-slide">
								<a class="cp_thumb" href="${root}camp/detail?canum=${newCamp.canum}&caaddrsel=${newCamp.caaddrsel}">
									<img src="http://placehold.it/320x180" alt="${newCamp.caname}">
								</a>
								<a class="cp_text" href="${root}camp/detail?canum=${newCamp.canum}&caaddrsel=${newCamp.caaddrsel}">
									<b class="cp_name">${newCamp.caname}</b>
									<span>
										<b class="cp_loc">${newCamp.caaddrsel}</b>
										<c:if test="${!empty newCamp.httitle1}">#${newCamp.httitle1}</c:if>
										<c:if test="${!empty newCamp.httitle2}">#${newCamp.httitle2}</c:if>
										<c:if test="${!empty newCamp.httitle3}">#${newCamp.httitle3}</c:if>
									</span>
								</a>
							</li>
							</c:forEach>
						</ul>
					</div>
					<button type="button" class="swiper-prev"><em class="snd_only">이전</em></button>
					<button type="button" class="swiper-next"><em class="snd_only">다음</em></button>
				</div>
			</div>
		</section>
		<section class="tab_area">
			<div class="container">
				<h3 class="comm_tit">어떤 <span>캠</span><span>핑</span><span>장</span>을 찾고 있나요?</h3>
				<ul class="tab_list">
					<li><a href="?caaddrsel="<c:if test="${empty param.caaddrsel}"> class="on"</c:if>>전체</a></li>
					<li><a href="?caaddrsel=서울"<c:if test="${param.caaddrsel eq '서울'}"> class="on"</c:if>>서울</a></li>
					<li><a href="?caaddrsel=경기도"<c:if test="${param.caaddrsel eq '경기도'}"> class="on"</c:if>>경기도</a></li>
					<li><a href="?caaddrsel=강원도"<c:if test="${param.caaddrsel eq '강원도'}"> class="on"</c:if>>강원도</a></li>
					<li><a href="?caaddrsel=충청도"<c:if test="${param.caaddrsel eq '충청도'}"> class="on"</c:if>>충청도</a></li>
					<li><a href="?caaddrsel=전라도"<c:if test="${param.caaddrsel eq '전라도'}"> class="on"</c:if>>전라도</a></li>
					<li><a href="?caaddrsel=경상도"<c:if test="${param.caaddrsel eq '경상도'}"> class="on"</c:if>>경상도</a></li>
					<li><a href="?caaddrsel=제주도"<c:if test="${param.caaddrsel eq '제주도'}"> class="on"</c:if>>제주도</a></li>
					<li><a href="?caaddrsel=인천"<c:if test="${param.caaddrsel eq '인천'}"> class="on"</c:if>>인천</a></li>
					<li><a href="?caaddrsel=세종"<c:if test="${param.caaddrsel eq '세종'}"> class="on"</c:if>>세종</a></li>
					<li><a href="?caaddrsel=대구"<c:if test="${param.caaddrsel eq '대구'}"> class="on"</c:if>>대구</a></li>
					<li><a href="?caaddrsel=울산"<c:if test="${param.caaddrsel eq '울산'}"> class="on"</c:if>>울산</a></li>
					<li><a href="?caaddrsel=광주"<c:if test="${param.caaddrsel eq '광주'}"> class="on"</c:if>>광주</a></li>
					<li><a href="?caaddrsel=대전"<c:if test="${param.caaddrsel eq '대전'}"> class="on"</c:if>>대전</a></li>
				</ul>
			</div>
		</section>
		<section class="result_area">
			<div class="container">
				<h3 class="comm_tit">
					<c:choose>
						<c:when test="${empty param.caaddrsel}">페스타만의 </c:when>
						<c:otherwise>${param.caaddrsel}의 </c:otherwise>
					</c:choose>
					<b>검증된 캠핑장</b>
				</h3>
				<ul class="camp_list">
					<c:forEach items="${campList}" var="camp">
					<li>
						<a class="cp_thumb" href="${root}camp/detail?canum=${camp.canum}&caaddrsel=${camp.caaddrsel}">
							<img src="http://placehold.it/320x180" alt="${camp.caname}">
							<b class="cp_liked">${camp.cagood}</b>
						</a>
						<a class="cp_text" href="${root}camp/detail?canum=${camp.canum}&caaddrsel=${camp.caaddrsel}">
							<b class="cp_name">${camp.caname}</b>
							<span>
								<b class="cp_loc">${camp.caaddrsel}</b>
								<c:if test="${!empty camp.httitle1}">#${camp.httitle1}</c:if>
								<c:if test="${!empty camp.httitle2}">#${camp.httitle2}</c:if>
								<c:if test="${!empty camp.httitle3}">#${camp.httitle3}</c:if>
							</span>
						</a>
					</li>
					</c:forEach>
				</ul>
				<button class="comm_btn btn_view_more">더 보기</button>
			</div>
		</section>
		<!-- } 컨텐츠영역 끝 -->
	</div>
	<!-- } 서브페이지 -->
	<div id="footer">
		<div class="container">
			<div class="img_box">
				<img src="${root}resources/images/ico/logo_w.png" alt="FESTA">
			</div>
			<div class="text_box">
				<p>
					<span>경기도 성남시 분당구 느티로 2, AK와이즈플레이스</span>
					<span>김채찍과노예들</span>
					<span>사업자등록번호 : 123-45-67890</span>
				</p>
				<p>
					<span>통신판매신고번호 : 제 2020-서울강남-0000</span>
					<span>대표번호 : 010-3332-8616</span>
					<span>담당자 : 김덕수</span>
					<span>문의 : 010-3332-8616</span>
				</p>
				<p>&copy; DEOKSOORR. All RIGHTS RESERVED.</p>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	campSlider();
</script>
</body>
</html>