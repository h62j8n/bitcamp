package com.fin.festa.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.festa.model.entity.CampReviewVo;
import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupCommentVo;
import com.fin.festa.model.entity.GroupNoticeCommentVo;
import com.fin.festa.model.entity.GroupNoticeVo;
import com.fin.festa.model.entity.GroupPostVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.PageSearchVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.service.AdminService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

//////////////////////////////////////////////////////////////////////
//////////////////////////////������ ����//////////////////////////////
//////////////////////////////////////////////////////////////////////

	@Autowired
	private AdminService adminService;

	//���� ��ú���
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String adminDashBoard(Model model) {
		adminService.adminDashBoard(model);
		return "admin/index";
	}
	
	//�׷� ����
	@RequestMapping(value = "group", method = RequestMethod.GET)
	public String adminGroupSelectAll(Model model, PageSearchVo pageSearchVo) {
		adminService.adminGroupSelectAll(model, pageSearchVo);
		return "admin/group/index";
	}

	//�׷� ���� (�����˾� ���)
	@RequestMapping(value = "group/del", method = RequestMethod.POST)
	public String adminGroupDeleteOne(Model model, GroupVo groupVo) {
		
		adminService.adminGroupDeleteOne(model, groupVo);
		return "admin/group/index";
	}
	
	//�׷� ������ (��â)
	@RequestMapping(value = "group/detail", method = RequestMethod.GET)
	public String adminGroupDetail(Model model, GroupVo groupVo) {
		
		adminService.adminGroupDetail(model, groupVo);
		return "admin/group/detail";
	}
	
	//�׷��ǵ��� ������ �񵿱�
	@RequestMapping(value = "group/detail/cmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupCommentVo> adminGroupDetailCmmt(Model model, GroupPostVo grouppost){
		
		return adminService.adminGroupDetailCmmt(model, grouppost);
	}
		
	//�׷� �������� �� (��â>�˾�)
	@RequestMapping(value = "group/detail/ntc_feed", method = RequestMethod.GET)
	public String adminGroupDetailNotice(Model model, GroupNoticeVo grroupnoticeVo) {
		
		adminService.adminGroupDetailNotice(model, grroupnoticeVo);
		return "admin/group/feed";		
	}
	
	//�׷�����ǵ��� ������ �񵿱�
	@RequestMapping(value = "group/detail/notice/cmmt", method = RequestMethod.GET)
	public @ResponseBody List<GroupNoticeCommentVo> adminGroupDetailCmmt(Model model, GroupNoticeVo groupNoticeVo){
		
		return adminService.adminGroupNoticeCmmt(model, groupNoticeVo);
	}
	
	//�׷� �������� ���� (��â>�˾�>�����˾� ���)
	@RequestMapping(value = "group/detail/ntc_feed/del", method = RequestMethod.POST)
	public String adminGroupDetailNoticeDelete(Model model, GroupNoticeVo groupNoticeVo) {
		
		adminService.adminGroupDetailNoticeDelete(model, groupNoticeVo);
		return "admin/group/detail";
	}
	
	//�׷� �������� ��ۻ��� (��â>�˾�>�����˾� ���)
	@RequestMapping(value = "group/detail/ntc_feed/cmmtdel", method = RequestMethod.POST)
	public String adminGroupDetailNoticeCmmtDelete(Model model, GroupNoticeCommentVo groupNoticeCommentVo) {
		
		adminService.adminGroupDetailNoticeCmmtDelete(model, groupNoticeCommentVo);
		return "admin/group/detail";
	}
	
	//�׷� �ǵ� ���� (��â>�����˾� ���)
	@RequestMapping(value = "group/detail/del", method = RequestMethod.POST)
	public String adminGroupDetailDelete(Model model, GroupPostVo groupPostVo) {
		
		adminService.adminGroupDetailDelete(model, groupPostVo);
		return "admin/group/detail";
	}
	
	//�׷� �ǵ� ��� ���� (��â>�����˾� ���)
	@RequestMapping(value = "group/detail/cmmtdel", method = RequestMethod.POST)
	public String adminGroupDetailCmmtdelete(Model model, GroupCommentVo groupCommentVo) {
		
		adminService.adminGroupDetailCmmtdelete(model, groupCommentVo);
		return "admin/group/detail";
	}
	
	//�׷�� ���(��â>�˾�)
	@RequestMapping(value = "group/detail/member", method = RequestMethod.GET)
	public String adminGroupMemberList(HttpServletRequest req, GroupVo groupVo){
		
		adminService.adminGroupMemberList(req, groupVo);
		return "admin/group/member";
	}
	
	//���� ����
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String adminUserSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		adminService.adminUserSelectAll(model, pageSearchVo);
		return "admin/user/index";
	}
	
	//���� ���� (�����˾� ���)
	@RequestMapping(value = "user/stop", method = RequestMethod.POST)
	public String adminUserStop(Model model, MyAdminVo myAdminVo) {
		
		adminService.adminUserStop(model, myAdminVo);
		return "admin/user/index";
	}
	
	//���� �߹� (�����˾� ���)
	@RequestMapping(value = "user/kick", method = RequestMethod.POST)
	public String adminUserKick(Model model, MyAdminVo myAdminVo) {
		
		adminService.adminUserKick(model, myAdminVo);
		return "admin/user/index";
	}
	
	//���� �ǵ� ������ (��â)
	@RequestMapping(value = "user/detail", method = RequestMethod.GET)
	public String adminUserDetail(HttpServletRequest req, ProfileVo profileVo) {
		
		adminService.adminUserDetail(req, profileVo);
		return "admin/user/detail";
	}
	
	//�ǵ��� ������ �񵿱�
	@RequestMapping(value = "user/detail/cmmt", method = RequestMethod.GET)
	public @ResponseBody List<MyCommentVo> adminUserDetailCmmt(Model model, MyPostVo post){
		
		return adminService.adminUserDetailCmmt(model, post);
	}
	
	//���� �ǵ� ���� (��â>�����˾� ���)
	@RequestMapping(value = "user/detail/del", method = RequestMethod.POST)
	public String adminUserDelete(Model model, MyPostVo myPostVo) {
		
		adminService.adminUserDelete(model, myPostVo);
		return "admin/user/detail";
	}
	
	//���� �ǵ� ��� ���� (��â>�����˾� ���)
	@RequestMapping(value = "cmmt/del", method = RequestMethod.POST)
	public String adminUserCmmtdelete(Model model, MyCommentVo myCommentVo) {
		
		adminService.adminUserCmmtdelete(model, myCommentVo);
		return "admin/user/detail";
	}
	
	//���� �ȷο� ����Ʈ (��â>�˾�)
	@RequestMapping(value = "follower", method = RequestMethod.GET)
	public String adminUserfollowerList(Model model, ProfileVo profile){
		
		adminService.adminUserfollowerList(model, profile);
		return "admin/user/follower";
	}
	
	//���� �ȷο� ����Ʈ (��â>�˾�)
	@RequestMapping(value = "following", method = RequestMethod.GET)
	public String adminUserfollowList(Model model, ProfileVo profile){
		
		adminService.adminUserfollowList(model, profile);
		return "admin/user/following";
	}
	
	//ķ���� ����
	@RequestMapping(value = "camp", method = RequestMethod.GET)
	public String adminCampSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		adminService.adminCampSelectAll(model, pageSearchVo);
		return "admin/camp/index";
	}
	
	//ķ���� ���� (�����˾� ���)
	@RequestMapping(value = "camp/del", method = RequestMethod.POST)
	public String adminCampDeleteOne(Model model, CampVo campVo){
		
		adminService.adminCampDeleteOne(model, campVo);
		return "admin/camp/index";
	}
	
	//ķ���� ������ (��â)
	@RequestMapping(value = "camp/detail", method = RequestMethod.GET)
	public String adminCampDetail(Model model, CampVo campVo) {
		
		adminService.adminCampDetail(model, campVo);
		return "admin/camp/detail";
	}
	
	//ķ���� ������ ���� (��â>�����˾� ���)
	@RequestMapping(value = "camp/detail/revdel", method = RequestMethod.POST)
	public String reviewDeleteOne(Model model, CampReviewVo campReviewVo) {
		
		adminService.reviewDeleteOne(model, campReviewVo);
		return "admin/camp/detail";
	}
	
	//����� ����
	@RequestMapping(value = "venture", method = RequestMethod.GET)
	public String adminVentureSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		adminService.adminVentureSelectAll(model, pageSearchVo);
		return "admin/venture/index";
	}
	
	//����� ���� (�����˾� ���)
	@RequestMapping(value = "venture/out", method = RequestMethod.POST)
	public String adminVentureDeleteOne(Model model, MyVentureVo myVentureVo) {
		
		adminService.adminVentureDeleteOne(model, myVentureVo);
		return "admin/venture/index";
	}
	
	//����ڵ���� �̹���(�����˾� ���)
	@RequestMapping(value ="venture/img", method = RequestMethod.POST)
	public String AdminVentureImg(Model model, MyVentureVo myVentureVo, @RequestParam("where") int where) {
		return "admin/venture/index";
		//return "admin/venture/req";
	}
	
	//����� ��û ����
	@RequestMapping(value = "venture/req", method = RequestMethod.GET)
	public String adminVentureRequestSelectAll(Model model, PageSearchVo pageSearchVo) {
		adminService.adminVentureRequestSelectAll(model, pageSearchVo);
		return "admin/venture/req";
	}
	
	//����� ��û ���� (�����˾� ���)
	@RequestMapping(value = "venture/reqhi", method = RequestMethod.POST)
	public String adminVentureRequestHello(Model model, UpdateWaitVo updateWaitVo) {
		
		adminService.adminVentureRequestHello(model, updateWaitVo);
		return "admin/venture/req";
	}
	
	//����� ��û ���� (�����˾� ���)
	@RequestMapping(value = "venture/reqbye", method = RequestMethod.POST)
	public String adminVentureRequestSorry(Model model, UpdateWaitVo updateWaitVo) {
		
		adminService.adminVentureRequestSorry(model, updateWaitVo);
		return "admin/venture/req";
	}
	
	//�Ű� ��ȸ
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String adminReportSelectAll(Model model, PageSearchVo pageSearchVo) {
		
		adminService.adminReportSelectAll(model, pageSearchVo);
		return "admin/report/index";
	}

	//�Ű� ó�� (�����˾� ���)
	@RequestMapping(value = "report/complate", method = RequestMethod.POST)
	public String adminReportComplate(Model model, ReportListVo reportListVo) {
		
		adminService.adminReportComplete(model, reportListVo);
		return "admin/report/index";
	}

	//�Ű� ������ (�����˾� ���)
	@RequestMapping(value = "report/detail", method = RequestMethod.GET)
	public String adminReportSelectOne(Model model, ReportListVo reportListVo) {
		
		adminService.adminReportSelectOne(model, reportListVo);
		return "admin/report/detail";
	}
}
