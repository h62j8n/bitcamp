<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/" var="root"></c:url>
<c:url value="/resources/upload" var="upload" />
<!DOCTYPE html>
<script type="text/javascript">
	//var start = '${start}';
</script>
<c:forEach items="${feedList}" var="feed" begin="5" end="6">
<c:set var="group" value="${feed.gpnum ne 0}" />
<c:choose>
	<c:when test="${!group}">
		<c:set var="feedContent" value="${feed.mpcontent}" />
		<c:set var="feedImages" value="${feed.mpphoto}" />
	</c:when>
	<c:otherwise>
		<c:set var="feedContent" value="${feed.gpcontent}" />
		<c:set var="feedImages" value="${feed.gpphoto}" />
	</c:otherwise>
</c:choose>
<div class="feed_viewer<c:if test="${!empty feedImages}"> half</c:if>">
	<div class="tit box">
		<dl class="feed_inform">
			<dt>
				<a href="${root}user/?pronum=${feed.pronum}">
					<span class="pf_picture">
					<c:choose>
						<c:when test="${!empty feed.profile.prophoto}"><img src="${upload}/${feed.profile.prophoto}" alt="${feed.profile.proname}님의 프로필 썸네일"></c:when>
						<c:otherwise><img src="${root}resources/images/thumb/no_profile.png" alt="${feed.profile.proname}님의 프로필 썸네일"></c:otherwise>
					</c:choose>
					</span>
					<span class="fd_name">${feed.profile.proname}</span>
				</a>
				<c:if test="${group}">
				<a href="${root}group/?grnum=${feed.grnum}&pronum=${login.pronum}"><span class="fd_group">${feed.group.grname}</span></a>
				</c:if>
			</dt>
			<dd>
				<span class="fd_date">${feed.date1}</span>
				<b class="fd_liked">${feed.good}</b>
			</dd>
		</dl>
		<ul class="feed_options">
			<li><button class="btn_liked act"><em class="snd_only">하트</em></button></li>
			<li><a href="/common/report" class="btn_pop btn_report"><em class="snd_only">신고하기</em></a></li>
			<li><a href="/common/maker" class="btn_pop btn_edit"><em class="snd_only">수정하기</em></a></li>
			<li><button class="btn_delete"><em class="snd_only">삭제하기</em></button></li>
		</ul>
	</div>
	<div class="text box">
		<div class="scrBar">
			<div class="feed_content">
				<ul class="fd_hashtag">
					<c:if test="${!empty feed.httitle1}"><li><a href="${root}search/?keyword=${feed.httitle1}">${feed.httitle1}</a></li></c:if>
					<c:if test="${!empty feed.httitle2}"><li><a href="${root}search/?keyword=${feed.httitle2}">${feed.httitle2}</a></li></c:if>
					<c:if test="${!empty feed.httitle3}"><li><a href="${root}search/?keyword=${feed.httitle3}">${feed.httitle3}</a></li></c:if>
				</ul>
				<pre class="fd_content">${feedContent}</pre>
			</div>
			<ul class="comment_list">
				<li>
					<a href="" class="pf_picture">
						<img src="/images/thumb/no_profile.png" alt="김진혁님의 프로필 썸네일">
					</a>
					<p class="cmt_content">
						<a href="" class="cmt_name">김진혁</a>
						댓글을 입력해주세요.
						<span class="cmt_date">2020년 01월 01일 12시 59분</span>
						<button class="cmt_btn_option"><em class="snd_only">댓글 옵션</em></button>
					</p>
				</li>
			</ul>
			<button class="cmt_btn_more">3개의 댓글 더 보기</button>
		</div>
		<form class="message_form">
			<a class="pf_picture" href="">
				<img src="http://placehold.it/30x30" alt="나의 프로필 썸네일">
			</a>
			<p class="msg_input">
				<textarea id="" name="" placeholder="메세지를 입력해주세요"></textarea>
				<button type="submit" class="btn_send"><em class="snd_only">전송</em></button>
			</p>
		</form>
	</div>
	<!-- # 썸네일 영역 { -->
	<c:if test="${!empty feedImages}">
	<div class="img box">
		<div class="thumb_slide">
			<div class="swiper-wrapper">
			<c:forTokens items="${feedImages}" var="images" delims=",">
				<div class="swiper-slide"><img src="${upload}/${images}" alt=""></div>
			</c:forTokens>
			</div>
			<div class="swiper-pagination"></div>
		</div>
	</div>
	</c:if>
	<!--  } # 썸네일 영역 -->
</div>
</c:forEach>