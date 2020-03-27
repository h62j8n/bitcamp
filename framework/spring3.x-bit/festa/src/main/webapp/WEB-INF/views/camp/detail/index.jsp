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
	<!-- #캠핑정보 (상세) -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="camp_wrap detail">
		<h2 class="snd_only">캠핑정보</h2>
		<!-- 컨텐츠영역 시작 { -->
		<section class="info_area">
			<div class="container">
				<div class="tit box">
					<div>
						<h3><span>${camp.caaddrsel}</span> ${camp.caname}</h3>
						<p class="cp_subtit">${camp.caintroone}</p>
						<ul class="cp_hashtag">
							<c:if test="${!empty camp.httitle1}"><li><a href="">${camp.httitle1}</a></li></c:if>
							<c:if test="${!empty camp.httitle2}"><li><a href="">${camp.httitle2}</a></li></c:if>
							<c:if test="${!empty camp.httitle3}"><li><a href="">${camp.httitle3}</a></li></c:if>
						</ul>
						<ul class="cp_options">
							<li>
								<b class="cp_liked">${camp.cagood}</b>
								<button class="btn_liked"><em class="snd_only">하트</em></button>
								<!-- 하트 누른 경우 {
								<button class="btn_liked act"><em class="snd_only">하트</em></button>
								} 하트 누른 경우 -->
							</li>
							<li><button class="btn_bookmark"><em class="snd_only">저장하기</em></button></li>
							<li><a href="${root}/detail/report" class="btn_pop btn_report"><em class="snd_only">신고하기</em></a></li>
							<li><a class="btn_back" href="${root}camp/?caaddrsel="><em class="snd_only">목록으로</em></a></li>
						</ul>
						<ul class="cp_date">
							<li>정보 등록일 ${camp.cadate}</li>
							<li>최근 수정일 ${camp.cadateup}</li>
						</ul>
					</div>
				</div>
				<div class="intro box">
					<h4 class="snd_only">캠핑장 사진</h4>
					<div class="thumb_slide">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<img src="http://placehold.it/720x380" alt="">
							</div>
							<div class="swiper-slide">
								<img src="http://placehold.it/720x380" alt="">
							</div>
							<div class="swiper-slide">
								<img src="http://placehold.it/720x380" alt="">
							</div>
						</div>
						<div class="swiper-pagination"></div>
					</div>
					<div class="text_box">
						<h4 class="sub_tit">캠핑장 소개</h4>
						<p class="btn_go"><a href="${root}group/?grnum=${ventureGroup.grnum}&pronum=${login.pronum}">그룹 바로가기</a></p>
						<div class="scrBar">
							<p>${camp.caintro}</p>
						</div>
					</div>
				</div>
				<div class="info box">
					<h4 class="sub_tit">캠핑장 시설 안내</h4>
					<ol class="info_list">
						<c:if test="${!empty camp.caguide1}"><li>${camp.caguide1}</li></c:if>
						<c:if test="${!empty camp.caguide2}"><li>${camp.caguide2}</li></c:if>
						<c:if test="${!empty camp.caguide3}"><li>${camp.caguide3}</li></c:if>
						<c:if test="${!empty camp.caguide4}"><li>${camp.caguide4}</li></c:if>
						<c:if test="${!empty camp.caguide5}"><li>${camp.caguide5}</li></c:if>
						<c:if test="${!empty camp.caguide6}"><li>${camp.caguide6}</li></c:if>
						<c:if test="${!empty camp.caguide7}"><li>${camp.caguide7}</li></c:if>
						<!-- # 시설 안내 없음 {
						<li class="fstEmpty">등록된 시설 안내 사항이 없습니다</li>
						} # 시설 안내 없음 -->
					</ol>
				</div>
			</div>
		</section>
		<section class="location_area">
			<div class="container">
				<h4 class="sub_tit">오시는 길</h4>
				<p id="mapAddress">${camp.caaddr}</p>
				<div id="map"></div>
			</div>
		</section><%-- ${camp.} --%>
		<section class="rate_area">
			<div class="container">
				<h4 class="sub_tit">
					<p>한줄평 <span>개</span></p>
					<p>평점 <span>${camp.caavg}</span></p>
				</h4>
				<ul class="rate_list">
					<li>
						<!-- # 프로필 이미지 없음 { -->
						<a class="pf_picture" href="">
							<img src="${root}resources/images/thumb/no_profile.png" alt="김덕수님의 프로필 썸네일">
						</a>
						<!-- } # 프로필 이미지 없음 -->
						<!-- 관리자-삭제버튼 {
						<p class="rt_option">
							<button type="button" class="btn_delete"><em class="snd_only">삭제하기</em></button>
						</p>
						} 관리자-삭제버튼 -->
						<p class="rt_user">
							<a class="rt_name" href="">
								<b>김덕수</b>
							</a>
							<span class="rt_star"><img src="${root}resources/images/ico/shp_star5.png" alt="별 5개"></span>
						</p>
						<p class="rt_cont">한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요. 한줄평을 작성해주세요.</p>
						<p class="rt_date">2020년 01월 01일 11:59:59</p>
					</li>
					<li>
						<a class="pf_picture" href="">
							<img src="http://placehold.it/80x80" alt="작성자님의 프로필 썸네일">
						</a>
						<p class="rt_user">
							<a class="rt_name" href="">
								<b>작성자명</b>
							</a>
							<span class="rt_star"><img src="${root}resources/images/ico/shp_star4.png" alt="별 4개"></span>
						</p>
						<p class="rt_cont">한줄평을 작성해주세요.</p>
						<p class="rt_date">2020년 01월 01일 11:59:59</p>
					</li>
					<li>
						<a class="pf_picture" href="">
							<img src="http://placehold.it/80x80" alt="작성자님의 프로필 썸네일">
						</a>
						<p class="rt_user">
							<a class="rt_name" href="">
								<b>작성자명</b>
							</a>
							<span class="rt_star"><img src="${root}resources/images/ico/shp_star3.png" alt="별 3개"></span>
						</p>
						<p class="rt_cont">한줄평을 작성해주세요.</p>
						<p class="rt_date">2020년 01월 01일 11:59:59</p>
					</li>
					<li>
						<a class="pf_picture" href="">
							<img src="http://placehold.it/80x80" alt="작성자님의 프로필 썸네일">
						</a>
						<p class="rt_user">
							<a class="rt_name" href="">
								<b>작성자명</b>
							</a>
							<span class="rt_star"><img src="${root}resources/images/ico/shp_star2.png" alt="별 2개"></span>
						</p>
						<p class="rt_cont">한줄평을 작성해주세요.</p>
						<p class="rt_date">2020년 01월 01일 11:59:59</p>
					</li>
					<li>
						<a class="pf_picture" href="">
							<img src="http://placehold.it/80x80" alt="작성자님의 프로필 썸네일">
						</a>
						<p class="rt_user">
							<a class="rt_name" href="">
								<b>작성자명</b>
							</a>
							<span class="rt_star"><img src="${root}resources/images/ico/shp_star1.png" alt="별 1개"></span>
						</p>
						<p class="rt_cont">한줄평을 작성해주세요.</p>
						<p class="rt_date">2020년 01월 01일 11:59:59</p>
					</li>
					<!-- # 한줄평 없음 {
					<li class="fstEmpty"><i class="xi-error-o"></i>등록된 한줄평이 없습니다</li>
					} -->
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
				<h4 class="snd_only">한줄평 작성</h4>
				<form class="rate_form">
					<div>
						<p class="rt_name">김덕수</p>
						<ul class="rt_rates">
							<li>
								<input type="radio" id="rtRate1" name="rtRate" value="1">
								<label for="rtRate1"><em class="snd_only">별 1개</em></label>
							<li>
								<input type="radio" id="rtRate2" name="rtRate" value="2">
								<label for="rtRate2"><em class="snd_only">별 2개</em></label>
							</li>
							<li>
								<input type="radio" id="rtRate3" name="rtRate" value="3">
								<label for="rtRate3"><em class="snd_only">별 3개</em></label>
							</li>
							<li>
								<input type="radio" id="rtRate4" name="rtRate" value="4">
								<label for="rtRate4"><em class="snd_only">별 4개</em></label>
							</li>
							<li>
								<input type="radio" id="rtRate5" name="rtRate" value="5" checked="checked">
								<label for="rtRate5"><em class="snd_only">별 5개</em></label>
							</li>
						</ul>
						<textarea class="rt_input" name="rt_input" placeholder="주제와 무관한 댓글, 허위 사실은 삭제될 수 있습니다."></textarea>
					</div>
					<button type="submit" class="rt_btn_send">등록</button>
					<p class="rt_caution"><span>캠핑장에 관련된 내용이 아니거나 허위사실 기재 시 운영원칙에 따라 삭제될 수 있습니다.</span></p>
				</form>
			</div>
		</section>
		<section class="others_area">
			<div class="container">
				<h3 class="comm_tit">${camp.caaddrsel}의 <b>또 다른 캠핑장</b></h3>
				<div class="camp_slide"> 	
					<div>
						<ul class="camp_list swiper-wrapper">
							<c:forEach items="${campList}" var="camp">
							<li class="swiper-slide">
								<a class="cp_thumb" href="${root}camp/detail?canum=${camp.canum}&caaddrsel=${camp.caaddrsel}">
									<img src="http://placehold.it/320x180" alt="${camp.caname}">
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
					</div>
					<button type="button" class="swiper-prev"><em class="snd_only">이전</em></button>
					<button type="button" class="swiper-next"><em class="snd_only">다음</em></button>
				</div>
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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1b67c433937cf5e372c63766fb1ccca&libraries=services"></script>
<script type="text/javascript">
	campDetail();
</script>
</body>
</html>