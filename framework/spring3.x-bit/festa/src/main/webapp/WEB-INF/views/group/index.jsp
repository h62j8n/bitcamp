<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/upload" var="upload"></c:url>
<c:url value="/" var="root" />
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
<script type="text/javascript">

	$(document).ready(function(){
		
		$("input:checkbox[name='ntc']").on('click', function(){
			$('.mk_tags').hide();
			$('#insertform').attr("action", "${root}group/noticeadd");
			$('#ntc1').removeAttr("name").attr({name : "gnauthor"}); 
			$('#ntc4').removeAttr("name").attr({name : "gncontent"});
			
			if("on" != $("input:checkbox[name='ntc']:checked").val()){
				$("#insertform").attr("action", "${root}group/add");
				$('#ntc1').removeAttr("name").attr({name : "gpauthor"}); 
				$('#ntc4').removeAttr("name").attr({name : "gpcontent"});
				$(".mk_tags").show();
			}
			
		});
		
		$('.feed_viewer').each(function(index){
			if(index>1){
				$('.feed_viewer').eq(index).hide();
			}
		});

		$(window).scroll(function(){
			var scrolltop = parseInt ( $(window).scrollTop() );
			if( scrolltop >= $(document).height() - $(window).height() - 1 ){
				var scrollTag=$('#footer').siblings('span');
				var scroll=scrollTag.text();
				scroll++;
				scrollTag.text(scroll);
				console.log(scroll);
				var curfeedcnt=$('.feed_viewer').length;
				$('.feed_viewer').eq(scroll*2).show();
				$('.feed_viewer').eq(scroll*2+1).show();
		    }
		});
		
		//댓글 입력하기 엔터
		$("#groupCmmtAddCont").keydown(function(key) {
            if (key.keyCode == 13) {
            	if (!event.shiftKey){
	    			var btn=$(this);
	    			var feed=btn.parents('.feed_viewer.ind');
	    			var gccontent=feed.find('#groupCmmtAddCont').val();
	    			$('#groupCmmtAddCont').val('');
	    			var gcauthor=feed.find('#cmmtName').val();
	    			var gpnum=feed.find('#cmmtGpnum').val();
	    			var pronum=feed.find('#cmmtPronum').val();
	    			var grnum=feed.find('#cmmtGrnum').val();
	    			console.log(gccontent+'/'+gcauthor+'/'+gpnum+'/'+pronum+'/'+grnum)
	    			$.post('${root}group/cmmtadd', 'gccontent='+gccontent+'&gcauthor='+gcauthor+'&gpnum='+gpnum+'&pronum='+pronum+'&grnum='+grnum, function(data){
	    				window.location.reload();
	    			});
            	}
            }
        });

		//댓글 입력하기 버튼클릭
		$('.btn_send.cmmt').on('click', function() {
			var btn=$(this);
			var feed=btn.parents('.feed_viewer.ind');
			var gccontent=feed.find('#groupCmmtAddCont').val();
			var gcauthor=feed.find('#cmmtName').val();
			var gpnum=feed.find('#cmmtGpnum').val();
			var pronum=feed.find('#cmmtPronum').val();
			var grnum=feed.find('#cmmtGrnum').val();
			console.log(gccontent+'/'+gcauthor+'/'+gpnum+'/'+pronum+'/'+grnum)
			
			$.post('${root}group/cmmtadd', 'gccontent='+gccontent+'&gcauthor='+gcauthor+'&gpnum='+gpnum+'&pronum='+pronum+'&grnum='+grnum, function(data){
				window.location.reload();
			});
		});
		
		//댓글 더보기
		$(document).on('click', '.cmt_btn_more.dt', function() {
			var btn = $(this);
			var pageTag = $(this).find('span');
			var myPage = pageTag.text();
			myPage++;
			pageTag.text(myPage);
			var feed = btn.parents('.feed_viewer.ind');
			var comments = btn.siblings('.comment_list.ind');
			var del=$('#cmmtPronum').val();
			var gpnum = feed.find('#cmmtGpnum').val();
			var pronum=feed.find('#cmmtPronum').val();
			var mpronum=feed.find('#masterPronum').val();
			var fpronum=feed.find('#feedPronum').val();
			$.get('${root}group/cmmt','gpnum='+gpnum+'&pageSearch.page4='+myPage,function(data){
				$(data).each(function(index){
					if(index==3){
						return false;
					}else if(data.length<4){
						btn.hide();
					}
					if(del == data[index].pronum || del == fpronum || pronum == mpronum){
						comments.append('<li>'+
								'<a href="" class="pf_picture">'+
									'<img src="${root }resources/upload/thumb/no_profile.png" alt="'+data[index].gcauthor+'님의 프로필 썸네일">'+
								'</a><p class="cmt_content">'+
									'<a href="" class="cmt_name">'+data[index].gcauthor+'</a>&nbsp;&nbsp;'+data[index].gccontent+
									'<span class="cmt_date">'+data[index].gcdate1+'</span>'+
									'<button class="btn_pop btn_delete btn_cmmt" data-layer="delete" data-value="'+data[index].gcnum+'"><em class="snd_only">삭제하기</em></button></p>'+
							'</li>');
						$('.snd_only').last().focus();
					}else{
						comments.append('<li>'+
								'<a href="" class="pf_picture">'+
									'<img src="${root }resources/upload/thumb/no_profile.png" alt="'+data[index].gcauthor+'님의 프로필 썸네일">'+
								'</a><p class="cmt_content">'+
									'<a href="" class="cmt_name">'+data[index].gcauthor+'</a>&nbsp;&nbsp;'+data[index].gccontent+
									'<span class="cmt_date">'+data[index].gcdate1+'</span></li>');
						$('<li>').last().focus();
					}
				});//each문 end
			});//ajax통신 end		
		});//댓글더보기 end
		

		//댓글삭제 클릭시
		$(document).on('click', '#groupcmmtdelete', function() {
			var cmmtdel = $(this).data('value');
			$('#num').val(cmmtdel);
		});

		//댓글삭제 클릭>확인시
		$('#deletecmmt').on('click', function(){
			var gcnum = $('#num').val();
			$.post('${root}group/cmmtdel', 'gcnum='+gcnum, function(data){
				openPop("cmmtok");
				$('#delcmsuccess').on('click', function(){
					window.location.reload();
				});
			}); 
		});

		//피드삭제 클릭시
		$(document).on('click', '#delgroupfeed', function() {
			var feeddel = $(this).data('value');
			$('#fnum').val(feeddel);
		});
		
		//피드삭제 클릭>확인시
		$('#deletefeed').on('click', function(){
			var gpnum = $('#fnum').val();
			$.post('${root}group/del', 'gpnum='+gpnum, function(data){
				openPop("feedok");
				$('#delsuccess').on('click', function(){
					window.location.reload();					
				});
			}); 
		});
	});
</script>
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
		<!-- #그룹 홈 (가입한 회원) -->
		<!-- 서브페이지 시작 { -->
		<div id="container" class="home_wrap">
			<h2 class="snd_only">${detail.grname } 그룹 홈</h2>
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
										test="${empty detail.httitle1 && empty detail.httitle3}">
										<a href="">${detail.httitle2}</a>
									</c:when>
									<c:when
										test="${empty detail.httitle2 && empty detail.httitle3}">
										<a href="">${detail.httitle1}</a>
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
				<!-- 컨텐츠영역 시작 { -->
				<section class="content_area">
					<!-- #공지사항 시작 {  -->
					<div class="feed_notice">
						<h3>공지사항</h3>
						<ul>
							<c:choose>
								<c:when test="${!empty ntc }">
									<c:forEach items="${ntc}" var="ntc">
										<li><a class="btn_pop"
											href="${root }group/ntc_feed?gnnum=${ntc.gnnum}&grnum=${detail.grnum}">
												<b>${ntc.gndate }</b>&nbsp;&nbsp;|&nbsp;&nbsp;${ntc.gncontent } </a></li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<li class="fstEmpty">등록된 공지사항이 없습니다.</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<!-- } #공지사항 끝 -->
					<!-- #피드만들기 시작 { -->
					<div class="feed_maker">
						<h3>피드 만들기</h3>
						<form action="${root }group/add" class="maker_form" method="post" enctype="multipart/form-data" id="insertform">
							<input type="hidden" id="ntc1" name="gpauthor" value="${login.proname }" />
							<input type="hidden" id="ntc2" name="pronum" value="${login.pronum }" />
							<input type="hidden" id="ntc3" name="grnum" value="${detail.grnum }" />
							<c:if test="${login.pronum eq detail.pronum }">
								<p class="mk_noti">
									<input type="checkbox" name="ntc" class="comm_chk" id="festaNt">
									<label for="festaNt">공지</label>
								</p>
							</c:if>
							<div class="mk_cont box">
								<p class="pf_picture">
									<img src="http://placehold.it/55x55"
										alt="${login.proname } 님의 프로필 썸네일">
								</p>
								<textarea id="ntc4" name="gpcontent"
									placeholder="${login.proname } 님, 무슨 생각을 하고 계신가요?"></textarea>
							</div>
							<div class="file_thumbnail mk_thumb box">
								<ul>
									<li class="ft_btn">
										<input type="file" id="file1" name="files" accept="video/*, image/*">
										<img src=""alt="">
										<button class="btn_cancle" type="button">
											<em class="snd_only">업로드 취소하기</em>
										</button>
										<label for="file1" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
									<li class="ft_btn">
										<input type="file" id="file2" name="files" accept="video/*, image/*">
										<img src="" alt="">
										<button class="btn_cancle" type="button">
											<em class="snd_only">업로드 취소하기</em>
										</button>
										<label for="file2" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
									<li class="ft_btn">
										<input type="file" id="file3" name="files" accept="video/*, image/*">
										<img src="" alt="">
										<button class="btn_cancle" type="button">
											<em class="snd_only">업로드 취소하기</em>
										</button>
										<label for="file3" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
									<li class="ft_btn">
										<input type="file" id="file4" name="files" accept="video/*, image/*">
										<img src="" alt="">
										<button class="btn_cancle" type="button">
											<em class="snd_only">업로드 취소하기</em>
										</button>
										<label for="file4" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
									<li class="ft_btn">
										<input type="file" id="file5" name="files" accept="video/*, image/*">
										<img src="" alt="">
										<button class="btn_cancle" type="button">
											<em class="snd_only">업로드 취소하기</em>
										</button>
										<label for="file5" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
								</ul>
							</div>
							<div class="mk_bottom box">
								<ul class="mk_tags">
									<li><input type="text" id="httitle1" name="httitle1"></li>
									<li><input type="text" id="httitle2" name="httitle2"></li>
									<li><input type="text" id="httitle3" name="httitle3"></li>
								</ul>
								<ul class="mk_btns">
									<li>
										<label for="file1" class="btn_file">
											<em class="snd_only">사진/동영상 업로드하기</em>
										</label>
									</li>
									<li>
										<button type="submit" class="btn_send">
											<em class="snd_only">피드 게시하기</em>
										</button>
									</li>
								</ul>
							</div>
						</form>
					</div>
					<!-- } #피드만들기 끝 -->
					<c:forEach items="${feed }" var="feed">
						<!-- #텍스트 피드 시작 { -->
						<div class="feed_viewer ind">
							<div class="tit box">
								<dl class="feed_inform">
									<dt>
										<a href="">
											<input type="hidden" id="cmmtName" value="${login.proname}" />
											<input type="hidden" id="cmmtPronum" value="${login.pronum}" />
											<input type="hidden" id="cmmtGrnum" value="${detail.grnum }" />
											<input type="hidden" id="masterPronum" value="${detail.pronum }" />
											<input type="hidden" id="feedPronum" value="${feed.pronum }" />
											<span class="pf_picture">
											<img src="http://placehold.it/55x55" alt="${feed.gpauthor}님의 프로필 썸네일"></span>
											<span class="fd_name">${feed.gpauthor}</span>
										</a> 
										<a href="">
											<span class="fd_group">${detail.grname}</span>
										</a>
									</dt>
									<dd>
										<span class="fd_date">${feed.gpdate }</span> <b
											class="fd_liked">${feed.gpgood }</b>
									</dd>
								</dl>
								<ul class="feed_options">
									<li><button class="btn_liked act">
											<em class="snd_only">하트</em>
										</button></li>
									<c:if
										test="${(login.pronum ne feed.pronum) and !(login.pronum eq detail.pronum)}">
										<li><a href="${root }group/report"
											class="btn_pop btn_report"> <em class="snd_only">신고하기</em>
										</a></li>
									</c:if>
									<c:if test="${login.pronum eq feed.pronum}">
										<li><a href="${root }group/maker"
											class="btn_pop btn_edit"> <em class="snd_only">수정하기</em>
										</a></li>
									</c:if>
									<c:if test="${(login.pronum eq feed.pronum ) or (detail.pronum eq login.pronum)}">
										<li>
											<button class="btn_delete feed btn_pop" id="delgroupfeed" data-layer="deletegrfeed" data-value="${feed.gpnum }">
												<em class="snd_only">삭제하기</em>
											</button>
										</li>
									</c:if>
								</ul>
							</div>
							<div class="text box">
								<div class="scrBar">
									<div class="feed_content">
										<ul class="fd_hashtag">
											<c:choose>
												<c:when
													test="${empty feed.httitle1 && empty feed.httitle2 && empty feed.httitle3}">
												</c:when>
												<c:when
													test="${empty feed.httitle1 && empty feed.httitle2}">
													<li><a href="">${feed.httitle3}</a></li>
												</c:when>
												<c:when
													test="${empty feed.httitle2 && empty feed.httitle3}">
													<li><a href="">${feed.httitle1}</a></li>
												</c:when>
												<c:when
													test="${empty feed.httitle1 && empty feed.httitle3}">
													<li><a href="">${feed.httitle2}</a></li>
												</c:when>
												<c:when test="${empty feed.httitle1}">
													<li><a href="">${feed.httitle2}</a></li>
													<li><a href="">${feed.httitle3}</a></li>
												</c:when>
												<c:when test="${empty feed.httitle2}">
													<li><a href="">${feed.httitle1}</a></li>
													<li><a href="">${feed.httitle3}</a></li>
												</c:when>
												<c:when test="${empty feed.httitle3}">
													<li><a href="">${feed.httitle1}</a></li>
													<li><a href="">${feed.httitle2}</a></li>
												</c:when>
												<c:otherwise>
													<li><a href="">${feed.httitle1}</a></li>
													<li><a href="">${feed.httitle2}</a></li>
													<li><a href="">${feed.httitle3}</a></li>
												</c:otherwise>
											</c:choose>
										</ul>
										<p class="fd_content">${feed.gpcontent }</p>
									</div>
									<input type="hidden" id="cmmtGpnum" value="${feed.gpnum}" />
									<ul class="comment_list ind">
										<c:set var="i" value="0" />
										<c:set var="doneLoop" value="false" />
										<c:forEach items="${feedcmmt }" var="feedcmmt">
											<c:if test="${(feed.gpnum eq feedcmmt.gpnum) and (detail.grnum eq feed.grnum)}">
												<c:if test="${not doneLoop }">
													<li class="">
														<!-- # 프로필 이미지 없음 { -->
														<a href="" class="pf_picture">
															<img src="${root }resources/upload/thumb/no_profile.png" alt="${feedcmmt.gcauthor }님의 프로필 썸네일">
														</a>
														<!-- } # 프로필 이미지 없음 -->
														<p class="cmt_content">
														<input type="hidden" id="delCmmtNum" value="${feedcmmt.gcnum}" />
														<a href="" class="cmt_name">${feedcmmt.gcauthor }</a>&nbsp;&nbsp;${feedcmmt.gccontent }
														<span class="cmt_date">${feedcmmt.gcdate }</span>
															<c:if test="${(login.pronum eq feed.pronum ) or (login.pronum eq feedcmmt.pronum) or (login.pronum eq detail.pronum)}">
																<button class="btn_delete btn_pop" id="groupcmmtdelete" data-layer="deletegrcmmt" data-value="${feedcmmt.gcnum }">
																	<em class="snd_only">삭제하기</em>
																</button>
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
									<c:if test="${feed.gptotal gt 3 }">
										<button class="cmt_btn_more dt">
											<span class="snd_only">1</span>댓글 더 보기
										</button>
									</c:if>
								</div>
								<form class="message_form">
									<a class="pf_picture" href=""><img
										src="http://placehold.it/30x30" alt="나의 프로필 썸네일"></a>
									<p class="msg_input">
										<textarea id="groupCmmtAddCont" name="groupCmmtAddCont"
											placeholder="메세지를 입력해주세요"></textarea>
										<button type="button" class="btn_send cmmt">
											<em class="snd_only">전송</em>
										</button>
									</p>
								</form>
							</div>
							<c:if test="${feed.gpphoto ne '' }">
								<!-- # 썸네일 영역 { -->
								<div class="img box">
									<div class="thumb_slide">
										<div class="swiper-wrapper">
											<c:set var="feedphoto" value="${feed.gpphoto }" />
											<%-- <c:out value='${gpphoto }'/> --%>
											<c:forTokens items="${feedphoto }" delims="," var="item">
												<div class="swiper-slide">
													<img src="${upload }/${item }" alt="">
												</div>
											</c:forTokens>
										</div>
										<div class="swiper-pagination"></div>
									</div>
								</div>
								<!--  } # 썸네일 영역 -->
							</c:if>
						</div>
						<!-- } #텍스트 피드 끝 -->
					</c:forEach>
				</section>
				<!-- } 컨텐츠영역 끝 -->
				<!-- 우측 사이드영역 시작 { -->
				<section class="side_area">
					<div class="rcmm_list">
						<h3>
							<em class="snd_only">추천그룹 목록</em>나홀로 캠핑이 심심하신가요?
						</h3>
						<ul>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="입돌아간다 그룹 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">입돌아간다</b> <span
									class="rc_intro">안녕하세요 ㅇㅇㅇ입니다. 안녕하세요</span>
							</a></li>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="그룹 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">그룹</b> <span
									class="rc_intro">그룹 소개글을 작성해주세요.</span>
							</a></li>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="그룹 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">그룹</b> <span
									class="rc_intro">그룹 소개글을 작성해주세요.</span>
							</a></li>
						</ul>
					</div>
					<div class="rcmm_list">
						<h3>
							<em class="snd_only">추천캠핑장 목록</em>이 캠핑장에도 가보셨나요?
						</h3>
						<ul>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="바다애캠핑장 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">바다애캠핑장</b> <span
									class="rc_hashtag">경기도</span>
							</a></li>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="캠핑장 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">캠핑장</b> <span
									class="rc_hashtag">경기도</span>
							</a></li>
							<li><a class="rc_thumb" href=""> <img
									src="http://placehold.it/55x55" alt="캠핑장 썸네일">
							</a> <a class="rc_text" href=""> <b class="rc_name">캠핑장</b> <span
									class="rc_hashtag">경기도</span>
							</a></li>
						</ul>
					</div>
				</section>
				<!-- } 우측 사이드영역 끝 -->
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
	
	<div id="deletegrcmmt" class="fstPop">
		<div class="out_wrap pop_wrap">
			<h3 class="pop_tit">댓글을 삭제하시겠습니까?</h3>
			<input type="hidden" id="num" value="">
			<div class="btn_box">
				<ul class="comm_buttons">
					<li><button type="button" id="colosecmmt" class="btn_close comm_btn cnc">취소</button></li>
					<li><button type="button" id="deletecmmt" class="btn_close comm_btn cfm">확인</button></li>
				</ul>
			</div>
		</div>
		<button type="button" class="btn_close">
			<em class="snd_only">창 닫기</em>
		</button>
	</div>
	
	<div id="deletegrfeed" class="fstPop">
		<div class="out_wrap pop_wrap">
			<h3 class="pop_tit">피드를 삭제하시겠습니까?</h3>
			<input type="hidden" id="fnum" value="">
			<div class="btn_box">
				<ul class="comm_buttons">
					<li><button type="button" id="closefeed"  class="btn_close comm_btn cnc">취소</button></li>
					<li><button type="button" id="deletefeed" class="btn_close comm_btn cfm" >확인</button></li>
				</ul>
			</div>
		</div>
		<button type="button" class="btn_close">
			<em class="snd_only">창 닫기</em>
		</button>
	</div>
	
	<!-- #팝업 처리불가 {
	<div id="" class="fstPop">
		<div class="confirm_wrap pop_wrap">
			<p class="pop_tit">그룹을 삭제할 수 없습니다.</p>
			<p class="pop_txt">아직 탈퇴하지 않은 그룹 멤버가 있습니다.</p>
			<ul class="comm_buttons">
				<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
			</ul>
		</div>
	</div>
	} #팝업 처리불가 -->

	<!-- #팝업 처리완료 { -->
	<div id="cmmtok" class="fstPop">
		<div class="confirm_wrap pop_wrap"> 
			<p class="pop_tit">처리가 완료되었습니다.</p>
			<ul class="comm_buttons">
				<li><button type="button" id="delcmsuccess" class="btn_close ok comm_btn cfm">확인</button></li>
			</ul>
		</div>
	</div>

	<!-- #팝업 처리완료 { -->
	<div id="feedok" class="fstPop">
		<div class="confirm_wrap pop_wrap"> 
			<p class="pop_tit">처리가 완료되었습니다.</p>
			<ul class="comm_buttons">
				<li><button type="button" id="delsuccess" class="btn_close ok comm_btn cfm">확인</button></li>
			</ul>
		</div>
	</div>
	
	<!-- } #팝업 처리완료 -->
	<script type="text/javascript">
		feedType('feed_viewer');
		btnPop('btn_pop2');
		setFile();
	</script>
</body>
</html>