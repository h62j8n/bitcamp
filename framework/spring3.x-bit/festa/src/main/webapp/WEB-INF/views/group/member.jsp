<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!-- #그룹멤버 팝업 -->
<div class="follow_wrap pop_wrap">
	<h3 class="pop_tit"><span>그룹 멤버</span></h3>
	<div class="scrBar">
		<ul>
			<c:choose>
				<c:when test="${detail.grtotal ne 0}">
		            <c:forEach items="${member }" var="member">
						<li>
							<a href="">
								<span class="pf_picture">
									<img src="http://placehold.it/50x50" alt="김덕수님의 프로필 썸네일">
								</span>
								<b class="fw_name">${member.profile.proname }</b>
								<span class="fw_intro">${member.profile.prointro }</span>
							</a>
							<c:forEach items="${followlist}" var="followlist" >
								<c:choose>
									<c:when test="${member.profile.pronum eq followlist.pronum_sync}">
										<button class="btn_follow act" class="unfoll">팔로잉</button>
									</c:when>
									<c:otherwise>
										<button class="btn_follow" class="foll">팔로우</button>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</li>
					</c:forEach>
				</c:when>
			</c:choose>
		</ul>
	</div>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
	btnFollow();
</script>