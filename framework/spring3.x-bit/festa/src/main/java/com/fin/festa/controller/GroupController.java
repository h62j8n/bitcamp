package com.fin.festa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.service.GroupService;

@Controller
@RequestMapping("/group/")
public class GroupController {

//////////////////////////////////////////////////////////////////////
///////////////////////////////�׷� ����///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private GroupService groupService;
	
	int result=0;
	
	//�׷� �ǵ� (���Խ�û, ���Դ��, �׷�� 3����)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String groupSelectOne(HttpServletRequest req, UpdateWaitVo updateWaitVo){
		
		result=groupService.joinGroup(req, updateWaitVo);
		System.out.println(result);
		GroupVo group=new GroupVo();
		group.setGrnum(updateWaitVo.getGrnum());
		groupService.groupSelectOne(req, group);
		if(result == 0) {
			return "redirect:/group/readme?grnum="+group.getGrnum()+"&pronum="+updateWaitVo.getPronum();
		} else if (result == 1){
			return "redirect:/group/standby?grnum="+group.getGrnum()+"&pronum="+updateWaitVo.getPronum();
		} else if (result == 2) {
			return "group/index";
		}
		return "group/index";
	}

	//�׷� ���� �ȳ�
	@RequestMapping(value = "readme", method = RequestMethod.GET)
	public String readme(HttpServletRequest req) {
		GroupVo groupVo=new GroupVo();
		groupVo.setGrnum(Integer.parseInt(req.getParameter("grnum")));
		groupService.groupSelectOne(req, groupVo);
		return "group/readme";
	}
	
	//�׷� ���� ��û ���
	@RequestMapping(value = "standby", method = RequestMethod.GET)
	public String standby(HttpServletRequest req) {
		GroupVo groupVo=new GroupVo();
		groupVo.setGrnum(Integer.parseInt(req.getParameter("grnum")));
		groupService.groupSelectOne(req, groupVo);
		/*
		 * UpdateWaitVo updateWaitVo=new UpdateWaitVo();
		 * updateWaitVo.setGrnum(Integer.parseInt(req.getParameter("grnum")));
		 * updateWaitVo.setPronum(Integer.parseInt(req.getParameter("pronum")));
		 * result=groupService.joinGroup(req, updateWaitVo);
		 * groupService.groupSelectOne(req, groupVo);
		 */
		
		return "group/standby";
	}
	
	//�׷� ���� ��û (�˾�)
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinGroup() {
		return "group/join";
	}
	
	//�׷� ���� ��û �Ϸ� (�˾�>�˾� �� ���)
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinGroup(Model model, UpdateWaitVo updateWaitVo) {
		groupService.groupAdmission(model, updateWaitVo);
		result=1;
		return "redirect:/group/standby?grnum="+updateWaitVo.getGrnum();
	}
	
	//�׷�� ��� (�˾�)
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String groupMemberList(HttpServletRequest req, GroupVo groupVo){
		groupService.groupMemberList(req, groupVo);
		return "group/member";
	}
	
	//�׷�� ����Ʈ �ȷο� (�˾�>�˾� �� ���)
	@RequestMapping(value = "follow", method = RequestMethod.POST)
	public String followInsertOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		groupService.followInsertOne(req, myFollowingVo);
		return "group/member";
	}

	//�׷�� ����Ʈ �ȷο� ��� (�˾�>�˾� �� ���)
	@RequestMapping(value = "unfollow", method = RequestMethod.POST)
	public String followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		groupService.followDeleteOne(req, myFollowingVo);
		return "group/member";
	}
	
	//�׷� �Ű� (�˾�)
	@RequestMapping(value = "gp_report", method = RequestMethod.GET)
	public String groupReport(){
		return "group/report";
	}
		
	//�׷� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "gr_report", method = RequestMethod.POST)
	public String groupReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files){
		groupService.groupReport(req, reportListVo, files);
		return "group/index";
	}
	
	//�׷� Ż�� (�����˾� ���)
	@RequestMapping(value = "out", method = RequestMethod.POST)
	public String groupOut(HttpServletRequest req, JoinGroupVo joinGroupVo, GroupVo groupVo){
		groupService.groupOut(req, joinGroupVo, groupVo);
		result=0;
		return "group/index";
	}
	
	//�������� ������ (�˾�)
	@RequestMapping(value = "ntc_feed", method = RequestMethod.GET)
	public String noticeSelectOne(HttpServletRequest req, GroupNoticeVo groupNoticeVo){
		groupService.noticeSelectOne(req, groupNoticeVo);
		return "group/ntc_feed";
	}
	
	//�������� ���� (�˾�>�˾�)
	@RequestMapping(value = "ntc_maker", method = RequestMethod.GET)
	public String noticeUpdateOne(){
		return "group/ntc_maker";
	}
	
	//�������� ���� �Ϸ� (�˾�>�˾�>�˾� �� ���)
	@RequestMapping(value = "ntc_maker", method = RequestMethod.POST)
	public String noticeUpdateOne(Model model, GroupNoticeVo groupNoticeVo){
		return "group/ntc_feed";
	}
	
	//�������� ���� (�˾�>�����˾� ���)
	@RequestMapping(value = "ntc_feed/del", method = RequestMethod.POST)
	public String noticeDeleteOne(Model model, GroupNoticeVo groupNoticeVo){
		groupService.noticeDeleteOne(model, groupNoticeVo);
		return "group/index";
	}
	
	//�������� ��� ��� (�˾�>�˾� �� ���)
	@RequestMapping(value = "ntc_feed/cmmtadd", method = RequestMethod.POST)
	public String noticeCmmtInsertOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo){
		groupService.noticeCmmtInsertOne(req, groupNoticeCommentVo);
		return "group/ntc_feed";
	}
	
	//�������� ��� ���� (�˾�>�����˾� ���)
	@RequestMapping(value = "ntc_feed/cmmtdel", method = RequestMethod.POST)
	public String noticeCmmtDeleteOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo){
		groupService.noticeCmmtDeleteOne(req, groupNoticeCommentVo);
		return "group/ntc_feed";
	}
	
	//�������� �Ű� (�˾�>�˾�)
	@RequestMapping(value = "ntc_report", method = RequestMethod.GET)
	public String noticeReport(Model model, GroupNoticeVo groupNoticeVo){
		model.addAttribute("groupNotice", groupNoticeVo);
		return "group/ntc_report";
	}
	
	//�������� �Ű� (�˾�>�˾�>�˾� �� ���)
	@RequestMapping(value = "ntc_report", method = RequestMethod.POST)
	public String noticeReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files){
		groupService.noticeReport(req, reportListVo, files);
		return "group/ntc_feed";
	}

	//�������� �Է�
	@RequestMapping(value = "noticeadd", method = RequestMethod.POST)
	public String noticeInsertOne(HttpServletRequest req, MultipartFile[] files, GroupNoticeVo groupNoticeVo, GroupVo groupVo){
		groupService.noticeInsertOne(req, files, groupNoticeVo);
		groupVo.setGrnum(groupNoticeVo.getGrnum());
		groupService.groupSelectOne(req, groupVo);
		return "redirect:/group/?grnum="+groupVo.getGrnum()+"&pronum="+groupVo.getPronum();
	}
	
	//�׷� �ǵ� �Է�
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String groupFeedInsertOne(HttpServletRequest req, MultipartFile[] files, GroupPostVo groupPostVo){
		groupService.groupFeedInsertOne(req, files, groupPostVo);
		GroupVo group=new GroupVo();
		group.setGrnum(groupPostVo.getGrnum());
		groupService.groupSelectOne(req, group);
		return "redirect:/group/?grnum="+group.getGrnum()+"&pronum="+groupPostVo.getPronum();
	}
	
	//�׷� �ǵ� ���� (�˾�)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String groupFeedUpdateOne(){
		return "group/maker";
	}
	
	//�׷� �ǵ� ���� �Ϸ� (�˾�>�˾� �� ���)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String groupFeedUpdateOne(Model model, GroupPostVo groupPostVo){
		return "group/index";
	}

	//�׷� �ǵ� ���� (�˾�>�����˾� ���)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String groupFeedDeleteOne(Model model, GroupPostVo groupPostVo){
		groupService.groupFeedDeleteOne(model, groupPostVo);
		return "group/index";
	}
	
	//�׷� �ǵ� ��� �Է�
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String groupFeedCmmtInsertOne(HttpServletRequest req, GroupCommentVo groupCommentVo){
		groupService.groupFeedCmmtInsertOne(req, groupCommentVo);
		return "group/index";
	}
	
	//�׷� �ǵ� ��� ���� (�����˾� ���)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String groupFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo){
		groupService.groupFeedCmmtDeleteOne(model, groupCommentVo);
		return "group/index";
	}
	
	//�׷��ǵ��� ������ �񵿱�
	@RequestMapping(value = "cmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupCommentVo> GroupDetailCmmt(Model model, GroupPostVo grouppost){
		return groupService.groupDetailCmmt(model, grouppost);
	}

	//�׷������� ������ �񵿱�
	@RequestMapping(value = "ntc_feed/ntccmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupNoticeCommentVo> GroupNoticeDetailCmmt(Model model, GroupNoticeVo groupnotice){
		return groupService.groupNoticeDetailCmmt(model, groupnotice);
	}
	
	//�׷� �ǵ� ���ƿ�
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String FeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "group/index";
	}
	
	//�׷� �ǵ� ���ƿ� ����
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String FeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "group/index";
	}
	
	//�׷� �ǵ� �Ű� (�˾�)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String groupFeedReport(Model model, GroupPostVo groupPostVo){
		model.addAttribute("groupFeed", groupPostVo);
		return "group/gp_report";
	}

	//�׷� �ǵ� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String groupFeedReport(HttpServletRequest req, ReportListVo reportListVo, MultipartFile[] files){
		groupService.groupFeedReport(req, reportListVo, files);
		return "group/gp_report";
	}

	//�׷� ä�� (��â & ���� �۾�����)
	@RequestMapping(value = "chat", method = RequestMethod.GET)
	public String groupChat(){
		return "group/chat";
	}
	
	//�׷� ä�� (��â & ���� �۾�����)
	@RequestMapping(value = "chat/chatSubmitServlet", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String	 chatName = request.getParameter("chatName");
		String chatContent = request.getParameter("chatContent");
		if(chatContent.equals("")) {
			chatContent=null;
		}
		PrintWriter out=response.getWriter();
		int result=0;
		if(chatContent==null) {
			out.print(result);
		} else {
			//out.print(result=new ChatDao().submit(chatName, chatContent));
		}
		return "group/chat";
	}

//////////////////////////////////////////////////////////////////////
///////////////////////////////�׷� ����///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	//�׷� ����
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String groupAdminSelectOne(HttpServletRequest req, GroupVo groupVo){
		groupService.groupSelectOne(req, groupVo);
		return "group/profile";
	}
	
	//�׷� ����
	@RequestMapping(value = "profile/edit", method = RequestMethod.POST)
	public String groupAdminUpdateOne(HttpServletRequest req, GroupVo groupVo){
		groupService.groupAdminUpdateOne(req, groupVo);
		groupService.groupSelectOne(req, groupVo);
		return "redirect:/group/profile?grnum="+groupVo.getGrnum();
	}
	
	//�׷�� ����
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String groupUserAdminSelectAll(HttpServletRequest req, GroupVo groupVo , PageSearchVo pageSearchVo){
		groupService.groupSelectOne(req, groupVo);
		groupService.groupUserAdminSelectAll(req, groupVo, pageSearchVo);
		return "group/user";
	}
	
	//�׷�� �߹� (�����˾� ���)
	@RequestMapping(value = "user/kick", method = RequestMethod.POST)
	public String groupUserKick(HttpServletRequest req, JoinGroupVo joinGroupVo, GroupVo groupVo){
		groupService.groupUserKick(req, groupVo, joinGroupVo);
		return "group/user";
	}
	
	//�׷�� ��ü �߹� (�����˾� ���)
	@RequestMapping(value = "user/allkick", method = RequestMethod.POST)
	public String groupUserAllKick(HttpServletRequest req, GroupVo groupVo){
		groupService.groupUserAllKick(req, groupVo);
		return "group/user";
	}
	
	//�׷� ��û ���
	@RequestMapping(value = "req", method = RequestMethod.GET)
	public String groupRequestSelectAll(HttpServletRequest req, GroupVo groupVo, PageSearchVo pageSearchVo){
		groupService.groupSelectOne(req, groupVo);
		groupService.groupRequestSelectAll(req, groupVo, pageSearchVo);
		return "group/req";
	}
	
	//�׷� ��û ���� (�����˾� ���)
	@RequestMapping(value = "req/hello", method = RequestMethod.POST)
	public String groupRequestHello(HttpServletRequest req, UpdateWaitVo updateWaitVo, GroupVo groupVo){
		groupService.groupRequestHello(req, updateWaitVo, groupVo);
		return "group/req";
	}
	
	//�׷� ��û ���� (�����˾� ���)
	@RequestMapping(value = "req/sorry", method = RequestMethod.POST)
	public String groupRequestSorry(HttpServletRequest req, UpdateWaitVo updateWaitVo, GroupVo groupVo){
		groupService.groupRequestSorry(req, updateWaitVo, groupVo);
		return "group/req";
	}
	
	//�׷� ���� (�����˾� ���)
	@RequestMapping(value = "profile/del", method = RequestMethod.POST)
	public String groupDeleteOne(HttpServletRequest req, GroupVo groupVo){
		groupService.groupDeleteOne(req, groupVo);
		return "user/index";
	}
}
