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

import com.fin.festa.model.GroupDao;
import com.fin.festa.model.MemberDaoImpl;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.JoinGroupVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.service.AdminService;
import com.fin.festa.service.GroupService;
import com.fin.festa.service.GroupServiceImpl;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Controller
@RequestMapping("/group/")
public class GroupController {

//////////////////////////////////////////////////////////////////////
///////////////////////////////그룹 관련///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private GroupService groupService;
	
	//그룹 피드 (가입신청, 가입대기, 그룹원 3가지)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String groupSelectOne(HttpServletRequest req, UpdateWaitVo updateWaitVo){
		
		int result=groupService.joinGroup(req, updateWaitVo);
		GroupVo group=new GroupVo();
		group.setGrnum(updateWaitVo.getGrnum());
		groupService.groupSelectOne(req, group);
		if(result == 0) {
			return "group/readme";
		} else if (result == 1){
			return "group/standby";
		} else if (result == 2) {
			return "group/index";
		}
		
		return "group/index";
	}
	
	//그룹 가입 신청 (팝업)
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinGroup() {
		return "group/join";
	}
	
	//그룹 가입 신청 완료 (팝업>팝업 내 기능)
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinGroup(Model model, UpdateWaitVo updateWaitVo) {
		return "group/index";
	}
	
	//그룹원 목록 (팝업)
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public String groupMemberList(HttpServletRequest req, GroupVo groupVo){
		groupService.groupMemberList(req, groupVo);
		return "group/member";
	}
	
	//그룹원 리스트 팔로우 (팝업>팝업 내 기능)
	@RequestMapping(value = "follow", method = RequestMethod.POST)
	public String followInsertOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		return "group/member";
	}
	
	//그룹원 리스트 팔로우 취소 (팝업>팝업 내 기능)
	@RequestMapping(value = "unfollow", method = RequestMethod.POST)
	public String followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		return "group/member";
	}
	
	//그룹 신고 (팝업)
	@RequestMapping(value = "gp_report", method = RequestMethod.GET)
	public String groupReport(){
		return "group/gp_report";
	}
	
	//그룹 신고 (팝업>팝업 내 기능)
	@RequestMapping(value = "gr_report", method = RequestMethod.POST)
	public String groupReport(Model model, ReportListVo reportListVo){
		return "group/index";
	}

	//그룹 탈퇴 (팝업)
	@RequestMapping(value = "out", method = RequestMethod.GET)
	public String groupOut(){
		return "group/out";
	}
	
	//그룹 탈퇴 (팝업>팝업 내 기능)
	@RequestMapping(value = "out", method = RequestMethod.POST)
	public String groupOut(Model model, JoinGroupVo joinGroupVo){
		return "group/index";
	}
	
	//공지사항 디테일 (팝업)
	@RequestMapping(value = "ntc_feed", method = RequestMethod.GET)
	public String noticeSelectOne(HttpServletRequest req, GroupNoticeVo groupNoticeVo){
		groupService.noticeSelectOne(req, groupNoticeVo);
		return "group/ntc_feed";
	}
	
	//공지사항 수정 (팝업>팝업)
	@RequestMapping(value = "ntc_maker", method = RequestMethod.GET)
	public String noticeUpdateOne(){
		return "group/ntc_maker";
	}
	
	//공지사항 수정 완료 (팝업>팝업>팝업 내 기능)
	@RequestMapping(value = "ntc_maker", method = RequestMethod.POST)
	public String noticeUpdateOne(Model model, GroupNoticeVo groupNoticeVo){
		return "group/ntc_feed";
	}
	
	//공지사항 삭제 (팝업>내부팝업 기능)
	@RequestMapping(value = "ntc_feed/del", method = RequestMethod.POST)
	public String noticeDeleteOne(Model model, GroupNoticeVo groupNoticeVo){
		groupService.noticeDeleteOne(model, groupNoticeVo);
		return "group/index";
	}
	
	//공지사항 댓글 등록 (팝업>팝업 내 기능)
	@RequestMapping(value = "ntc_feed/cmmtadd", method = RequestMethod.POST)
	public String noticeCmmtInsertOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo){
		groupService.noticeCmmtInsertOne(req, groupNoticeCommentVo);
		return "group/ntc_feed";
	}
	
	//공지사항 댓글 삭제 (팝업>내부팝업 기능)
	@RequestMapping(value = "ntc_feed/cmmtdel", method = RequestMethod.POST)
	public String noticeCmmtDeleteOne(HttpServletRequest req, GroupNoticeCommentVo groupNoticeCommentVo){
		groupService.noticeCmmtDeleteOne(req, groupNoticeCommentVo);
		return "group/ntc_feed";
	}
	
	//공지사항 신고 (팝업>팝업)
	@RequestMapping(value = "ntc_report", method = RequestMethod.GET)
	public String noticeReport(){
		return "group/ntc_report";
	}
	
	//공지사항 신고 (팝업>팝업>팝업 내 기능)
	@RequestMapping(value = "ntc_report", method = RequestMethod.POST)
	public String noticeReport(Model model, ReportListVo reportListVo){
		return "group/ntc_feed";
	}

	//공지사항 입력
	@RequestMapping(value = "noticeadd", method = RequestMethod.POST)
	public String noticeInsertOne(HttpServletRequest req, MultipartFile[] files, GroupNoticeVo groupNoticeVo, GroupVo groupVo){
		groupService.noticeInsertOne(req, files, groupNoticeVo);
		groupVo.setGrnum(groupNoticeVo.getGrnum());
		groupService.groupSelectOne(req, groupVo);
		return "redirect:/group/?grnum="+groupVo.getGrnum()+"&pronum="+groupVo.getPronum();
	}
	
	//그룹 피드 입력
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String groupFeedInsertOne(HttpServletRequest req, MultipartFile[] files, GroupPostVo groupPostVo){
		groupService.groupFeedInsertOne(req, files, groupPostVo);
		GroupVo group=new GroupVo();
		group.setGrnum(groupPostVo.getGrnum());
		groupService.groupSelectOne(req, group);
		return "redirect:/group/?grnum="+group.getGrnum()+"&pronum="+groupPostVo.getPronum();
	}
	
	//그룹 피드 수정 (팝업)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String groupFeedUpdateOne(){
		return "group/maker";
	}
	
	//그룹 피드 수정 완료 (팝업>팝업 내 기능)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String groupFeedUpdateOne(Model model, GroupPostVo groupPostVo){
		return "group/index";
	}

	//그룹 피드 삭제 (팝업>내부팝업 기능)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String groupFeedDeleteOne(Model model, GroupPostVo groupPostVo){
		groupService.groupFeedDeleteOne(model, groupPostVo);
		return "group/index";
	}
	
	//그룹 피드 댓글 입력
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String groupFeedCmmtInsertOne(HttpServletRequest req, GroupCommentVo groupCommentVo){
		groupService.groupFeedCmmtInsertOne(req, groupCommentVo);
		return "group/index";
	}
	
	//그룹 피드 댓글 삭제 (내부팝업 기능)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String groupFeedCmmtDeleteOne(Model model, GroupCommentVo groupCommentVo){
		groupService.groupFeedCmmtDeleteOne(model, groupCommentVo);
		return "group/index";
	}
	
	//그룹피드댓글 더보기 비동기
	@RequestMapping(value = "cmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupCommentVo> GroupDetailCmmt(Model model, GroupPostVo grouppost){
		return groupService.groupDetailCmmt(model, grouppost);
	}

	//그룹공지댓글 더보기 비동기
	@RequestMapping(value = "ntc_feed/ntccmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupNoticeCommentVo> GroupNoticeDetailCmmt(Model model, GroupNoticeVo groupnotice){
		return groupService.groupNoticeDetailCmmt(model, groupnotice);
	}
	
	//그룹 피드 좋아요
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String FeedLikeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "group/index";
	}
	
	//그룹 피드 좋아요 해제
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String FeedLikeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo){
		return "group/index";
	}
	
	//그룹 피드 신고 (팝업)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String groupFeedReport(){
		return "group/gp_report";
	}

	//그룹 피드 신고 (팝업>팝업 내 기능)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String groupFeedReport(Model model, ReportListVo reportListVo){
		return "group/gp_report";
	}

	//그룹 채팅 (새창 & 아직 작업보류)
	@RequestMapping(value = "chat", method = RequestMethod.GET)
	public String groupChat(){
		return "group/chat";
	}
	
	//그룹 채팅 (새창 & 아직 작업보류)
	@RequestMapping(value = "chat/chatSubmitServlet", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String chatName = request.getParameter("chatName");
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
///////////////////////////////그룹 세팅///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	//그룹 관리
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String groupAdminSelectOne(HttpServletRequest req, GroupVo groupVo){
		groupService.groupSelectOne(req, groupVo);
		return "group/profile";
	}
	
	//그룹 수정
	@RequestMapping(value = "profile/edit", method = RequestMethod.POST)
	public String groupAdminUpdateOne(HttpServletRequest req, GroupVo groupVo){
		groupService.groupAdminUpdateOne(req, groupVo);
		groupService.groupSelectOne(req, groupVo);
		return "redirect:/group/profile?grnum="+groupVo.getGrnum();
	}
	
	//그룹원 관리
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String groupUserAdminSelectAll(Model model, GroupVo groupVo){
		return "group/user";
	}
	
	//그룹원 추방 (내부팝업 기능)
	@RequestMapping(value = "user/kick", method = RequestMethod.POST)
	public String groupUserKick(Model model, JoinGroupVo joinGroupVo){
		return "group/user";
	}
	
	//그룹원 전체 추방 (내부팝업 기능)
	@RequestMapping(value = "user/allkick", method = RequestMethod.POST)
	public String groupUserAllKick(Model model, GroupVo groupVo){
		return "group/user";
	}
	
	//그룹 신청 목록
	@RequestMapping(value = "req", method = RequestMethod.GET)
	public String groupRequestSelectAll(Model model, GroupVo groupVo){
		return "group/req";
	}
	
	//그룹 신청 승인 (내부팝업 기능)
	@RequestMapping(value = "req/hello", method = RequestMethod.POST)
	public String groupRequestHello(Model model, UpdateWaitVo updateWaitVo){
		return "group/req";
	}
	
	//그룹 신청 전체 승인 (내부팝업 기능)
	@RequestMapping(value = "req/allhello", method = RequestMethod.POST)
	public String groupRequestEverybodyHello(Model model, UpdateWaitVo updateWaitVo){
		return "group/req";
	}
	
	//그룹 신청 거절 (내부팝업 기능)
	@RequestMapping(value = "req/sorry", method = RequestMethod.POST)
	public String groupRequestSorry(Model model, UpdateWaitVo updateWaitVo){
		return "group/req";
	}
	
	//그룹 신청 전체 거절 (내부팝업 기능)
	@RequestMapping(value = "req/allsorry", method = RequestMethod.POST)
	public String groupRequestVeryverySorry(Model model, UpdateWaitVo updateWaitVo){
		return "group/req";
	}

	//그룹 삭제 (팝업)
	@RequestMapping(value = "profile/del", method = RequestMethod.GET)
	public String groupDeleteOne(){
		return "user/index";
	}
	
	//그룹 삭제 (팝업>팝업 내 기능)
	@RequestMapping(value = "profile/del", method = RequestMethod.POST)
	public String groupDeleteOne(Model model, GroupVo groupVo){
		return "user/index";
	}
}
