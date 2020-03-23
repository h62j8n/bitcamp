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
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.service.SearchService;

@Controller
@RequestMapping("/search/")
public class SearchController {
	
//////////////////////////////////////////////////////////////////////
///////////////////////////////�˻� ����///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private SearchService searchService;

	//�˻� ���
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String search(Model model, PageSearchVo pageSearchVo) {
		return "search/index";
	}
	
	//�˻� ��� �ǵ� ��(�˾�)
	@RequestMapping(value="feed", method = RequestMethod.GET)
	public String searchFeedDetail(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "search/feed";
	}
	
	//�˻� ��� �ǵ� ����(�˾�>�˾�)
	@RequestMapping(value="feed/maker", method = RequestMethod.GET)
	public String searchFeedUpdateOne() {
		return "search/maker";
	}
	
	//�˻� ��� �ǵ� ����(�˾�>�˾�>�˾� �� ���)
	@RequestMapping(value="feed/maker", method = RequestMethod.POST)
	public String searchFeedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "search/feed";
	}
	
	//�˻� ��� �ǵ� ����(�˾�>�����˾� ���)
	@RequestMapping(value="feed/del", method = RequestMethod.POST)
	public String searchFeedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "search/index";
	}
	
	//�˻� ��� �ǵ� ��� ���(�˾�>�˾� �� ���)
	@RequestMapping(value = "feed/cmmtadd", method = RequestMethod.POST)
	public String searchFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "search/feed";
	}
	
	//�˻� ��� �ǵ� ��� ����(�˾�>�����˾� ���)
	@RequestMapping(value = "feed/cmmtdel", method = RequestMethod.POST)
	public String searchFeedCmmtDeletetOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "search/feed";
	}

	//�˻� ��� �ǵ� ���ƿ�(�˾�>�˾� �� ���)
	@RequestMapping(value = "feed/likeadd", method = RequestMethod.POST)
	public String searchFeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "search/feed";
	}
	
	//�˻� ��� �ǵ� ���ƿ� ���(�˾�>�˾� �� ���)
	@RequestMapping(value = "feed/likedel", method = RequestMethod.POST)
	public String searchFeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "search/feed";
	}

	//�˻� ��� �ǵ� �Ű�(�˾�)
	@RequestMapping(value="feed/report", method = RequestMethod.GET)
	public String searchFeedReport() {
		return "search/report";
	}

	//�˻� ��� �ǵ� �Ű�(�˾�>�˾� �� ���)
	@RequestMapping(value="feed/report", method = RequestMethod.POST)
	public String searchFeedReport(Model model, ReportListVo reportListVo) {
		return "search/feed";
	}
}
