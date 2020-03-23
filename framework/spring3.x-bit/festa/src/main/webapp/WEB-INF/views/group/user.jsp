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
					<li><a href="${root }group/profile">그룹 관리</a></li>
					<li><a href="${root }group/user" class="act">그룹원 관리</a></li>
					<li><a href="${root }group/req">가입신청 조회</a></li>
				</ul>
			</section>
			<!-- } 좌측 사이드메뉴 시작 -->
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<h2 class="set_tit">그룹원 관리</h2>
				<div class="table_options">
					<form class="search_form">
						<input type="text" id="" name="" placeholder="이름을 입력해주세요">
						<button type="submit"><i class="xi-search"></i></button>
					</form>
				</div>
				<form class="set_form">
					<table class="gp us_table one">
						<caption class="snd_only">그룹원 목록</caption>
						<thead>
							<tr>
								<th class="tb_chk">
									<input type="checkbox" class="comm_chk" name="allChecked" id="festaTbl0">
									<label for="festaTbl0"><em class="snd_only">전체선택</em></label>
								</th>
								<th class="w60">No</th>
								<th>이름 (ID)</th>
								<th class="w120">생년월일</th>
								<th class="w60">성별</th>
								<th class="w100">관심지역</th>
								<th class="w120">가입일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl10">
									<label for="festaTbl10"><em class="snd_only">선택</em></label>
								</td>
								<td>10</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl9">
									<label for="festaTbl9"><em class="snd_only">선택</em></label>
								</td>
								<td>9</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl8">
									<label for="festaTbl8"><em class="snd_only">선택</em></label>
								</td>
								<td>8</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl7">
									<label for="festaTbl7"><em class="snd_only">선택</em></label>
								</td>
								<td>7</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl6">
									<label for="festaTbl6"><em class="snd_only">선택</em></label>
								</td>
								<td>6</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl5">
									<label for="festaTbl5"><em class="snd_only">선택</em></label>
								</td>
								<td>5</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl4">
									<label for="festaTbl4"><em class="snd_only">선택</em></label>
								</td>
								<td>4</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl3">
									<label for="festaTbl3"><em class="snd_only">선택</em></label>
								</td>
								<td>3</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl2">
									<label for="festaTbl2"><em class="snd_only">선택</em></label>
								</td>
								<td>2</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl1">
									<label for="festaTbl1"><em class="snd_only">선택</em></label>
								</td>
								<td>1</td>
								<td>
									<p>
										<a href="" target="_blank">
											김진혁 (user01@email.com)
										</a>
									</p>
								</td>
								<td>1994-01-01</td>
								<td>남</td>
								<td>경기도</td>
								<td>2020-01-01</td>
							</tr>
							<!-- 빈 테이블 {
							<tr>
								<td colspan="7" class="fstEmpty">가입한 그룹원이 없습니다.</td>
								<td colspan="7" class="fstEmpty">검색한 그룹원이 없습니다.</td>
							</tr>
							} 빈 테이블 -->
						</tbody>
					</table>
					<ul class="table_options comm_buttons_s">
						<li><button type="submit" class="comm_btn cnc">추방</button></li>
						<li><button type="submit" class="comm_btn">전체 추방</button></li>
					</ul>
				</form>
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