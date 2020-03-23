<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
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
<c:if test="${sessionScope.login eq null}">
	<c:redirect url="/empty"/>
</c:if>
<div id="wrap">
	<div id="header">
		<div class="scrX">
			<div class="container">
				<h1>
					<a href="${root }admin/"><em class="snd_only">FESTA</em></a>
				</h1>
				<ul id="gnb">
					<li><a href="${root }admin/"><b>관리자</b></a></li>
					<li><a href="${root }member/logout" class="btn_pop">로그아웃</a></li>
				</ul>
				<button type="button" id="btnTop"><em class="snd_only">맨 위로</em></button>
			</div>
		</div>
	</div>
	<!-- #관리자 -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="setting_wrap">
		<!-- 관리자 상단배너 시작 { -->
		<section class="banner_area">
			<div class="container">
				<dl>
					<dt><span>관리자페이지 이용 시 주의사항</span></dt>
					<dd>회원 징계 시 다시 한번 확인하고 처리할 것 / 모든 삭제 기능 처리 시 신중하게 처리할 것</dd>
				</dl>
			</div>
		</section>
		<!-- } 관리자 상단배너 끝 -->
			<div class="container">
			<!-- 좌측 사이드메뉴 시작 { -->
			<section class="side_area">
				<ul class="lnb_list">
					<li><a href="${root }admin/">관리자 홈</a></li>
					<li><a href="${root }admin/user">회원 관리</a></li>
					<li><a href="${root }admin/group">그룹 관리</a></li>
					<li><a href="${root }admin/camp">캠핑장 관리</a></li>
					<li>
						<a href="${root }admin/venture" class="act">사업자 계정 관리</a>
						<ul>
							<li><a href="${root }admin/venture">사업자계정 관리</a></li>
							<li><a href="${root }admin/venture/req" class="act">사업자계정 신청 조회</a></li>
						</ul>
					</li>
					<li><a href="${root }admin/report">신고 관리</a></li>
				</ul>
			</section>
			<!-- } 좌측 사이드메뉴 시작 -->
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<h2 class="set_tit">사업자계정 신청 조회</h2>
				<form class="set_form">
					<table class="adm vt_table one">
						<caption class="snd_only">사업자계정 신청 목록</caption>
						<thead>
							<tr>
								<th class="tb_chk">
									<input type="checkbox" class="comm_chk" name="allChecked" id="allChecked">
									<label for="allChecked"><em class="snd_only">전체선택</em></label>
								</th>
								<th class="w60">No</th>
								<th class="w120">사업자 등록번호</th>
								<th>캠핑장명</th>
								<th class="w100">대표자</th>
								<th class="w120">신청일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl10">
									<label for="festaTbl10"><em class="snd_only">선택</em></label>
								</td>
								<td>10</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="/admin/camp/detail.html" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl9">
									<label for="festaTbl9"><em class="snd_only">선택</em></label>
								</td>
								<td>9</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl8">
									<label for="festaTbl8"><em class="snd_only">선택</em></label>
								</td>
								<td>8</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl7">
									<label for="festaTbl7"><em class="snd_only">선택</em></label>
								</td>
								<td>7</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl6">
									<label for="festaTbl6"><em class="snd_only">선택</em></label>
								</td>
								<td>6</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl5">
									<label for="festaTbl5"><em class="snd_only">선택</em></label>
								</td>
								<td>5</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl4">
									<label for="festaTbl4"><em class="snd_only">선택</em></label>
								</td>
								<td>4</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl3">
									<label for="festaTbl3"><em class="snd_only">선택</em></label>
								</td>
								<td>3</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl2">
									<label for="festaTbl2"><em class="snd_only">선택</em></label>
								</td>
								<td>2</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<tr>
								<td class="tb_chk">
									<input type="checkbox" class="comm_chk" name="" id="festaTbl1">
									<label for="festaTbl1"><em class="snd_only">선택</em></label>
								</td>
								<td>1</td>
								<td><button type="button" class="btn_pop">123-45-67890</button></td>
								<td>
									<p>
										<a href="" target="_blank">입돌아간다</a>
									</p>
								</td>
								<td>고재현</td>
								<td>2020-01-01</td>
							</tr>
							<!-- 빈 테이블 {
							<tr>
								<td colspan="6" class="fstEmpty">등록된 캠핑장이 없습니다.</td>
							</tr>
							} 빈 테이블 -->
						</tbody>
					</table>
					<div class="table_options">
						<ul class="comm_buttons_s">
							<li><button type="button" class="comm_btn btn_pop cnc" data-layer="hello">승인</button></li>
							<li><button type="button" class="comm_btn btn_pop" data-layer="sorry">거절</button></li>
						</ul>
					</div>
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
<!-- #팝업 승인하기 { -->
<div id="hello" class="fstPop">
	<div class="del_wrap pop_wrap">
		<h4 class="pop_tit">선택하신 회원의 신청을 승인하시겠습니까?</h4>
		<form>
			<ul class="comm_buttons">
				<li><button type="button" class="btn_close comm_btn cnc">닫기</button></li>
				<li><button type="button" class="btn_pop comm_btn cfm" data-layer="success">승인하기</button></li>
			</ul>
		</form>
	</div>
	<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
</div>
<!-- } #팝업 승인하기 -->
<!-- } #팝업 거절하기 -->
<div id="sorry" class="fstPop">
	<div class="del_wrap pop_wrap">
		<h4 class="pop_tit">선택하신 회원의 신청을 거절하시겠습니까?</h4>
		<form>
			<ul class="comm_buttons">
				<li><button type="button" class="btn_close comm_btn cnc">닫기</button></li>
				<li><button type="button" class="btn_pop comm_btn cfm" data-layer="success">거절하기</button></li>
			</ul>
		</form>
	</div>
	<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
</div>
<!-- } #팝업 거절하기 -->
<!-- #팝업 처리완료 { -->
<div id="success" class="fstPop">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit">처리가 완료되었습니다.</p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
		</ul>
	</div>
</div>
<!-- } #팝업 처리완료 -->
</body>
</html>