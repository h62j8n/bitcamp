package com.fin.festa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.service.FeedService;

@Controller
@RequestMapping("/hot/")
public class FeedController {

//////////////////////////////////////////////////////////////////////
//////////////////////////////  인기피드  /////////////////////////////
//////////////////////////////////////////////////////////////////////

	@Autowired
	private FeedService feedService;

	//인기피드 조회
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String hotFeedSelectAll(Model model) {
		return "hot/index";
	}

	//내 인기피드 수정 (팝업)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String feedUpdateOne() {
		return "hot/maker";
	}
	
	//내 인기피드 수정 (팝업>팝업 내 기능)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String feedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "hot/index";
	}

	//내 인기피드 삭제 (내부팝업 기능)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "hot/index";
	}
	
	//인기피드 댓글 등록
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String hotFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "hot/index";
	}
	
	//인기피드 댓글 삭제 (내부팝업 기능)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String hotFeedCmmtDeleteOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "hot/index";
	}
	
	//인기피드 좋아요
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "hot/index";
	}
	
	//인기피드 좋아요 해제
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "hot/index";
	}

	//인기피드 신고 (팝업)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String hotFeedReport(){
		return "hot/report";
	}
	
	//인기피드 신고 (팝업>팝업 내 기능)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String hotFeedReport(Model model, ReportListVo reportListVo){
		return "hot/index";
	}
	
	
}
