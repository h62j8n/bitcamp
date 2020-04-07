<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${sessionScope.login ne null }">
	<c:if test="${sessionScope.login.proid eq 'admin@festa.com' }">
		<c:redirect url="/empty" />
	</c:if>
</c:if>
<c:url value="/" var="root" />
<c:url value="/resources/upload" var="upload"></c:url>
<!DOCTYPE html>
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
					<li><a href="${root}camp/">캠핑정보</a></li>
					<li><a href="${root}hot/">인기피드</a></li>
					<li><a href="${root}news/">뉴스피드</a></li>
					<c:if test="${login eq null }">
						<%
							out.println("<script>alert('로그인 후 이용이 가능합니다.')</script>");
						%>
						<li><a href="${root}member/login" class="btn_pop">로그인</a></li>
					</c:if>
					<c:if test="${login ne null }">
						<li><a href="${root}user/?pronum=${login.pronum}">마이페이지</a></li>
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
											<c:choose>
												<c:when test="${joinGroup.group.grphoto eq null }">
													<li><a
														href="${root }group/?grnum=${joinGroup.grnum}&pronum=${login.pronum}">
															<span><img src="${root }resources/upload/thumb/no_profile.png"
																alt="${joinGroup.group.grname } 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
													</a></li>
												</c:when>
												<c:otherwise>
													<li><a
														href="${root }group/?grnum=${joinGroup.grnum}&pronum=${login.pronum}">
															<span><img src="${upload }/${joinGroup.group.grphoto}"
																alt="${joinGroup.group.grname } 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
													</a></li>
												</c:otherwise>
											</c:choose>
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
									<c:forEach items="${bookMark}" var="bookMark">
										<li>
											<a href="${root}camp/detail?canum=${bookMark.camp.canum}&caaddrsel=${bookMark.camp.caaddrsel}">
												<span>
													<c:set var="image" value="${fn:substringBefore(bookMark.camp.caphoto,',')}"></c:set>
													<c:if test="${!empty bookMark.camp.caphoto && empty image}"><img src="${upload}/${bookMark.camp.caphoto}" alt="${bookMark.camp.caname}"></c:if>
													<c:if test="${!empty bookMark.camp.caphoto && !empty image}"><img src="${upload}/${image}" alt="${bookMark.camp.caname}"></c:if>
													<c:if test="${empty bookMark.camp.caphoto && empty image}"><img src="${root}resources/images/thumb/no_profile.png" alt="${bookMark.camp.caname}"></c:if>
												</span>
												<b>${bookMark.camp.caname}</b>
											</a>
										</li>
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
	<!-- #그룹 홈 (가입대기 회원) -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="home_wrap">
		<h2 class="snd_only">입돌아간다 그룹 홈</h2>
		<!-- 프로필영역 시작 { -->
		<section class="profile_area">
			<div class="container">
				<div class="info_box">
					<dl>
						<dt class="pf_tit">
							<a class="pf_name"
								href="">
								<b>${detail.grname }</b>
							</a>
							<c:if test="${detail.grventure eq 2 }">
								<span class="gp_official"></span>
							</c:if>
							<c:if test="${login.pronum ne detail.pronum }">
								<a href="${root }group/gp_report"
									class="pf_opt btn_pop btn_report"> <em class="snd_only">신고하기</em>
								</a>
							</c:if>
						</dt>
						<dd class="pf_intro">${detail.grintro }
						<dd class="pf_hashtag">
							<c:choose>
								<c:when
									test="${empty detail.httitle1 && empty detail.httitle2 && empty detail.httitle3}">
								</c:when>
								<c:when
									test="${empty detail.httitle1 && empty detail.httitle2}">
									<a href="">${detail.httitle3}</a>
								</c:when>
								<c:when test="${empty detail.httitle1}">
									<a href="">${detail.httitle2}</a>
									<a href="">${detail.httitle3}</a>
								</c:when>
								<c:otherwise>
									<a href="">${detail.httitle1}</a>
									<a href="">${detail.httitle2}</a>
									<a href="">${detail.httitle3}</a>
								</c:otherwise>
							</c:choose>
						</dd>
						<dd class="gp_list">
							<span>그룹장 : ${detail.profile.proname}</span> <a
								class="btn_pop btn_member"
								href="${root }group/member?grnum=${detail.grnum}">멤버 :
								${detail.grtotal }명</a> <span>개설일 : ${detail.grdate }</span>
						</dd>
						<c:choose>
								<c:when test="${detail.grphoto eq null }">
									<dd class="pf_picture">
										<img src="${root }resources/upload/thumb/no_profile.png" alt="${detail.grname } 그룹 썸네일">
									</dd>
								</c:when>
								<c:otherwise>
									<dd class="pf_picture">
										<img src="${upload }/${detail.grphoto }" alt="${detail.grname } 그룹 썸네일">
									</dd>
								</c:otherwise>
						</c:choose>
					</dl>
				</div>
			</div>
		</section>
		<!-- } 프로필영역 끝 -->
		<div class="container">
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<!-- #비공개 시작 {  -->
				<div class="readme_wrap">
					<div>
						<h3 class="set_tit">그룹 멤버에게만 공개된 페이지입니다.</h3>
						<dl>
							<dt>가입 승인을 대기 중입니다.</dt>
							<dd>그룹장이 가입신청에 대해 승인한 후 해당 그룹을 이용하실 수 있습니다.</dd>
						</dl>
						<p class="comm_buttons">
							<a class="comm_btn cfm" href="${root }">메인으로 돌아가기</a>
						</p>
					</div>
				</div>
				<!-- } #비공개 끝 -->
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
<!-- } #팝업 그룹 가입신청 -->
</body>
</html>