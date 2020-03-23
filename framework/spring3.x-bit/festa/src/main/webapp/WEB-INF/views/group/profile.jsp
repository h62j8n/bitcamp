<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
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
					<button type="submit"><img src="${root }resources/images/ico/btn_search.png" alt="검색"></button>
				</form>
				<ul id="gnb">
					<li><a href="${root }camp/">캠핑정보</a></li>
					<li><a href="${root }hot/">인기피드</a></li>
					<li><a href="${root }news/">뉴스피드</a></li>
					<li><a href="${root }member/login" class="btn_pop">로그인</a></li>
				</ul>
				<button type="button" id="btnTop"><em class="snd_only">맨 위로</em></button>
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
							<a class="pf_name" href="${root }group/"><b>입돌아간다</b></a>
							<!-- 캠핑장 공식그룹일 경우 { -->
							<span class="gp_official"></span>
							<!-- } 캠핑장 공식그룹일 경우 -->
							<!-- 그룹장일 경우 톱니바퀴 버튼 { -->
							<a class="pf_opt go_settings" href="${root }group/profile"><em class="snd_only">설정</em></a>
							<!-- } 그룹장일 경우 톱니바퀴 버튼 -->
						</dt>
						<dd class="pf_intro">안녕하세요 ㅇㅇㅇ입니다. 그룹 소개글을 입력해주세요. 그룹 소개글을 입력해주세요.</dd>
						<dd class="pf_hashtag">
							<a href="">해시태그</a>
							<a href="">해시태그</a>
							<a href="">해시태그</a>
						</dd>
						<dd class="gp_list">
							<span>그룹장 : 고재현</span>
							<a class="btn_pop btn_member" href="${root }group/member">멤버 : 33명</a>
							<span>개설일 : 2020년 02월 03일</span>
							<a class="btn_pop btn_out" href="${root }group/out">탈퇴</a>
						</dd>
						<dd class="pf_picture">
							<img src="http://placehold.it/120x120" alt="입돌아간다 그룹 썸네일">
						</dd>
					</dl>
				</div>
				<p class="social_btns">
					<button type="button" class="btn_chat" onclick="window.open('${root}group/chat','Festa chat','width=721,height=521,location=no,status=no,scrollbars=no');">그룹채팅</button>
				</p>
			</div>
		</section>
		<!-- } 프로필영역 끝 -->
		<div class="container">
			<!-- 좌측 사이드메뉴 시작 { -->
			<section class="side_area">
				<ul class="lnb_list">
					<li><a href="${root }group/profile" class="act">그룹 관리</a></li>
					<li><a href="${root }group/user">그룹원 관리</a></li>
					<li><a href="${root }group/req">가입신청 조회</a></li>
				</ul>
			</section>
			<!-- } 좌측 사이드메뉴 시작 -->
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<h2 class="set_tit">그룹 관리</h2>
				<form class="set_form">
					<ul class="input_list">
						<li class="set_file1 box">
							<p>그룹 대표사진</p>
							<div>
								<p class="pf_picture">
									<img src="${root }resources/images/thumb/no_profile.png" alt="그룹의 프로필 썸네일">
								</p>
								<ul class="comm_buttons_s">
									<li>
										<input type="file" id="festa2" name="festa2" accept="image/*">
										<label for="festa2" class="comm_btn cfm">등록</label>
									</li>
									<li>
										<button type="button" class="comm_btn">삭제</button>
									</li>
								</ul>
							</div>
						</li>
						<li class="box">
							<p><label for="festa1">그룹 이름</label></p>
							<div>
								<input type="password" id="festa1" name="festa1" required="required">
							</div>
						</li>
						<li class="box">
							<p><label for="festa3">그룹 소개</label></p>
							<div>
								<textarea id="festa3" name="festa3" placeholder="??자 이내로 작성해주세요"></textarea>
							</div>
						</li>
					</ul>
					<ul class="input_list">
						<li class="box">
							<p><label for="festa4">그룹 관심지역</label></p>
							<div>
								<select class="comm_sel" id="festa4" name="festa4">
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
						<li class="set_tags box">
							<p>해시태그 등록</p>
							<div>
								<ul>
									<li><input type="text" id="festa5" name="festa5"></li>
									<li><input type="text" id="festa6" name="festa6"></li>
									<li><input type="text" id="festa7" name="festa7"></li>
								</ul>
							</div>
						</li>
					</ul>
					<ul class="input_list">
						<li class="set_chk box">
							<p>그룹 설정</p>
							<div>
								<input type="checkbox" class="comm_rdo rdo_pop" id="festa8" name="festa8" data-url="${root }group/profile/del">
								<label for="festa8">그룹 삭제</label>
								<p class="txt_explan">
									그룹 삭제 시 프로필 및 공유한 피드가 모두 삭제되며, 복구가 불가능합니다.<br>
								</p>
								<p class="txt_explan">
									※ 그룹 삭제는 그룹 멤버가 없는 상태에서만 가능하므로 <span class="err">가입한 멤버가 있을 경우</span><br>
									<span class="err">그룹원 관리에서 모두 추방</span> 후 진행해주세요.<br>
								</p>
							</div>
						</li>
					</ul>
					<ul class="comm_buttons">
						<li><button type="reset" class="btn_close comm_btn cnc">취소</button></li>
						<li><button type="submit" class="comm_btn sbm">저장</button></li>
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
   rdoPop();
</script>
</body>
</html>