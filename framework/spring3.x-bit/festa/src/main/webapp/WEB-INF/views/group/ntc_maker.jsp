<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<!-- #피드 수정하기 -->
<div class="feed_maker">
	<h3>피드 만들기</h3>
	<form class="maker_form">
		<!-- 그룹페이지일 경우 공지 {
		<p class="mk_noti">
			<input type="checkbox" class="comm_chk" id="festaNt" name="">
			<label for="festaNt">공지</label>
		</p>
		} 그룹페이지일 경우 공지 -->
			<div class="mk_cont box">
			<p class="pf_picture">
				<img src="http://placehold.it/55x55" alt="김덕수님의 프로필 썸네일">
			</p>
			<textarea id="" name="" placeholder="김덕수 님, 무슨 생각을 하고 계신가요?"></textarea>
		</div>
		<div class="file_thumbnail mk_thumb box">
			<ul>
				<!-- <li>
					<input type="file" id="festaFl3" name="festaFiles" accept="video/*, image/*" multiple="multiple">
					<label for="festaFl3" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
					<img src="http://placehold.it/80x80" alt="">
					<button class="btn_cancle" type="button"><em class="snd_only">업로드 취소하기</em></button>
				</li> -->
				<li>
					<input type="file" id="festaFl2" name="festaFiles" accept="video/*, image/*" multiple="multiple">
					<label for="festaFl2" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
				</li>
			</ul>
		</div>
		<div class="mk_bottom box">
			<ul class="mk_tags">
				<li><input type="text" id="" name=""></li>
				<li><input type="text" id="" name=""></li>
				<li><input type="text" id="" name=""></li>
			</ul>
			<ul class="mk_btns">
				<li>
					<input type="file" id="festaFl1" name="festafiles" accept="video/*, image/*" multiple="multiple">
					<label for="festaFl1" class="btn_file"><em class="snd_only">사진/동영상 업로드하기</em></label>
				</li>
				<li>
					<button type="submit" class="btn_send"><em class="snd_only">피드 게시하기</em></button>
				</li>
			</ul>
		</div>
	</form>
</div>
<div class="fstPop pop2">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit">수정이 완료되었습니다.</p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close comm_btn cfm">확인</button></li>
		</ul>
	</div>
</div>
<button type="button" class="btn_close"><em class="snd_only">창 닫기</em></button>
<script type="text/javascript">
	btnPop('btn_pop2');
	fileThumbnail();
</script>
