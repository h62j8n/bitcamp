<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
<c:url value="/resources/upload" var="upload"></c:url>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta property="og:image" content="${root }resources/images/ico/logo.png">
	<script type="text/javascript" src="${root }resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${root }resources/js/util.js"></script>
	<script type="text/javascript" src="${root }resources/js/site.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" href="${root }resources/css/site.css">
	<link rel="shortcut icon" href="${root }resources/favicon.ico">
	<title>FESTA</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="scrX">
			<div class="container">
				<h1>
					<a href="${root }"><em class="snd_only">FESTA</em></a>
				</h1>
				<form class="search_box">
					<input type="text" placeholder="캠핑장 또는 그룹을 검색해보세요!">
					<button type="button" id="search">
						<img src="${root }resources/images/ico/btn_search.png" alt="검색">
					</button>
				</form>
				<ul id="gnb">
					<li><a href="${root}camp/?caaddrsel=">캠핑정보</a></li>
					<li><a href="${root}hot/">인기피드</a></li>
					<li><a href="${root}news/">뉴스피드</a></li>
					<c:if test="${login eq null }">
						<%
							out.println("<script>alert('로그인 후 이용이 가능합니다.')</script>");
						%>
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
											<li><a
												href="${root }group/?grnum=${joinGroup.grnum}&pronum=${login.pronum}">
													<span><img src="${upload }/${joinGroup.group.grphoto}"
														alt="${joinGroup.group.grname } 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
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
														src="${upload }/${joinGroup.group.grphoto}" alt="${joinGroup.group.grname } 그룹 썸네일"></span>
													<b>${joinGroup.group.grname }</b>
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
											<li><a href="${root }camp?canum=${bookMark.camp.canum}">
													<span><img src="${upload }/${image}"
														alt="${bookMark.camp.caname } 캠핑장 썸네일"></span> <b>${bookMark.camp.caname }</b>
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
	<!-- #캠핑정보 (리스트) -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="search_wrap">
		<!-- 컨텐츠영역 시작 { -->
		<section class="title_area container">
			<h2 class="comm_tit"><b>경기도</b>(으)로 검색한 결과입니다.</h2>
		</section>
		<section class="camp_area">
			<div class="container">
				<h3 class="sub_tit">캠핑장</h3>
				<div class="camp_slide">
					<div>
						<ul class="camp_list swiper-wrapper">
							<li class="swiper-slide">
								<a class="cp_thumb" href="../camp/detail.html">
									<img src="http://placehold.it/320x180" alt="몽산포 패밀리데이 캠핑장 썸네일">
									<b class="cp_liked">0</b>
								</a>
								<a class="cp_text" href="../camp/detail.html">
									<b class="cp_name">몽산포 패밀리데이 캠핑장</b>
									<span>
										<b class="cp_loc">경기도</b>
										#낭만캠핑 #바닷가 #가족여행
									</span>
								</a>
							</li>
						</ul>
					</div>
					<button type="button" class="swiper-prev"><em class="snd_only">이전</em></button>
					<button type="button" class="swiper-next"><em class="snd_only">다음</em></button>
				</div>
			</div>
		</section>
		<section class="group_area">
			<div class="container">
				<h3 class="sub_tit">그룹</h3>
				<ul class="group_list">
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="입돌아간다 그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>입돌아간다</strong>
							<span>안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다.</span>
							<b>경기도</b>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
							<b>경기도</b>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
							<b>경기도</b>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
							<b>경기도</b>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
							<b>경기도</b>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
							<b>경기도</b>
						</a>
					</li>
				</ul>
				<div class="fstPage">
					<ul>
						<li><a class="pg_start off" href=""><em class="snd_only">맨 앞으로</em></a></li>
						<li><a class="pg_prev off" href=""><em class="snd_only">이전 페이지</em></a></li>
						<li><b>1</b></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">4</a></li>
						<li><a href="">5</a></li>
						<li><a class="pg_next" href=""><em class="snd_only">다음 페이지</em></a></li>
						<li><a class="pg_end" href=""><em class="snd_only">맨 끝으로</em></a></li>
					</ul>
				</div>
			</div>
		</section>
		<section class="feed_area">
			<div class="container">
				<h3 class="sub_tit">피드</b></h3>
				<ul class="feed_list">
					<li>
						<a class="text box btn_pop" href="common/feed">
							<span class="fd_hashtag">경기도</span>
							<span class="fd_content">내용을 입력해주세요. 내용을 입력해주세요. 내용을 입력해주세요. 내용을 입력해주세요. 내용을 입력해주세요. 내용을 입력해주세요. 내용을 입력해주세요.  내용을</span>
						</a>
						<a class="thumb box btn_pop" href="common/feed">
							<span class="fd_thumb"><img src="http://placehold.it/100x100" alt="피드 썸네일"></span>
						</a>
						<p class="info box btn_pop">
							<a class="pf_picture" href="">
								<img src="http://placehold.it/30x30" alt="피드 썸네일">
							</a>
							<a class="fd_name" href="">조혜진</a>
							<a class="fd_group" href="">입돌아간다</a>
							<span class="fd_liked">000</span>
							<span class="fd_comment">99</span>
							<span class="fd_date">2020년 01월 01일 12시 59분</span>
						</p>
					</li>
					<li>
						<a class="text box btn_pop" href="common/feed">
							<span class="fd_hashtag">경기도</span>
							<span class="fd_content">내용을 입력해주세요.</span>
						</a>
						<p class="info box btn_pop">
							<a class="pf_picture" href="">
								<img src="http://placehold.it/30x30" alt="피드 썸네일">
							</a>
							<a class="fd_name" href="">조혜진</a>
							<span class="fd_liked">000</span>
							<span class="fd_comment">99</span>
							<span class="fd_date">2020년 01월 01일 12시 59분</span>
						</p>
					</li>
				</ul>
			</div>
		</section>
		<!-- } 컨텐츠영역 끝 -->
	</div>
	<!-- } 서브페이지 -->
	<div id="footer">
		<div class="container">
			<div class="img_box">
				<img src="${root }resources/images/ico/logo_w.png" alt="FESTA">
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
	feedType('feed_list li');
</script>
</body>
</html>