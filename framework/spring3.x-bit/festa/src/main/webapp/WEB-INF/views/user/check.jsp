<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/" var="root" />
<c:url value="/resources/upload" var="upload" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta property="og:image"
	content="${root }resources/images/ico/logo.png">
<script type="text/javascript"
	src="${root }resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${root }resources/js/util.js"></script>
<script type="text/javascript" src="${root }resources/js/site.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link type="text/css" rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link type="text/css" rel="stylesheet" href="${root}resources/css/site.css">
<link rel="stylesheet" href="${root }resources/css/site.css">
<link rel="shortcut icon" href="${root }resources/favicon.ico">
<title>FESTA</title>
<script type="text/javascript">
	$(document).ready(function(){
		var cookie = '${cookie.loginCookie.value}';
	      var login = '${login}';
	      
	      if(cookie!=''&&login==''&&loginValue==true){
	         openPop('loginCookie');
	      }
	      
	      $('#btnCookie').on('click',function(){
	         $.post('${root}member/loginCookie','id='+cookie,function(data){
	            if (data.prorn == '0') {
	               location.href = "${root}user/?pronum="+data.pronum;
	            } else if (data.prorn == '1') {
	               location.href = "${root}member/stop";
	            } else if (data.prorn == '2') {
	               location.href = "${root}member/kick";
	            } else if (data.prorn == '3') {
	               location.href = "${root}admin/";
	            } else if (data.prorn == '4') {
	               location.href = "${root}";
	            }
	         });
	      });
	});
</script>
</head>
<c:if test="${sessionScope.login eq null}">
   <c:redirect url="/empty"/>
</c:if>
<c:if test="${sessionScope.login ne null }">
   <c:if test="${sessionScope.login.proid eq 'admin@festa.com' }">
      <c:redirect url="/empty"/>
   </c:if>
</c:if>
<body>
	<div id="wrap">
		<div id="header">
			<div class="scrX">
				<div class="container">
					<h1>
						<a href="${root }"><em class="snd_only">FESTA</em></a>
					</h1>
					<form class="search_box">
						<input type="text" placeholder="캠핑장 또는 그룹을 검색해보세요!" required="required">
						<button type="submit">
							<img src="${root }resources/images/ico/btn_search.png" alt="검색">
						</button>
					</form>
					<ul id="gnb">
						<li><a href="${root}camp/">캠핑정보</a></li>
						<li><a href="${root}hot/">인기피드</a></li>
						<li><a href="${root}news/?pronum=${login.pronum}">뉴스피드</a></li>
						<c:if test="${login eq null }">
							<li><a href="${root}member/login" id="btn_pop" class="btn_pop">로그인</a></li>
						</c:if>
						<c:if test="${login ne null }">
							<li><a href="${root}user/index">마이페이지</a></li>
						</c:if>
					</ul>
					<c:if test="${login ne null }">
						<div id="userMenu" class="fstLyr">
							<button class="btn_menu">
								<em class="snd_only">나의 메뉴 더보기</em>
							</button>
							<dl class="menu_box" tabindex="0">
								<dt>
									<b>${login.proname }</b>
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
												<c:choose>
													<c:when test="${joinGroup.group.grphoto eq null }"> 
														<li>
															<a style="cursor: pointer" onclick="window.open('${root}group/chat?grnum=${joinGroup.grnum }','Festa chat','width=721,height=521,location=no,status=no,scrollbars=no');">
																<span><img src="${root}resources/images/thumb/no_profile.png" alt="${joinGroup.group.grname } 그룹 썸네일"></span>
																<b>${joinGroup.group.grname }</b>
															</a>
														</li>
													</c:when>
													<c:otherwise>
														<li>
															<a style="cursor: pointer" onclick="window.open('${root}group/chat?grnum=${joinGroup.grnum }','Festa chat','width=721,height=521,location=no,status=no,scrollbars=no');">
																<span><img src="${upload }/${joinGroup.group.grphoto}" alt="${joinGroup.group.grname } 그룹 썸네일"></span>
																<b>${joinGroup.group.grname }</b>
															</a>
														</li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</ul>
									</div>
								</dd>
								<dd>
									<span class="btn_mylist">나의 캠핑장</span>
									<div class="my_list">
										<ul>
											<c:forEach items="${bookMark}" var="bookMark">
												<li><a
													href="${root}camp/detail?canum=${bookMark.camp.canum}&caaddrsel=${bookMark.camp.caaddrsel}">
														<span> <c:set var="image"
																value="${fn:substringBefore(bookMark.camp.caphoto,',')}"></c:set>
															<c:if
																test="${!empty bookMark.camp.caphoto && empty image}">
																<img src="${upload}/${bookMark.camp.caphoto}"
																	alt="${bookMark.camp.caname}">
															</c:if> <c:if
																test="${!empty bookMark.camp.caphoto && !empty image}">
																<img src="${upload}/${image}"
																	alt="${bookMark.camp.caname}">
															</c:if> <c:if
																test="${empty bookMark.camp.caphoto && empty image}">
																<img src="${root}resources/images/thumb/no_profile.png"
																	alt="${bookMark.camp.caname}">
															</c:if>
													</span> <b>${bookMark.camp.caname}</b>
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
		<!-- #유저 관리 -->
		<!-- 서브페이지 시작 { -->
		<div id="container" class="setting_wrap">
			<!-- 프로필영역 시작 { -->
			<section class="profile_area">
				<div class="container">
					<div class="info_box">
						<dl>
							<dt class="pf_tit">
								<a class="pf_name" href="${root }user/?pronum=${profile.pronum}"><b>${profile.proname }</b></a>
								<!-- 마이페이지일 경우 톱니바퀴 버튼 {  -->
								<a class="pf_opt go_settings" href="${root }user/profile"><em
									class="snd_only">설정</em></a>
								<!-- } 마이페이지일 경우 톱니바퀴 버튼 -->
							</dt>
							<dd class="pf_intro">${profile.prointro }</dd>
							<dd class="pf_hashtag">
								<a href="">${profile.proaddr }</a>
							</dd>
							<dd class="pf_picture">
								<c:if test="${profile.prophoto ne '' }">
									<img src="${upload }/${profile.prophoto}"
										alt="${profile.proname }님의 프로필 썸네일">
								</c:if>
								<c:if test="${profile.prophoto eq '' }">
									<img src="${root }resources/upload/thumb/no_profile.png" alt="${profile.proname }님의 프로필 썸네일" >
								</c:if>
							</dd>
						</dl>
					</div>
					<div class="cnt_list">
						<ul>
							<li>피드<b>${myFeedCount }</b></li>
							<li>팔로워<a class="btn_pop" href="${root }user/follower">${myFollowerCount}</a></li>
							<li>팔로우<a class="btn_pop" href="${root }user/following">${myFollowingCount }</a></li>
						</ul>
					</div>
				</div>
			</section>
			<!-- } 프로필영역 끝 -->
			<div class="container">
				<!-- 좌측 사이드메뉴 시작 { -->
				<section class="side_area">
				<ul class="lnb_list">
					<li><a href="${root }user/profile" >프로필 관리</a></li>
					<li><a href="${root }user/check" class="act">계정 관리</a></li>
					<!-- 그룹장이 아닌 경우 { -->
					<c:if test="${groupCheck != 1 }">
					<li><a href="${root }user/group">그룹 생성</a></li>
					</c:if>
					<!-- 사업자가인 경우 -->
					<c:if test="${myVenture ne null }">
					<li><a href="${root }user/venture/">사업자 계정 관리</a></li>
					</c:if>
					<!-- 사업자가 아닌 경우{ -->
					<c:if test="${myVenture eq null}">
					<c:if test="${myVentureRequestCheck eq null }">
					<li><a href="${root}user/venture/add">사업자 계정 신청</a></li>
					</c:if>
					<c:if test="${myVentureRequestCheck ne null }">
					<li><a href="${root}user/venture/standby">사업자 계정 신청</a></li>
					</c:if>
					</c:if>
					<!-- 사업자이면서 캠핑장 있는 경우 -->
					<c:if test="${myVenture ne null }">
					<c:if test="${campCheck == 1 }">
					<li><a href="${root }user/camp/">캠핑장 관리</a></li>
					</c:if>
					</c:if>
					<!-- 사업자이지만 캠핑장이 없는 경우 -->
					<c:if test="${myVenture ne null }">
					<c:if test="${campCheck == 0 }">
					<li><a href="${root}user/camp/add">캠핑장 등록</a></li>
					</c:if>
					</c:if>
					<!-- 사업자계정 등록 전 { -->
				</ul>
			</section>
				<!-- } 좌측 사이드메뉴 시작 -->
				<!-- 컨텐츠영역 시작 { -->
				<section class="content_area">
					<h2 class="set_tit">계정 관리</h2>
					<div class="set_check">
						<h3>비밀번호 확인</h3>
						<p>
							회원님의 정보를 안전하게 보호하기 위해<br>비밀번호를 한번 더 입력해주세요.
						</p>
						<form action="${root }user/check" method="post" class="comm_form">
							<div class="ip_box">
								<input type="hidden" id="id" name="id" value="${profile.proid }" />
								<input type="password" id="pw" name="pw" required="required">
								<label for="check" class="comm_label">비밀번호 확인</label>
							</div>
							<button type="submit" id="btn_submit" name="btn_submit"
								class="comm_btn sbm">확인</button>
						</form>
					</div>
				</section>
				<!-- } 컨텐츠영역 끝 -->
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
						<span>경기도 성남시 분당구 느티로 2, AK와이즈플레이스</span> <span>김채찍과노예들</span> <span>사업자등록번호
							: 123-45-67890</span>
					</p>
					<p>
						<span>통신판매신고번호 : 제 2020-서울강남-0000</span> <span>대표번호 :
							010-3332-8616</span> <span>담당자 : 김덕수</span> <span>문의 :
							010-3332-8616</span>
					</p>
					<p>&copy; DEOKSOORR. All RIGHTS RESERVED.</p>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- #팝업 처리완료 { -->
<div id="loginCookie" class="fstPop">
   <div class="confirm_wrap pop_wrap">
      <p class="pop_tit">로그인을 유지 시키겠습니까?</p>
      <ul class="comm_buttons">
         <li><button type="button" class="btn_close comm_btn cnc">닫기</button></li>
         <li><button type="button" id="btnCookie" class="ok comm_btn cfm">로그인</button></li>
      </ul>
   </div>
</div>
</html>