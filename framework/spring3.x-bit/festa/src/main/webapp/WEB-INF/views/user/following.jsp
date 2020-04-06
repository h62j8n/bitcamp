<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/" var="root"></c:url>
<c:url value="/upload" var="upload"></c:url>
<script type="text/javascript">
	$(document).ready(function(){
		//팔로우 등록,해제
		$(document).on('click','.btn_follow',function(){
			var mfgname = $(this).siblings('a').find('.fw_name').text();
			var mfgname = $('.follow_wrap>input[type=hidden]').eq(1).val();
			var pronum_sync = $(this).siblings('a').find('input[type=hidden]').val();
			var pronum = $('.follow_wrap>input[type=hidden]').eq(0).val();
			var unFollow = $(this).hasClass('act');
			//팔로우 해제
			if(unFollow){
				$.post('${root}user/following','pronum='+pronum+'&mfgname'+mfgname+'&pronum_sync='+pronum_sync+'&following.mfgname' +mfgname);
			}
			//팔로우 등록
			else{
				$.post('${root}user/unfollow','pronum='+pronum+'&mfgname='+mfgname+'&pronum_sync='+pronum_sync);
			}
		});
	});
</script>
<!-- #팔로워/팔로우 팝업 -->
<div class="follow_wrap pop_wrap">
	<input type="hidden" value="${login.pronum}"/>
	<input type="hidden" value="${login.proname}"/>
	<h3 class="pop_tit"><span>팔로우</span></h3>
	<div class="scrBar">
		<ul>
			<c:if test="${fn:length(following) > 0}">
				<c:forEach items="${following }" var="following">
						<li>
							<a href="">
								<span class="pf_picture">
									<c:if test="${following.profile.prophoto ne ''}">
											<img src="${upload }/${following.profile.prophoto}" alt="${following.profile.prophoto }님의 프로필 썸네일" onload="squareTrim($(this), 50)">
										</c:if>
										<c:if test="${following.profile.prophoto eq '' }">
											<img src="${root }resources/upload/thumb/no_profile.png" alt="${following.profile.prophoto}님의 프로필 썸네일" onload="squareTrim($(this), 50)">										
										</c:if>
								</span>
								<input type="hidden" value="${following.profile.pronum }"/>
								<b class="fw_name">${following.profile.proname }</b>
								<span class="fw_intro">${following.profile.prointro }</span>
							</a>
							<c:forEach items="${followlist }" var="followlist">
								<c:choose>
									<c:when test="${following.profile.pronum eq followlist.pronum_sync }">
										<button class="btn_follow act following">팔로잉</button>
									</c:when>
								</c:choose>
							</c:forEach>
							<button class="btn_follow">팔로우</button>
						</li>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(following) == 0}">
				<li class="fstEmpty">팔로우하는 사람이 없습니다.</li>
			</c:if>
		</ul>
	</div>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
	btnFollow();
</script>