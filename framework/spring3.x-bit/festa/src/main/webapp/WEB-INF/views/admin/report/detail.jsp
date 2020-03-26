<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<c:if test="${sessionScope.login eq null}">
	<c:redirect url="/empty"/>
</c:if>
<c:if test="${sessionScope.login ne numm }">
	<c:if test="${sessionScope.login.proid ne 'admin@festa.com' }">
		<c:redirect url="/empty"/>
	</c:if>
</c:if>
<!-- #팝업 신고 내용 보기 { -->
<div class="report_viewer pop_wrap">
	<h4 class="pop_tit">접수된 신고</h4>
	<form>
		<dl class="txt_box">
			<dt>신고 사유</dt>
			<dd class="rpv_txt">${reportdetail.rlreport }</dd>
			<dd class="rpv_img scrBar"><img src="http://placehold.it/620x300" alt=""></dd>
		</dl>
	</form>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
</script>
<!-- } #팝업 신고 내용 보기 -->