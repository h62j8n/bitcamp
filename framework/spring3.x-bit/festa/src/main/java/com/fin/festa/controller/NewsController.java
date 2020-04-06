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
import com.fin.festa.service.NewsService;

@Controller
@RequestMapping("/news/")
public class NewsController {

//////////////////////////////////////////////////////////////////////
//////////////////////////////  뉴스피드  /////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private NewsService newsService;
	
	//뉴스피드 조회
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String newsFeedSelectAll(Model model, MyFollowingVo myFollowingVo){
		newsService.newsFeedSelectAll(model, myFollowingVo);
		return "news/index";
	}
	
	//내 피드 수정 (팝업)
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String feedUpdateOne() {
		return "news/maker";
	}
	
	//내 피드 수정 (팝업>팝업 내 기능)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String feedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "news/index";
	}

	//내 피드 삭제 (팝업>내부팝업 기능)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "news/index";
	}
	
	//뉴스피드 댓글 등록
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String newsFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		return "news/index";
	}
	
	//뉴스피드 댓글 삭제 (내부팝업 기능)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String newsFeedCmmtDeleteOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "news/index";
	}
	
	//뉴스피드 좋아요
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String newsLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "news/index";
	}
	
	//뉴스피드 좋아요 해제
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String newsLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "news/index";
	}

	//뉴스피드 신고 (팝업)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String newsFeedReport(){
		return "news/report";
	}
	
	//뉴스피드 신고 (팝업>팝업 내 기능)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String newsFeedReport(Model model, ReportListVo reportListVo){
		return "news/index";
	}
}
