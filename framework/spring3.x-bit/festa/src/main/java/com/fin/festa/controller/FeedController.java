package com.fin.festa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.entity.FeedVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.MyCommentVo;
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
	public String hotFeedSelectAll(HttpServletRequest req) {
		
		feedService.hotFeedSelectAll(req);
		return "hot/index";
	}

	//�� �α��ǵ� ���� (�˾�)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String feedUpdateOnePop(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		
		feedService.hotFeedUpdateOnePop(model, groupPostVo, myPostVo);
		return "hot/maker";
	}
	
	//�� �α��ǵ� ���� (�˾�>�˾� �� ���)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String feedUpdateOne(HttpServletRequest req, MyPostVo myPostVo, GroupPostVo groupPostVo, MultipartFile[] files) {
		
		feedService.hotFeedUpdateOne(req, groupPostVo, myPostVo, files);
		
		return "hot/index";
	}

	//�� �α��ǵ� ���� (�����˾� ���)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo, GroupPostVo groupPostVo) {
		
		feedService.hotFeedDeleteOne(model, groupPostVo, myPostVo);
		return "hot/index";
	}
	
	//�αⰳ���ǵ� ��� ������
	@RequestMapping(value = "myfeed/cmmt", method = RequestMethod.GET)
	public @ResponseBody List<MyCommentVo> myFeedCmmtMore(Model model, MyPostVo myPostVo){
		
		return feedService.myFeedCmmtMore(model, myPostVo);
	}
	
	//�α�׷��ǵ� ��� ������
	@RequestMapping(value = "groupfeed/cmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupCommentVo> groupFeedCmmtMore(Model model, GroupPostVo groupPostVo){
		
		return feedService.groupFeedCmmtMore(model, groupPostVo);
	}
	
	//�α��ǵ� ��� ���
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String hotFeedCmmtInsertOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		
		feedService.hotFeedCmmtInsertOne(model, groupCommentVo, myCommentVo);
		return "hot/index";
	}
	
	//�α��ǵ� ��� ���� (�����˾� ���)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String hotFeedCmmtDeleteOne(Model model, MyCommentVo myCommentVo, GroupCommentVo groupCommentVo){
		
		feedService.hotFeedCmmtDeleteOne(model, groupCommentVo, myCommentVo);
		return "hot/index";
	}
	
	//�α��ǵ� ���ƿ�
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String hotLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		
		feedService.hotLikeInsertOne(req, myGoodVo);
		return "hot/index";
	}
	
	//�α��ǵ� ���ƿ� ����
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String hotLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		
		feedService.hotLikeDeleteOne(req, myGoodVo);
		return "hot/index";
	}

	//�α��ǵ� �Ű� (�˾�)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String hotFeedReport(Model model, FeedVo feedVo){
		
		model.addAttribute("feedReport", feedVo);
		return "hot/report";
	}
	
	//�α��ǵ� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String hotFeedReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files){
		
		feedService.hotFeedReport(req, reportListVo, files);
		return "hot/index";
	}
	
	
}
