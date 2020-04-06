<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url value="/" var="root"></c:url>
<c:url value="/upload" var="upload"></c:url>
<!-- #팔로워/팔로우 팝업 -->
<div class="follow_wrap pop_wrap">
	<input type="hidden" value="${login.pronum}"/>
	<input type="hidden" value="${login.proname}"/>
	<h3 class="pop_tit"><span>팔로워</span></h3>
	<div class="scrBar">
		<ul>
			<c:if test="${fn:length(follower) > 0}">
				<c:forEach items="${follower }" var="follower">
						<li>
							<a href="">
								<span class="pf_picture">
									<c:if test="${follower.profile.prophoto ne ''}">
											<img src="${upload }/${follower.profile.prophoto}" alt="${follower.profile.prophoto }님의 프로필 썸네일" onload="squareTrim($(this), 50)">
										</c:if>
										<c:if test="${follower.profile.prophoto eq '' }">
											<img src="${root }resources/upload/thumb/no_profile.png" alt="${follower.profile.prophoto}님의 프로필 썸네일" onload="squareTrim($(this), 50)">										
										</c:if>
								</span>
								<b class="fw_name">${follower.profile.proname }</b>
								<span class="fw_intro">${follower.profile.prointro }</span>
							</a>
							<button class="btn_follow">팔로우</button>
						</li>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(follower) == 0}">
				<li class="fstEmpty">팔로워가 없습니다.</li>
			</c:if>
		</ul>
	</div>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
	btnFollow();
</script>