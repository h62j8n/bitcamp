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
//////////////////////////////  �α��ǵ�  /////////////////////////////
//////////////////////////////////////////////////////////////////////

	@Autowired
	private FeedService feedService;

	//�α��ǵ� ��ȸ
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String hotFeedSelectAll(Model model) {
		return "hot/index";
	}

	//�� �α��ǵ� ���� (�˾�)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String feedUpdateOne() {
		return "hot/maker";
	}
	
	//�� �α��ǵ� ���� (�˾�>�˾� �� ���)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String feedUpdateOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "hot/index";
	}

	//�� �α��ǵ� ���� (�����˾� ���)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		return "hot/index";
	}
	
	//�α��ǵ� ��� ���
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String hotFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "hot/index";
	}
	
	//�α��ǵ� ��� ���� (�����˾� ���)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String hotFeedCmmtDeleteOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		return "hot/index";
	}
	
	//�α��ǵ� ���ƿ�
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "hot/index";
	}
	
	//�α��ǵ� ���ƿ� ����
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "hot/index";
	}

	//�α��ǵ� �Ű� (�˾�)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String hotFeedReport(){
		return "hot/report";
	}
	
	//�α��ǵ� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String hotFeedReport(Model model, ReportListVo reportListVo){
		return "hot/index";
	}
	
	
}
