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
	<!-- #인기피드 -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="feed_wrap">
		<h2 class="snd_only">인기피드</h2>
		<div class="container">
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<!-- #텍스트+썸네일 피드 시작 { -->
				<c:forEach items="${feedList}" var="feedList">
				<div class="feed_viewer">
					<div class="tit box">
						<dl class="feed_inform">
							<dt>
								<a href="">
									<span class="pf_picture"><img src="http://placehold.it/55x55" alt="김덕수님의 프로필 썸네일"></span>
									<span class="fd_name">${feedList.mpauthor}</span>
								</a>
								<a href="">
									<span class="fd_group">입돌아간다</span>
								</a>
							</dt>
							<dd>
								<span class="fd_date">${feedList.mpdate}</span>
								<b class="fd_liked">${feedList.mpgood}</b>
							</dd>
						</dl>
						<ul class="feed_options">
							<li><button class="btn_liked act"><em class="snd_only">하트</em></button></li>
							<li><a href="${root}news/report" class="btn_pop btn_report"><em class="snd_only">신고하기</em></a></li>
							<li><a href="${root}news/maker" class="btn_pop btn_edit"><em class="snd_only">수정하기</em></a></li>
							<li><button class="btn_delete"><em class="snd_only">삭제하기</em></button></li>
						</ul>
					</div>
					<div class="text box">
						<div class="scrBar">
							<div class="feed_content">
								<ul class="fd_hashtag">
									<li><a href="">${feedList.httitle1}</a></li>
									<li><a href="">${feedList.httitle2}</a></li>
									<li><a href="">${feedList.httitle3}</a></li>
								</ul>
								<p class="fd_content">${feedList.mpcontent}</p>
							</div>
							<ul class="comment_list">
								<li>
									<!-- # 프로필 이미지 없음 { -->
									<a href="" class="pf_picture">
										<img src="${root}resources/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">
									</a>
									<!-- } # 프로필 이미지 없음 -->
									<p class="cmt_content">
										<a href="" class="cmt_name">김진혁</a>
										댓글을 입력해주세요.
										<span class="cmt_date">2020년 01월 01일 12시 59분</span>
										<button class="btn_delete"><em class="snd_only">삭제하기</em></button>
									</p>
								</li>
								<li>
									<a href="" class="pf_picture">
										<img src="http://placehold.it/30x30" alt="고재현님의 프로필 썸네일">
									</a>
									<p class="cmt_content">
										<a href="" class="cmt_name">고재현</a>
										댓글을 입력해주세요. 댓글을 입력해주세요. 댓글을 입력해주세요. 댓글을 입력해주세요. 댓글을 입력해주세요.
										<span class="cmt_date">2020년 01월 01일 12시 59분</span>
										<button class="btn_delete"><em class="snd_only">삭제하기</em></button>
									</p>
								</li>
							</ul>
							<button class="cmt_btn_more">3개의 댓글 더 보기</button>
						</div>
						<form class="message_form">
							<a class="pf_picture" href="">
								<img src="http://placehold.it/30x30" alt="나의 프로필 썸네일">
							</a>
							<p class="msg_input">
								<textarea id="" name="" placeholder="메세지를 입력해주세요"></textarea>
								<button type="submit" class="btn_send"><em class="snd_only">전송</em></button>
							</p>
						</form>
					</div>
					<!-- # 썸네일 영역 { -->
					<div class="img box">
						<div class="thumb_slide">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img src="http://placehold.it/290x290" alt="">
								</div>
								<div class="swiper-slide">
									<img src="http://placehold.it/290x290" alt="">
								</div>
								<div class="swiper-slide">
									<img src="http://placehold.it/290x290" alt="">
								</div>
							</div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
					<!--  } # 썸네일 영역 -->
				</div>
				<!-- } #텍스트+썸네일 피드 끝 -->
				</c:forEach>
			</section>
			<!-- } 컨텐츠영역 끝 -->
			<!-- 우측 사이드영역 시작 { -->
			<section class="side_area">
				<div class="rcmm_list">
					<h3><em class="snd_only">추천그룹 목록</em>나홀로 캠핑이 심심하신가요?</h3>
					<ul>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="입돌아간다 그룹 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">입돌아간다</b>
								<span class="rc_intro">안녕하세요 ㅇㅇㅇ입니다. 안녕하세요</span>
							</a>
						</li>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="그룹 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">그룹</b>
								<span class="rc_intro">그룹 소개글을 작성해주세요.</span>
							</a>
						</li>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="그룹 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">그룹</b>
								<span class="rc_intro">그룹 소개글을 작성해주세요.</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="rcmm_list">
					<h3><em class="snd_only">추천캠핑장 목록</em>이 캠핑장에도 가보셨나요?</h3>
					<ul>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="바다애캠핑장 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">바다애캠핑장</b>
								<span class="rc_hashtag">경기도</span>
							</a>
						</li>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="캠핑장 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">캠핑장</b>
								<span class="rc_hashtag">경기도</span>
							</a>
						</li>
						<li>
							<a class="rc_thumb" href="">
								<img src="http://placehold.it/55x55" alt="캠핑장 썸네일">
							</a>
							<a class="rc_text" href="">
								<b class="rc_name">캠핑장</b>
								<span class="rc_hashtag">경기도</span>
							</a>
						</li>
					</ul>
				</div>
			</section>
			<!-- } 우측 사이드영역 끝 -->
		</div>
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
	feedType('feed_viewer');
</script>
</body>
</html>