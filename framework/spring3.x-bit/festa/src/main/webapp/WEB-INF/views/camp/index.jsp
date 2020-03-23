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
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="scrX">
			<div class="container">
				<h1>
					<a href="${root}"><em class="snd_only">FESTA</em></a>
				</h1>
				<form class="search_box">
					<input type="text" placeholder="캠핑장 또는 그룹을 검색해보세요!">
					<button type="submit"><img src="${root}resources/images/ico/btn_search.png" alt="검색"></button>
				</form>
				<ul id="gnb">
					<li><a href="${root}camp/">캠핑정보</a></li>
					<li><a href="${root}hot/">인기피드</a></li>
					<li><a href="${root}news/">뉴스피드</a></li>
					<li><a href="${root}member/login" class="btn_pop">로그인</a></li>
				</ul>
				<button type="button" id="btnTop"><em class="snd_only">맨 위로</em></button>
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
							<li class="swiper-slide">
								<a class="cp_thumb" href="${root}camp/detail/">
									<img src="http://placehold.it/320x180" alt="몽산포 패밀리데이 캠핑장 썸네일">
								</a>
								<a class="cp_text" href="${root}camp/detail/">
									<b class="cp_name">몽산포 패밀리데이 캠핑장</b>
									<span>
										<b class="cp_loc">경기도</b>
										#낭만캠핑 #바닷가 #가족여행
									</span>
								</a>
							</li>
							<li class="swiper-slide">
								<a class="cp_thumb" href="">
									<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
								</a>
								<a class="cp_text" href="">
									<b class="cp_name">캠핑장명</b>
									<span>
										<b class="cp_loc">지역</b>
										#해시태그 #해시태그 #해시태그
									</span>
								</a>
							</li>
							<li class="swiper-slide">
								<a class="cp_thumb" href="">
									<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
								</a>
								<a class="cp_text" href="">
									<b class="cp_name">캠핑장명</b>
									<span>
										<b class="cp_loc">지역</b>
										#해시태그 #해시태그 #해시태그
									</span>
								</a>
							</li>
							<li class="swiper-slide">
								<a class="cp_thumb" href="">
									<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
								</a>
								<a class="cp_text" href="">
									<b class="cp_name">캠핑장명</b>
									<span>
										<b class="cp_loc">지역</b>
										#해시태그 #해시태그 #해시태그
									</span>
								</a>
							</li>
							<li class="swiper-slide">
								<a class="cp_thumb" href="">
									<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
								</a>
								<a class="cp_text" href="">
									<b class="cp_name">캠핑장명</b>
									<span>
										<b class="cp_loc">지역</b>
										#해시태그 #해시태그 #해시태그
									</span>
								</a>
							</li>
							<li class="swiper-slide">
								<a class="cp_thumb" href="">
									<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
								</a>
								<a class="cp_text" href="">
									<b class="cp_name">캠핑장명</b>
									<span>
										<b class="cp_loc">지역</b>
										#해시태그 #해시태그 #해시태그
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
		<section class="tab_area">
			<div class="container">
				<h3 class="comm_tit">어떤 <span>캠</span><span>핑</span><span>장</span>을 찾고 있나요?</h3>
				<ul class="tab_list">
					<li><a href="" class="on">전체</a></li>
					<li><a href="">서울</a></li>
					<li><a href="">경기도</a></li>
					<li><a href="">강원도</a></li>
					<li><a href="">충청도</a></li>
					<li><a href="">전라도</a></li>
					<li><a href="">경상도</a></li>
					<li><a href="">제주도</a></li>
					<li><a href="">인천</a></li>
					<li><a href="">세종</a></li>
					<li><a href="">대구</a></li>
					<li><a href="">울산</a></li>
					<li><a href="">광주</a></li>
					<li><a href="">대전</a></li>
				</ul>
			</div>
		</section>
		<section class="result_area">
			<div class="container">
				<h3 class="comm_tit">페스타만의 <b>검증된 캠핑장</b></h3>
				<ul class="camp_list">
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="몽산포 패밀리데이 캠핑장 썸네일">
							<b class="cp_liked">99</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">몽산포 패밀리데이 캠핑장</b>
							<span>
								<b class="cp_loc">경기도</b>
								#낭만캠핑 #바닷가 #가족여행
							</span>
						</a>
					</li>
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
							<b class="cp_liked">0</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">캠핑장명</b>
							<span>
								<b class="cp_loc">지역</b>
								#해시태그 #해시태그 #해시태그
							</span>
						</a>
					</li>
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
							<b class="cp_liked">0</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">캠핑장명</b>
							<span>
								<b class="cp_loc">지역</b>
								#해시태그 #해시태그 #해시태그
							</span>
						</a>
					</li>
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
							<b class="cp_liked">0</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">캠핑장명</b>
							<span>
								<b class="cp_loc">지역</b>
								#해시태그 #해시태그 #해시태그
							</span>
						</a>
					</li>
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
							<b class="cp_liked">0</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">캠핑장명</b>
							<span>
								<b class="cp_loc">지역</b>
								#해시태그 #해시태그 #해시태그
							</span>
						</a>
					</li>
					<li>
						<a class="cp_thumb" href="">
							<img src="http://placehold.it/320x180" alt="캠핑장 썸네일">
							<b class="cp_liked">0</b>
						</a>
						<a class="cp_text" href="">
							<b class="cp_name">캠핑장명</b>
							<span>
								<b class="cp_loc">지역</b>
								#해시태그 #해시태그 #해시태그
							</span>
						</a>
					</li>
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