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
<script type="text/javascript" src="${root }resources/js/util.js"></script>
<script type="text/javascript" src="${root }resources/js/site.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="${root }resources/css/site.css">
<link rel="shortcut icon" href="${root }resources/favicon.ico">
<title>FESTA</title>
</head>
<body>
<c:if test="${sessionScope.login eq null}">
   <c:redirect url="/empty"/>
</c:if>
<c:if test="${sessionScope.login ne null }">
   <c:if test="${sessionScope.login.proid eq 'admin@festa.com' }">
      <c:redirect url="/empty"/>
   </c:if>
</c:if>
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
						<li><a href="${root}news/">뉴스피드</a></li>
						<c:if test="${login eq null }">
							<li><a href="${root}member/login" id="btn_pop"
								class="btn_pop">로그인</a></li>
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
																<span><img
																	src="${root }resources/upload/thumb/no_profile.png"
																	alt="${joinGroup.group.grname } 그룹 썸네일"></span> <b>${joinGroup.group.grname }</b>
														</a></li>
													</c:when>
													<c:otherwise>
														<li><a
															href="${root }group/?grnum=${joinGroup.grnum}&pronum=${login.pronum}">
																<span><img
																	src="${upload }/${joinGroup.group.grphoto}"
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
															src="http://placehold.it/45x45" alt="입돌아간다 그룹 썸네일"></span>
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
															alt="캠핑장 썸네일"></span> <b>${bookMark.camp.caname }</b>
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
								<a class="pf_name" href=""><b>${login.proname }</b></a>
								<!-- 마이페이지일 경우 톱니바퀴 버튼 {  -->
								<a class="pf_opt go_settings" href="${root }user/profile"><em
									class="snd_only">설정</em></a>
								<!-- } 마이페이지일 경우 톱니바퀴 버튼 -->
							</dt>
							<dd class="pf_intro">${profile.prointro }</dd>
							<dd class="pf_hashtag">
								<a href="">${sessionScope.profile.proaddr }</a>
							</dd>
							<dd class="pf_picture">
								<img src="http://placehold.it/120x120"
									alt="${login.proname }님의 프로필 썸네일">
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
						<li><a href="${root }user/profile">프로필 관리</a></li>
						<li><a href="${root }user/check">계정 관리</a></li>
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
								<li><a href="${root }user/camp/" class="act">캠핑장 관리</a></li>
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
					<h2 class="set_tit">캠핑장 관리</h2>
					<form action="${root }user/camp/edit" method="post" class="set_form">
						<input type="hidden" id="canum" name="canum" value="${myCamp.canum }"/>
						<ul class="input_list">
							<li class="set_file1 box">
								<p>
									캠핑장<br>대표사진
								</p>
								<div>
									<p class="pf_picture">
										<img src="${root }resources/images/thumb/no_profile.png"
											alt="캠핑장 그룹의 프로필 썸네일">
									</p>
									<ul class="comm_buttons_s">
										<li><input type="file" id="caphoto" name="caphoto"
											accept="image/*"> <label for="festa3"
											class="comm_btn cfm">등록</label></li>
										<li>
											<button type="button" class="comm_btn btn_cancle">삭제</button>
										</li>
									</ul>
								</div>
							</li>
							<li class="box">
								<p>
									<label for="festa1">캠핑장 이름</label>
								</p>
								<div>
									<input type="text" class="rd_only" id="caname" name="caname"
										value="${myCamp.caname }" readonly="readonly">
								</div>
							</li>
							<li class="box">
								<p>
									<label for="festa2">대표자</label>
								</p>
								<div>
									<input type="text" class="rd_only" id="proname" name="proname"
										value="${myVenture.proname }" readonly="readonly">
								</div>
							</li>
						</ul>
						<ul class="input_list">
							<li class="box">
								<p>
									<label for="festa5">캠핑장 주소</label>
								</p>
								<div>
									<input type="text" class="rd_only" id="caaddr" name="caaddr"
										value="${myCamp.caaddr }" readonly="readonly">
								</div>
							</li>
							<li class="box">
								<div>
									<input type="text" class="rd_only" id="caaddrsuv"
										name="caaddrsuv" value="${myCamp.caaddrsuv }"
										readonly="readonly">
								</div>
							</li>
							<li class="box">
								<p>지역권</p>
								<div>
									<select class="comm_sel" id="caaddrsel" name="caaddrsel">
										<option value="서울">서울</option>
										<option value="경기도">경기도</option>
										<option value="강원도">강원도</option>
										<option value="충청도">충청도</option>
										<option value="전라도">전라도</option>
										<option value="경상도">경상도</option>
										<option value="제주도">제주도</option>
										<option value="인천">인천</option>
										<option value="세종">세종</option>
										<option value="대구">대구</option>
										<option value="울산">울산</option>
										<option value="광주">광주</option>
										<option value="대전">대전</option>
									</select>
									<p class="comm_sel_label">서울</p>
								</div>
							</li>
							<li class="box">
								<p>
									<label for="festa7">한줄 소개</label>
								</p>
								<div>
									<input type="text" id="caintroone" name="caintroone" value="${myCamp.caintroone }"
										placeholder="한줄 소개글을 입력해주세요">
								</div>
							</li>
							<li class="box">
								<p>
									<label for="festa8">메인 소개</label>
								</p>
								<div>
									<textarea id="caintro" name="caintro"
										placeholder="??자 이내로 작성해주세요">${myCamp.caintro }</textarea>
								</div>
							</li>
							<li class="set_tags box">
								<p>해시태그 등록</p>
								<div>
									<ul>
										<li><input type="text" id="httitle1" name="httitle1" value="${myCamp.httitle1 }"></li>
										<li><input type="text" id="httitle2" name="httitle2" value="${myCamp.httitle2 }"></li>
										<li><input type="text" id="httitle3" name="httitle3" value="${myCamp.httitle3 }"></li>
									</ul>
								</div>
							</li>
							<li class="box">
								<p>캠핑장 사진</p>
								<div class="file_thumbnail">
									<ul>
										<!-- <li>
										<input type="file" id="festaFl3" name="festaFiles" accept="video/*, image/*" multiple="multiple">
										<label for="festaFl3" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
										<img src="http://placehold.it/80x80" alt="">
										<button class="btn_cancle" type="button"><em class="snd_only">업로드 취소하기</em></button>
									</li> -->
										<li><input type="file" id="festaFl2" name="festaFiles"
											accept="video/*, image/*" multiple="multiple"> <label
											for="festaFl2" class="btn_file"><em class="snd_only">사진/동영상
													업로드하기</em></label></li>
									</ul>
									<p class="txt_explan">파일 크기 00MB 이하, 최대 5개까지 업로드 가능합니다.</p>
								</div>
							</li>
							<li class="set_inputs box">
								<p>시설 안내</p>
								<div>
									<!-- <button type="button" class="btn_hf" id="btnAddInput"
										data-field="caguide">
										<i class="xi-plus"></i><em class="snd_only">입력창 추가하기</em>
									</button> -->
									<c:choose>
										<c:when
											test="${myCamp.caguide1 eq '' and myCamp.caguide2 eq '' and myCamp.caguide3 eq '' and myCamp.caguide4 eq '' and myCamp.caguide5 eq '' and myCamp.caguide6 eq '' and myCamp.caguide7 eq '' }">
											<li class="fstEmpty">등록된 시설 안내 사항이 없습니다</li>
										</c:when>
										<c:otherwise>
											<ul><li><input type="text" id="caguide1" name="caguide1" value="${myCamp.caguide1 }"></li></ul>
											<ul><li><input type="text" id="caguide2" name="caguide2" value="${myCamp.caguide2 }"></li></ul>
											<ul><li><input type="text" id="caguide3" name="caguide3" value="${myCamp.caguide3 }"></li></ul>
											<ul><li><input type="text" id="caguide4" name="caguide4" value="${myCamp.caguide4 }"></li></ul>
											<ul><li><input type="text" id="caguide5" name="caguide5" value="${myCamp.caguide5 }"></li></ul>
											<ul><li><input type="text" id="caguide6" name="caguide6" value="${myCamp.caguide6 }"></li></ul>
											<ul><li><input type="text" id="caguide7" name="caguide7" value="${myCamp.caguide7 }"></li></ul>
										</c:otherwise>
									</c:choose>
									<p class="txt_explan">시설안내는 최대 7개까지 등록 가능합니다.</p>
								</div>
							</li>
						</ul>
						<ul class="comm_buttons">
							<li><button type="reset" class="btn_close comm_btn cnc">취소</button></li>
							<li><button type="submit" class="comm_btn sbm">신청</button></li>
						</ul>
					</form>
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
	<script type="text/javascript">
		addInputs();
		setOneFile();
		setFile();
	</script>
</body>
</html>