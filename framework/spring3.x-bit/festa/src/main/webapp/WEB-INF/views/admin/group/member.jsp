<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<!-- #그룹 멤버 팝업 -->
<c:if test="${sessionScope.login eq null}">
	<c:redirect url="/empty"/>
</c:if>
<div class="adm">
	<div class="follow_wrap pop_wrap">
		<h3 class="pop_tit"><span>그룹 멤버</span></h3>
		<div class="scrBar">
			<ul>
			<c:choose>
				<c:when test="${!empty joingroup }">
					<c:forEach items="${joingroup }" var="joingroup">
						<li>
							<a href="${root }admin/user/detail?pronum=${joingroup.profile.pronum}">
								<span class="pf_picture">
									<img src="http://placehold.it/50x50" alt="김덕수님의 프로필 썸네일">
								</span>
								<b class="fw_name">${joingroup.profile.proname }</b>
								<span class="fw_intro">${joingroup.profile.prointro }</span>
							</a>
						</li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li class="fstEmpty">가입한 인원이 없습니다.</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
</script>