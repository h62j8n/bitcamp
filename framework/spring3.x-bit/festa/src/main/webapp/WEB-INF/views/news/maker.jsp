<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/" var="root"></c:url>
<c:url value="/resources/upload" var="upload"></c:url>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	var url = window.location.href;
	if (url.indexOf('maker') > 0) location.href='${root}empty';
	
	$('#editForm').on('submit', function(e) {
		var wrap = $('.feed_maker');
		
		var files = new FormData($('#editForm')[0]);
		console.log(files);
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url: '${root}news/edit',
			data: files,
			processData: false,
			contentType: false,
			cache: false,
			success: function() {
				wrap.hide();
				alertMsg('수정이 완료되었습니다.');
				openPop('alert', none, refresh);
			},
			error: function() { 
				alertMsg('올바른 방법으로 다시 시도해주세요.');
				openPop('alert');
			}
		});
		e.preventDefault();
	});
	function alertMsg(message) {
		$('#alert .pop_tit').text(message);
	}
</script>
<!-- #피드 수정하기 -->
<div class="feed_maker">
	<h3>피드 수정</h3>
	<c:set var="group" value="${edit.gpnum ne 0}" />
	<c:choose>
		<c:when test="${!group}">
			<c:set var="contentName" value="mpcontent" />
			<c:set var="feedContent" value="${edit.mpcontent}" />
			<c:set var="photoName" value="mpphoto" />
			<c:set var="feedImages" value="${edit.mpphoto}" />
			<c:set var="numName" value="mpnum" />
			<c:set var="feedNum" value="${edit.mpnum}" />
		</c:when>
		<c:otherwise>
			<c:set var="contentName" value="gpcontent" />
			<c:set var="feedContent" value="${edit.gpcontent}" />
			<c:set var="photoName" value="gpphoto" />
			<c:set var="feedImages" value="${edit.gpphoto}" />
			<c:set var="numName" value="gpnum" />
			<c:set var="feedNum" value="${edit.gpnum}" />
		</c:otherwise>
	</c:choose>
	<form class="maker_form" id="editForm" enctype="multipart/form-data">
		<input type="hidden" name="${numName}" value="${feedNum}">
		<div class="mk_cont box">
			<p class="pf_picture">
			<c:choose>
				<c:when test="${!empty edit.profile.prophoto}"><img src="${upload}/${edit.profile.prophoto}" alt="${edit.profile.proname}님의 프로필 썸네일" onload="squareTrim($(this), 55)"></c:when>
				<c:otherwise><img src="${root}resources/images/thumb/no_profile.png" alt="${edit.profile.proname}님의 프로필 썸네일" onload="squareTrim($(this), 55)"></c:otherwise>
			</c:choose>
			</p>
			<textarea name="${contentName}" placeholder="${edit.profile.proname} 님, 무슨 생각을 하고 계신가요?">${feedContent}</textarea>
		</div>
		<div class="file_thumbnail mk_thumb box">
			<ul>
				<c:set var="i" value="0"/>
				<c:forTokens items="${feedImages}" var="images" delims=",">
					<c:set var="i" value="${i+1}"/>
					<li class="ft_thumb">
						<input type="hidden" name="${photoName}" value="${images}"/>
						<input type="file" id="file${i}" name="files" accept="video/*, image/*" value="${upload}/${images}">
						<img src="${upload}/${images}" alt="">
						<button class="btn_cancle" type="button">
							<em class="snd_only">업로드 취소하기</em>
						</button>
						<label for="file${i}" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
					</li>
				</c:forTokens>
				<c:if test="${i lt 5}">
					<c:forEach begin="${i}" end="4">
						<c:set var="i" value="${i+1 }"/>
						<li class="ft_btn">
							<input type="file" id="file${i}" name="files" accept="video/*, image/*">
							<img src="" alt="">
							<button class="btn_cancle" type="button">
								<em class="snd_only">업로드 취소하기</em>
							</button>
							<label for="file${i}" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		<div class="mk_bottom box">
			<ul class="mk_tags">
				<li><input type="text" name="httitle1" value="${edit.httitle1}"></li>
				<li><input type="text" name="httitle2" value="${edit.httitle2}"></li>
				<li><input type="text" name="httitle3" value="${edit.httitle3}"></li>
			</ul>
			<ul class="mk_btns">
				<li>
					<label for="file1" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
				</li>
				<li>
					<button type="submit" class="btn_send"><em class="snd_only">피드 수정하기</em></button>
				</li>
			</ul>
		</div>
	</form>
</div>
<div id="alert" class="fstPop">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit"></p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
		</ul>
	</div>
</div>
<button type="button" id="close_btn" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	btnPop('btn_pop2');
	setFile();
</script>

</html>