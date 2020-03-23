<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<!-- #팝업 피드 -->
<!-- #텍스트+썸네일 피드 시작 { -->
<script type="text/javascript">
	$(document).ready(function(){
		
		$(document).on('click', '.cmt_btn_more.ndt', function() {
			var btn = $(this);
			var pageTag = $(this).find('span');
			var myPage = pageTag.text();
			myPage++;
			pageTag.text(myPage);
			var feed = btn.parents('.feed_viewer');
			var comments = btn.siblings('.comment_list');
			var gnnum = feed.find('input[type=hidden]').val();
			$.get('${root}group/ntc_feed/?gnnum=${ntcDetail.gnnum}&grnum=${detail.grnum}/ntccmmt','grnum=${detail.grnum}&gnnum='+gnnum+'&pageSearch.page4='+myPage,function(data){
				$(data).each(function(index){
					var time = new Date(data[index].gcdate);
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
								'<a href="" class="cmt_name">'+data[index].gncauthor+'</a>'+
								data[index].gnccontent+
								'<span class="cmt_date">'+year+'-'+month+'-'+date+'</span>'+
								'<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="'+data[index].gncnum+'"><em class="snd_only">삭제하기</em></button></p>'+
						'</li>');
				});//each문 end  
			});//ajax통신 end
		});//댓글더보기 end
		
	});
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<div class="feed_viewer">
	<div class="tit box">
		<dl class="feed_inform">
			<dt>
				<a href="">
					<input type="hidden" value="${ntcDetail.gnnum}">
					<span class="pf_picture"><img src="http://placehold.it/55x55" alt="김덕수님의 프로필 썸네일"></span>
					<span class="fd_name">[그룹장] ${ntcDetail.gnauthor}</span>
				</a>
				<a href="">
					<span class="fd_group">${detail.grname } 공지사항</span>
				</a>
			</dt>
			<dd>
				<span class="fd_date">${ntcDetail.gndate }</span>
			</dd>
		</dl>
		<ul class="feed_options">
			<c:if test="${login.pronum ne detail.pronum }">
				<li><a href="${root }group/ntc_report" class="btn_pop2 btn_report"><em class="snd_only">신고하기</em></a></li>
			</c:if>
			<c:if test="${login.pronum eq detail.pronum}">
				<li><a href="${root }group/ntc_maker" class="btn_pop2 btn_edit"><em class="snd_only">수정하기</em></a></li>		
				<li><button class="btn_delete"><em class="snd_only">삭제하기</em></button></li>
			</c:if>
		</ul>
	</div>
	<div class="text box">
		<div class="scrBar">
			<div class="feed_content">
				<p class="fd_content">${ntcDetail.gncontent }</p>
			</div>
			<ul class="comment_list">
				<c:set var="i" value="0" />
					<c:set var="doneLoop" value="false" />
					<c:forEach items="${ntcCmmt }" var="ntcCmmt">
						<c:if test="${ntcDetail.grnum eq ntcCmmt.grnum }">
							<c:if test="${not doneLoop }">
								<li>
									<!-- # 프로필 이미지 없음 { -->
									<a href="" class="pf_picture">
										<img src="${root }resources/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">
									</a>
									<!-- } # 프로필 이미지 없음 -->
									<p class="cmt_content">
										<a href="" class="cmt_name">${ntcCmmt.gncauthor }</a>
										${ntcCmmt.gnccontent }
										<span class="cmt_date">${ntcCmmt.gncdate }</span>
										<c:if test="${(login.pronum eq ntcCmmt.pronum) || (login.pronum eq detail.pronum)}">
											<button class="btn_delete"><em class="snd_only">삭제하기</em></button>
										</c:if>
									</p>
								</li>
							<c:set var="i" value="${i+1 }" />
							<c:if test="${i eq 3 }">
								<c:set var="doneLoop" value="true" />
							</c:if>
						</c:if>
					</c:if>
				</c:forEach>
			</ul>
			<c:if test="${ntcDetail.gntotal gt 3 }">
				<button class="cmt_btn_more dt"><span class="snd_only">1</span>댓글 더 보기</button>
			</c:if>
		</div>
		<form class="message_form" action="" method="post">
			<a class="pf_picture" href="">
				<img src="http://placehold.it/30x30" alt="나의 프로필 썸네일">
			</a>
			<p class="msg_input">
				<textarea id="ntcaddmsg" name="ntcaddmsg" placeholder="메세지를 입력해주세요"></textarea>
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
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
	feedType('feed_viewer');
	btnToggle('btn_liked');
	btnPop('btn_pop2');
</script>