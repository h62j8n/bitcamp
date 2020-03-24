<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<c:url value="/" var="root" />
<!doctype html>
<!-- #팝업 피드 -->
<!-- #텍스트+썸네일 피드 시작 { -->
<script type="text/javascript">
	$(document).ready(function(){
		
		$('.ntccmmt').on('click', function() {
			$.ajax({
		        type: 'post',
		        url: '${root}group/ntc_feed/cmmtadd',
		        data: {
		        	"gnccontent": $('#ntcaddmsg').val(),
		        	"gncauthor": $('#ntcaddName').val(),
		        	"gnnum": $('#ntcaddGn').val(),
		        	"pronum": $('#ntcaddPro').val(),
		        	"grnum": $('#ntcaddGr').val(),
		        },
		        success : function(data) {
	    			$.ajax({   
	    			      url: "${root}group/ntc_feed?gnnum=${ntcDetail.gnnum}&grnum=${ntcDetail.grnum}",   
	    			      cache: false   
	    			}).done(function(html) {   
	    			      $("#feed_viewerntc").replaceWith(html);   
	    			});  
		        }
		    });
		});

		$(document).on('click', '.cmt_btn_more.ndt', function() {
			var btn = $(this);
			var pageTag = $(this).find('span');
			var myPage = pageTag.text();
			myPage++;
			pageTag.text(myPage);
			var feed = btn.parents('.feed_viewer');
			var comments = btn.siblings('.comment_list');
			var gnnum = feed.find('#cmmtGnnum').val();
			var del=$('#ntcaddPro').val();
			var del2=$('#del2').val();
			$.get('${root}group/ntc_feed/ntccmmt','gnnum='+gnnum+'&pageSearch.page4='+myPage,function(data){
				$(data).each(function(index){
					if(index==3){
						return false;
					}else if(data.length<4){
						btn.hide();
					}
					if(del==data[index].pronum || del==del2){
						comments.append('<li>'+
								'<a href="" class="pf_picture">'+
									'<img src="${root }resources/upload/thumb/no_profile.png" alt="'+data[index].gncauthor+'님의 프로필 썸네일">'+
								'</a><p class="cmt_content">'+
									'<a href="" class="cmt_name">'+data[index].gncauthor+'</a>&nbsp;&nbsp;'+data[index].gnccontent+
									'<span class="cmt_date">'+data[index].gncdate1+'</span>'+
									'<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="'+data[index].gncnum+'"><em class="snd_only">삭제하기</em></button></p>'+
							'</li>');
					} else{
						comments.append('<li>'+
								'<a href="" class="pf_picture">'+
									'<img src="${root }resources/upload/thumb/no_profile.png" alt="'+data[index].gncauthor+'님의 프로필 썸네일">'+
								'</a><p class="cmt_content">'+
									'<a href="" class="cmt_name">'+data[index].gncauthor+'</a>&nbsp;&nbsp;'+data[index].gnccontent+
									'<span class="cmt_date">'+data[index].gncdate1+'</span></li>'
									);
					}
				});//each문 end  
			});//ajax통신 end
		});//댓글더보기 end
		
		$('.btn_delete.btn_pop.ntc').on('click', function() {
			var ntcdel = $(this).data('value');
			$('#ntcnum').val(ntcdel);
		});
		
		$('.btn_delete.btn_pop.ntccmmt').on('click', function() {
			var cmmtdel = $(this).data('value');
			$('#ntcfnum').val(cmmtdel);
		});
		
	});
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />

<div class="feed_viewer" id="feed_viewerntc">
	<div class="tit box">
		<dl class="feed_inform">
			<dt>
				<a href="">
					<input type="hidden" id="ntcaddName" value="${login.proname}" />
					<input type="hidden" id="ntcaddPro" value="${login.pronum}" />
					<input type="hidden" id="ntcaddGr" value="${ntcDetail.grnum}">
					<input type="hidden" id="ntcaddGn" value="${ntcDetail.gnnum}">
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
				<li><button class="btn_delete btn_pop ntc" data-layer="deletentcfeed" data-value="${ntcDetail.gnnum }"><em class="snd_only">삭제하기</em></button></li>
			</c:if>
		</ul>
	</div>
	<div class="text box ntc">
		<div class="scrBar">
			<div class="feed_content">
				<p class="fd_content">${ntcDetail.gncontent }</p>
			</div>
			<ul class="comment_list ntc">
				<c:set var="i" value="0" />
				<c:set var="doneLoop" value="false" />
				<c:forEach items="${ntcCmmt }" var="ntcCmmt">
					<input type="hidden" id="del2" value="${detail.pronum }" />
					<input type="hidden" id="cmmtGnnum" value="${ntcCmmt.gnnum}" />
					<input type="hidden" id="cmmtGncnum" value="${ntcCmmt.gncnum}" />
					<c:if test="${ntcDetail.gnnum eq ntcCmmt.gnnum}">
						<c:if test="${not doneLoop }">
							<li>
								<!-- # 프로필 이미지 없음 { -->
								<a href="" class="pf_picture">
									<img src="${root }resources/upload/thumb/no_profile.png" alt="${ntcCmmt.gncauthor }님의 프로필 썸네일">
								</a>
								<!-- } # 프로필 이미지 없음 -->
								<p class="cmt_content">
									<a href="" class="cmt_name">${ntcCmmt.gncauthor }</a>&nbsp;&nbsp;${ntcCmmt.gnccontent }
									<span class="cmt_date">${ntcCmmt.gncdate }</span>
									<c:if test="${(login.pronum eq ntcCmmt.pronum) or (login.pronum eq detail.pronum)}">
										<button class="btn_delete btn_pop ntccmmt" data-layer="deletentc" data-value="${ntcCmmt.gncnum }"><em class="snd_only">삭제하기</em></button>
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
				<button class="cmt_btn_more ndt"><span class="snd_only">1</span>댓글 더 보기</button>
			</c:if>
		</div>
		<form class="message_form" action="" method="post">
			<a class="pf_picture" href="">
				<img src="http://placehold.it/30x30" alt="나의 프로필 썸네일">
			</a>
			<p class="msg_input">
				<textarea id="ntcaddmsg" name="ntcaddmsg" placeholder="메세지를 입력해주세요"></textarea>
				<button type="button" class="btn_send ntccmmt"><em class="snd_only">전송</em></button>
			</p>
		</form>
	</div>
	<!-- # 썸네일 영역 { -->
	<!-- <div class="img box">
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
	</div> -->
	<!--  } # 썸네일 영역 -->
</div>
<!-- } #텍스트+썸네일 피드 끝 -->

<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>

	<div id="deletentc" class="fstPop">
		<div class="out_wrap pop_wrap">
			<h3 class="pop_tit">댓글을 삭제하시겠습니까?</h3>
			<input type="hidden" id="ntcnum" value="">
			<div class="btn_box">
				<ul class="comm_buttons">
					<li><button type="button" class="btn_close comm_btn cnc">취소</button></li>
					<li><button type="button" id="deletecmmt" class="btn_pop2 comm_btn sbm ntccmmt" data-layer="ok">확인</button></li>
				</ul>
			</div>
		</div>
		<button type="button" class="btn_close">
			<em class="snd_only">창 닫기</em>
		</button>
	</div>
	
	<div id="deletentcfeed" class="fstPop">
		<div class="out_wrap pop_wrap">
			<h3 class="pop_tit">피드를 삭제하시겠습니까?</h3>
			<input type="hidden" id="ntcfnum" value="">
			<div class="btn_box">
				<ul class="comm_buttons">
					<li><button type="button" class="btn_close comm_btn cnc">취소</button></li>
					<li><button type="button" id="deletefeed" class="btn_pop2 comm_btn sbm ntc" data-layer="ok">확인</button></li>
				</ul>
			</div>
		</div>
		<button type="button" class="btn_close">
			<em class="snd_only">창 닫기</em>
		</button>
	</div>
	
<script type="text/javascript">
	scrBar();
	feedType('feed_viewer');
	btnToggle('btn_liked');
	btnPop('btn_pop2');
</script>