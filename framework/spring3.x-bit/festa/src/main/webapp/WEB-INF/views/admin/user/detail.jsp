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
	<script type="text/javascript">
		$(document).ready(function(){
			
			var textBox = $('#delete .pop_tit');
			var text;
			
			//피드삭제버튼 눌렀을때
			$(document).on('click', '.btn_feed', function() {
				var value = $(this).data('value');
				 $('#num').val(value);
				 console.log($('#num').val());
				 text = '선택하신 피드를 삭제하시겠습니까?';
				 textBox.text(text);
				 console.log(text);
			});
			
			//댓글삭제버튼 눌렀을때
			$(document).on('click', '.btn_cmmt', function() {
				var value = $(this).data('value');
				 $('#num').val(value);
				 console.log($('#num').val());
				 text = '선택하신 댓글 삭제하시겠습니까?';
				 textBox.text(text);
				 console.log(text);
			});
			
			//삭제하기버튼 클릭시
			$(document).on('click', '#delete_btn', function() {
				//그 버튼이 댓글일때
				if(text == '선택하신 댓글 삭제하시겠습니까?'){
					console.log(text);
					var mcnum = $('#num').val();
					$.post('${root}admin/cmmt/del','mcnum='+mcnum,function(){
						$('.btn_close').click(function(){
							location.reload();
						});
					});
				//그 버튼이 게시글일때
				}else if(text == '선택하신 피드를 삭제하시겠습니까?'){
					console.log(text);
					var mpnum = $('#num').val();
					$.post('${root}admin/user/detail/del','mpnum='+mpnum,function(){
						$('.btn_close').click(function(){
							location.reload();
						});
					});
				}
			});
		
			//댓글 더보기버튼
			$(document).on('click', '.cmt_btn_more', function() {
				var btn = $(this);
				var pageTag = $(this).find('span');
				var myPage = pageTag.text();
				myPage++;
				pageTag.text(myPage);
				var feed = btn.parents('.feed_viewer');
				var comments = btn.siblings('.comment_list');
				var mpnum = feed.find('input[type=hidden]').val();
				$.get('${root}admin/user/detail/cmmt','pronum=${userdetail.pronum}&mpnum='+mpnum+'&pageSearch.page4='+myPage,function(data){
					$(data).each(function(index){
						var time = new Date(data[index].mcdate);
						var year = time.getFullYear();
						var month;
						if(time.getMonth()+1<10){
							month = '0'+(time.getMonth()+1);
						}else {
							month = time.getMonth()+1;
						}
						var date = time.getDate();
						if(index==3){
							 return false;
						}else if(data.length<4){
							btn.hide();
						}
						comments.append('<li>'+
								'<a href="" class="pf_picture">'+
									'<img src="${root }resources/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">'+
								'</a><p class="cmt_content">'+
									'<a href="" class="cmt_name">'+data[index].mcauthor+'</a>'+
									data[index].mccontent+
									'<span class="cmt_date">'+year+'-'+month+'-'+date+'</span>'+
									'<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="'+data[index].mcnum+'"><em class="snd_only">삭제하기</em></button></p>'+
							'</li>');
					});//each문 end
				});//ajax통신 end
			});//댓글더보기 end
			
			
			//첫화면때 2개만 피드출력
			$('.feed_viewer').each(function(index){
				if(index>1){
					$('.feed_viewer').eq(index).hide();
				}
			});
			
			//스크롤 내렸을때 피드 2개씩 출력
			$(window).scroll(function(){
			    var scrolltop = parseInt ( $(window).scrollTop() );
			    if( scrolltop >= $(document).height() - $(window).height() - 1 ){
					var scrollTag=$('#footer').siblings('span');
					var scroll=scrollTag.text();
					scroll++;
					scrollTag.text(scroll);
					console.log(scroll);
					var curfeedcnt=$('.feed_viewer').length;
					var myfeedcnt=$('.cnt_list li b').eq(0).text();
					myfeedcnt=Number(myfeedcnt);
					$('.feed_viewer').eq(scroll*2).show();
					$('.feed_viewer').eq(scroll*2+1).show();
			    }
			});
		});
	</script>
</head>
<body>
<c:if test="${sessionScope.login eq null}">
	<c:redirect url="/empty"/>
</c:if>
<div id="wrap" class="adm">
	<section class="banner_area">
		<div class="container">
			<dl>
				<dt><span>관리자페이지 이용 시 주의사항</span></dt>
				<dd>회원 징계 시 다시 한번 확인하고 처리할 것 / 모든 삭제 기능 처리 시 신중하게 처리할 것</dd>
			</dl>
		</div>
	</section>
	<!-- #유저 홈 -->
	<!-- 서브페이지 시작 { -->
	<div id="container" class="home_wrap">
		<h2 class="snd_only">${userdetail.proname } 님의 계정 홈</h2>
		<!-- 프로필영역 시작 { -->
		<section class="profile_area">
			<div class="container w720">
				<div class="info_box">
					<dl>
						<dt class="pf_tit">
							<a class="pf_name" href="">
								<b >${userdetail.proname }</b>
							</a>
						</dt>
						<dd class="pf_intro">${userdetail.prointro }</dd>
						<dd class="pf_hashtag">
							<a href="">${userdetail.proaddr }</a>
						</dd>
						<dd class="pf_picture">
							<img src="http://placehold.it/120x120" alt="김덕수님의 프로필 썸네일">
						</dd>
					</dl>
				</div>
				<div class="cnt_list">
					<ul>
						<li>피드<b>${userfeedcount }</b></li>
						<li>팔로워<a class="btn_pop" href="${root }admin/follower?pronum=${userdetail.pronum}">${userfollower }</a></li>
						<li>팔로우<a class="btn_pop" href="${root }admin/following?pronum=${userdetail.pronum}">${userfollowing }</a></li>
					</ul>
				</div>
			</div>
		</section>
		<!-- } 프로필영역 끝 -->
		<div class="container w720">
			<!-- 컨텐츠영역 시작 { -->
			<section class="content_area">
				<!-- #텍스트+썸네일 피드 시작 { -->
				<c:forEach items="${userfeed }" var="userfeed">
				<c:choose>
				<c:when test="${userfeed.mpphoto ne '' }">
				<div class="feed_viewer">
					<div class="tit box">
						<dl class="feed_inform">
							<dt>
								<a href="${root }admin/user/detail?pronum=${userfeed.pronum}">
									<input type="hidden" value="${userfeed.mpnum }">
									<span class="pf_picture"><img src="http://placehold.it/55x55" alt="김덕수님의 프로필 썸네일"></span>
									<span class="fd_name">${userfeed.mpauthor }</span>
								</a>
							</dt>
							<dd>
								<span class="fd_date">${userfeed.mpdate }</span>
								<b class="fd_liked">${userfeed.mpgood }</b>
							</dd>
						</dl>
						<ul class="feed_options">
							<li><button class="btn_pop btn_delete btn_feed" data-layer="delete" data-value="${userfeed.mpnum }"><em class="snd_only">삭제하기</em></button></li>
						</ul>
					</div>
					<div class="text box">
						<div class="scrBar">
							<div class="feed_content">
								<ul class="fd_hashtag">
									<li><a href="">${userfeed.httitle1 }</a></li>
									<li><a href="">${userfeed.httitle2 }</a></li>
									<li><a href="">${userfeed.httitle3 }</a></li>
								</ul>
								<p class="fd_content">${userfeed.mpcontent }</p>
							</div>
							<ul class="comment_list">
								<c:set var="i" value="0"/>
								<c:set var="doneLoop" value="false"/>
								<c:forEach items="${usercmmt }" var="usercmmt">
									<c:if test="${userfeed.mpnum eq usercmmt.mpnum}">
										<c:if test="${not doneLoop }">
										<li>
											<!-- # 프로필 이미지 없음 { -->
											<a href="${root }admin/user/detail?pronum=${groupcmmt.pronum}" class="pf_picture">
												<img src="${root }resources/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">
											</a>
											<!-- } # 프로필 이미지 없음 -->
											<p class="cmt_content">
												<a href="${root }admin/user/detail?pronum=${usercmmt.pronum }" class="cmt_name">${usercmmt.mcauthor }</a>
												${usercmmt.mccontent }
												<span class="cmt_date">${usercmmt.mcdate }</span>
												<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="${usercmmt.mcnum }"><em class="snd_only">삭제하기</em></button>
											</p>
										</li>
											<c:set var="i" value="${i+1 }"/>
											<c:if test="${i eq 3 }">
												<c:set var="doneLoop" value="true"/>
											</c:if>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
							<c:if test="${userfeed.mptotal gt 3 }">
								<button class="cmt_btn_more"><span class="snd_only">1</span>3개의 댓글 더 보기</button>
							</c:if>
						</div>
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
				</c:when>
				<c:otherwise>
				<!-- #텍스트 피드 시작 { -->
				<div class="feed_viewer">
					<div class="tit box">
						<dl class="feed_inform">
							<dt>
								<a href="${root }admin/user/detail?pronum=${userfeed.pronum}">
									<input type="hidden" value="${userfeed.mpnum }">
									<span class="pf_picture"><img src="http://placehold.it/55x55" alt="김덕수님의 프로필 썸네일"></span>
									<span class="fd_name">${userfeed.mpauthor }</span>
								</a>
							</dt>
							<dd>
								<span class="fd_date">${userfeed.mpdate }</span>
								<b class="fd_liked">${userfeed.mpgood }</b>
							</dd>
						</dl>
						<ul class="feed_options">
							<li><button class="btn_pop btn_delete btn_feed" data-layer="delete" data-value="${userfeed.mpnum }"><em class="snd_only">삭제하기</em></button></li>
						</ul>
					</div>
					<div class="text box">
						<div class="scrBar">
							<div class="feed_content">
								<ul class="fd_hashtag">
									<li><a href="">${userfeed.httitle1 }</a></li>
									<li><a href="">${userfeed.httitle2 }</a></li>
									<li><a href="">${userfeed.httitle3 }</a></li>
								</ul>
								<p class="fd_content">${userfeed.mpcontent }</p>
							</div>
							<ul class="comment_list">
								<c:set var="i" value="0"/>
								<c:set var="doneLoop" value="false"/>
								<c:forEach items="${usercmmt }" var="usercmmt">
									<c:if test="${userfeed.mpnum eq usercmmt.mpnum}">
										<c:if test="${not doneLoop }">
										<li>
											<!-- # 프로필 이미지 없음 { -->
											<a href="${root }admin/user/detail?pronum=${groupcmmt.pronum}" class="pf_picture">
												<img src="${root }resources/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">
											</a>
											<!-- } # 프로필 이미지 없음 -->
											<p class="cmt_content">
												<a href="${root }admin/user/detail?pronum=${usercmmt.pronum}" class="cmt_name">${usercmmt.mcauthor }</a>
												${usercmmt.mccontent }
												<span class="cmt_date">${usercmmt.mcdate }</span>
												<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="${usercmmt.mcnum }"><em class="snd_only">삭제하기</em></button>
											</p>
										</li>
											<c:set var="i" value="${i+1 }"/>
											<c:if test="${i eq 3 }">
												<c:set var="doneLoop" value="true"/>
											</c:if>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
							<c:if test="${userfeed.mptotal gt 3 }">
								<button class="cmt_btn_more"><span class="snd_only">1</span>3개의 댓글 더 보기</button>
							</c:if>
						</div>
					</div>
				</div>
				<!-- } #텍스트 피드 끝 -->
				</c:otherwise>
				</c:choose>
				</c:forEach>
			</section>
			<!-- } 컨텐츠영역 끝 -->
		</div>
	</div>
	<span class="snd_only">0</span>
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
<!-- #피드 삭제하기 { -->
<div id="delete" class="fstPop">
	<div class="del_wrap pop_wrap">
		<h4 class="pop_tit">선택하신 피드를 삭제하시겠습니까?</h4>
		<input type="hidden" id="num" value="">
		<form>
			<ul class="comm_buttons">
				<li><button type="button" class="btn_close comm_btn cnc">닫기</button></li>
				<li><button type="button" id="delete_btn" class="btn_pop comm_btn cfm" data-layer="success">삭제하기</button></li>
			</ul>
		</form>
	</div>
	<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
</div>
<!-- } #팝업 삭제하기 -->

<!-- #팝업 처리완료 { -->
<div id="success" class="fstPop">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit">처리가 완료되었습니다.</p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
	feedType('feed_viewer');
	fileThumbnail();
</script>
</body>
</html>