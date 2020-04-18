<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root"></c:url>
<c:url value="/resources/upload" var="upload"></c:url>
<!DOCTYPE html>
<!-- #피드 수정하기 -->
<script type="text/javascript">
	$('.maker_form').on('submit', function(e){
		e.preventDefault();
	});
</script>
<div id="ntcmaker" class="feed_maker">
	<h3>공지사항 수정하기</h3>
	<form class="maker_form" id="ntcupdate_feed" enctype="multipart/form-data">
		<input type="hidden" name="gnnum" value="${ntcDetail.gnnum }"/>
		<div class="mk_cont box">
			<p class="pf_picture">
				<c:choose>
					<c:when test="${login.prophoto eq null }">
						<img src="http://placehold.it/55x55" alt="${login.proname }님의 프로필 썸네일">
					</c:when>
					<c:otherwise>
						<img src="${upload }/${login.prophoto}" alt="${login.proname }님의 프로필 썸네일">					
					</c:otherwise>
				</c:choose>
			</p>
			<textarea id="gpcontent1" name="gncontent" placeholder="${login.proname } 님, 무슨 생각을 하고 계신가요?" required="required" >${ntcDetail.gncontent}</textarea>
		</div>
		<div class="file_thumbnail mk_thumb box" style="display: block">
			<ul>
				<c:set var="count" value="0" />
				<c:forTokens items="${ntcDetail.gnphoto }" delims="," var="item">
					<c:set var="count" value="${count+1 }" />
					<li class="ft_thumb">
						<input type="hidden" id="gnphoto${count }" name="gnphoto" value="${item }" />
						<input type="file" id="file1_${count }" name="filess" accept="video/*, image/*" value="${item}" /> 
						<img src="${upload }/${item}" alt="">
						<button class="btn_cancle" id="btn_gnphoto${count }" type="button">
							<em class="snd_only">업로드 취소하기</em>
						</button> <label for="file1_${count }" class="btn_file">
							<em	class="snd_only">사진/동영상 업로드하기</em>
						</label>
					</li>
				</c:forTokens>
				<c:forEach begin="${count }" end="4">
				<c:set var="count" value="${count+1 }" />
					<li class="ft_btn"><input type="file"
						id="file1_${count }" name="filess" accept="video/*, image/*" /> <img
						src="" alt="">
						<button class="btn_cancle" type="button">
							<em class="snd_only">업로드 취소하기</em>
						</button> <label for="file1_${count }" class="btn_file"><em
							class="snd_only">사진/동영상 업로드하기</em></label></li>
				</c:forEach>
			</ul>
		</div>
		<div class="mk_bottom box">
			<ul class="mk_btns">
				<li>
					<label for="file1_1" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
				</li>
				<li>
					<button type="submit" class="btn_send" id="ntcupdate" name="feedUpdate"><em class="snd_only">피드 수정하기</em></button>
				</li>
			</ul>
		</div>
	</form>
</div>	
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	setFile();
</script>
