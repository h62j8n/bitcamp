<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<!-- #팝업 신고 내용 보기 { -->
<div class="report_viewer pop_wrap">
	<h4 class="pop_tit">접수된 신고</h4>
	<form>
		<dl class="txt_box">
			<dt>신고 사유</dt>
			<dd class="rpv_txt">타인에 대한 욕설 또는 비방</dd>
			<dd class="rpv_img scrBar"><img src="http://placehold.it/620x300" alt=""></dd>
		</dl>
	</form>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	scrBar();
</script>
<!-- } #팝업 신고 내용 보기 -->