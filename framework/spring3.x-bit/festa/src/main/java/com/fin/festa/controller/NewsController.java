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
//////////////////////////////  �����ǵ�  /////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private NewsService newsService;
	
	//�����ǵ� ��ȸ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String newsFeedSelectAll(Model model, MyFollowingVo myFollowingVo){
		newsService.newsFeedSelectAll(model, myFollowingVo);
		return "news/index";
	}
	
	//�� �ǵ� ���� (�˾�)
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String feedUpdateOne() {
		return "news/maker";
	}
	
	//�� �ǵ� ���� (�˾�>�˾� �� ���)
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String feedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "news/index";
	}

	//�� �ǵ� ���� (�˾�>�����˾� ���)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "news/index";
	}
	
	//�����ǵ� ��� ���
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String newsFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo) {
		return "news/index";
	}
	
	//�����ǵ� ��� ���� (�����˾� ���)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String newsFeedCmmtDeleteOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "news/index";
	}
	
	//�����ǵ� ���ƿ�
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String newsLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "news/index";
	}
	
	//�����ǵ� ���ƿ� ����
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String newsLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "news/index";
	}

	//�����ǵ� �Ű� (�˾�)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String newsFeedReport(){
		return "news/report";
	}
	
	//�����ǵ� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String newsFeedReport(Model model, ReportListVo reportListVo){
		return "news/index";
	}
}
