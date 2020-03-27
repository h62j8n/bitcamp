<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
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
						<button type="submit">
							<img src="${root }resources/images/ico/btn_search.png" alt="검색">
						</button>
					</form>
					<ul id="gnb">
						<li><a href="${root}camp">캠핑정보</a></li>
						<li><a href="${root}hot">인기피드</a></li>
						<li><a href="${root}news">뉴스피드</a></li>
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
														<span><img src="http://placehold.it/45x45"
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
															src="http://placehold.it/45x45" alt="${joinGroup.group.grname } 그룹 썸네일"></span>
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
														<span><img src="http://placehold.it/45x45"
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
		<!-- #그룹 관리 -->
		<!-- 서브페이지 시작 { -->
		<div id="container" class="setting_wrap">
			<!-- 프로필영역 시작 { -->
			<section class="profile_area">
				<div class="container">
					<div class="info_box">
						<dl>
							<dt class="pf_tit">
								<a class="pf_name"
									href="${root }group/?grnum=${detail.grnum}&pronum=${detail.pronum}">
									<b>${detail.grname }</b>
								</a>
								<c:if test="${detail.grventure eq 2 }">
									<span class="gp_official"></span>
								</c:if>
								<c:if test="${login.pronum eq detail.pronum }">
									<a class="pf_opt go_settings"
										href="${root }group/profile/?grnum=${detail.grnum}"> <em
										class="snd_only">설정</em>
									</a>
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
								<c:if test="${login.pronum ne detail.pronum }">
									<a class="btn_pop btn_out" href="${root }group/out">탈퇴</a>
								</c:if>
							</dd>
							<dd class="pf_picture">
								<img src="http://placehold.it/120x120" alt="${detail.grname } 그룹 썸네일">
							</dd>
						</dl>
					</div>
					<p class="social_btns">
						<button type="button" class="btn_chat"
							onclick="window.open('${root}group/chat','Festa chat','width=721,height=521,location=no,status=no,scrollbars=no');">그룹채팅</button>
					</p>
				</div>
			</section>
			<!-- } 프로필영역 끝 -->
			<div class="container">
				<!-- 좌측 사이드메뉴 시작 { -->
				<section class="side_area">
					<ul class="lnb_list">
						<li><a href="${root }group/profile?grnum=${detail.grnum}">그룹 관리</a></li>
						<li><a href="${root }group/user?grnum=${detail.grnum}">그룹원 관리</a></li>
						<li><a href="${root }group/req?grnum=${detail.grnum}" class="act">가입신청 조회</a></li>
					</ul>
				</section>
				<!-- } 좌측 사이드메뉴 시작 -->
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<h2 class="set_tit">가입신청 조회</h2>
				<form class="set_form">
					<table class="gp req_table two">
						<caption class="snd_only">가입신청 목록</caption>
						<thead>
							<tr>
								<th class="w60">No</th>
								<th>이름 (ID)</th>
								<th class="w120">생년월일</th>
								<th class="w60">성별</th>
								<th class="w120">관심지역</th>
							</tr>
							<tr>
								<th class="tb_chk">
									<input type="checkbox" class="comm_chk" name="allChecked" id="festaTbl0">
									<label for="festaTbl0"><em class="snd_only">전체선택</em></label>
								</th>
								<th class="tb_content" colspan="4">가입 동기</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${pageSearch.totalCount ne 0 }">
									<c:set var="i" value="5"/>
									<c:forEach items="${request }" var="request">
										<tr>
											<td>${request.uwrn}</td>
											<td>
												<p>
													<a href="" target="_blank">
														${request.profile.proname } (${request.profile.proid })
													</a>
												</p>
											</td>
											<td>${request.profile.proidnum }</td>
											<td>${request.profile.projender }</td>
											<td>${request.profile.proaddr }</td>
										</tr>
										<tr>
											<td class="tb_chk">
												<input type="checkbox" class="comm_chk" name="" id="festaTbl5">
												<label for="festaTbl5"><em class="snd_only">선택</em></label>
											</td>
											<td class="tb_content" colspan="4">
												${request.profile.prointro }
											</td>
										</tr>
									<c:set var="i" value="${i-1 }"/>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5" class="fstEmpty">가입 신청 건이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</form>
				<div class="table_options">
					<ul class="comm_buttons_s">
						<li><button type="submit" class="comm_btn cnc">승인</button></li>
						<li><button type="submit" class="comm_btn">거절</button></li>
					</ul>
					<ul class="comm_buttons_s">
						<li><button type="submit" class="comm_btn cnc">전체 승인</button></li>
						<li><button type="submit" class="comm_btn">전체 거절</button></li>
					</ul>
				</div>
				<div class="fstPage">
					<ul>
						<c:if test="${pageSearch.totalCount ne 0 }">
							<c:choose>
								<c:when test="${pageSearch.page2 eq 1 }">
									<li><a class="pg_start off"><em class="snd_only">맨 앞으로</em></a></li>
									<li><a class="pg_prev off"><em class="snd_only">이전 페이지</em></a></li>
								</c:when>
								<c:otherwise>
									<c:if test="${pageSearch.beginPage eq 1 }">
										<li><a class="pg_start" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.beginPage}"><em class="snd_only">맨 앞으로</em></a></li>
									</c:if>
									<c:if test="${pageSearch.beginPage ne 1 }">
										<li><a class="pg_start" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.beginPage-1}"><em class="snd_only">맨 앞으로</em></a></li>
									</c:if>
									<li><a class="pg_prev" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.page2-1}"><em class="snd_only">이전 페이지</em></a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${pageSearch.beginPage }" varStatus="status"  end="${pageSearch.endPage }">
								<c:choose>
									<c:when test="${pageSearch.page2 == status.index}">
										<li><b>${status.index }</b></li>
									</c:when>
									<c:otherwise>
										<li><a href="${root }group/req?grnum=${detail.grnum }&page2=${status.index}">${status.index }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${pageSearch.next eq true }">
									<li><a class="pg_next" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.page2+1}"><em class="snd_only">다음 페이지</em></a></li>
									<c:if test="${pageSearch.totalPage eq pageSearch.endPage }">
										<li><a class="pg_end" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.endPage}"><em class="snd_only">맨 끝으로</em></a></li>
									</c:if>
									<c:if test="${pageSearch.totalPage ne pageSearch.endPage }">
										<li><a class="pg_end" href="${root }group/req?grnum=${detail.grnum }&page2=${pageSearch.endPage+1}"><em class="snd_only">맨 끝으로</em></a></li>
									</c:if>
								</c:when>
								<c:otherwise>
									<li><a class="pg_next off"><em class="snd_only">다음 페이지</em></a></li>
									<li><a class="pg_end off"><em class="snd_only">맨 끝으로</em></a></li>
								</c:otherwise>
							</c:choose>
						</c:if>
					</ul>
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

</body>
</html>