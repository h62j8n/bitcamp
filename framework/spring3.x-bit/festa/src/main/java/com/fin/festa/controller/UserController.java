package com.fin.festa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fin.festa.model.entity.CampVo;
import com.fin.festa.model.entity.GroupVo;
import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.MyAdminVo;
import com.fin.festa.model.entity.MyCommentVo;
import com.fin.festa.model.entity.MyFollowingVo;
import com.fin.festa.model.entity.MyGoodVo;
import com.fin.festa.model.entity.MyPostVo;
import com.fin.festa.model.entity.MyVentureVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.model.entity.ReportListVo;
import com.fin.festa.model.entity.UpdateWaitVo;
import com.fin.festa.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

//////////////////////////////////////////////////////////////////////
///////////////////////////////���� ����///////////////////////////////
//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private UserService userSerivce;
	
	//�� �ǵ�
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String feedSelectOne(HttpServletRequest req) {
		userSerivce.feedSelectOne(req);
		return "user/index";
	}
	
	//�Խñ� �Է�
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String feedInsertOne(HttpServletRequest req, MultipartFile[] files, MyPostVo myPostVo) {
		userSerivce.feedInsertOne(req, files, myPostVo);
		userSerivce.feedSelectOne(req);
		return "redirect:/user/";
	}


	//�Խñ� ���� (�˾�)
	@RequestMapping(value = "maker", method = RequestMethod.GET)
	public String feedUpdateOne() {
		return "user/maker";
	}

	//�Խñ� ���� (�˾�>�˾� �� ���)
	@RequestMapping(value = "maker", method = RequestMethod.POST)
	public String feedUpdateOne(Model model, MyPostVo myPostVo) {
		return "user/index";
	}

	//�Խñ� ���� (�����˾� ���)
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public String feedDeleteOne(Model model, MyPostVo myPostVo) {
		return "user/index";
	}

	//�ǵ� ��� �Է�
	@RequestMapping(value = "cmmtadd", method = RequestMethod.POST)
	public String feedCmmtInsertOne(Model model, MyCommentVo myCommentVo) {
		return "user/index";
	}

	//�ǵ� ��� ���� (�����˾� ����)
	@RequestMapping(value = "cmmtdel", method = RequestMethod.POST)
	public String feedCmmtDeleteOne(Model model, MyCommentVo myCommentVo) {
		return "user/index";
	}

	//���ƿ� üũ
	@RequestMapping(value = "likeadd", method = RequestMethod.POST)
	public String likeInsertOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "user/index";
	}

	//���ƿ� ���
	@RequestMapping(value = "likedel", method = RequestMethod.POST)
	public String likeDeleteOne(HttpServletRequest req, MyGoodVo myGoodVo) {
		return "user/index";
	}

	//�ȷο� ��� (�˾�)
	@RequestMapping(value = "follower", method = RequestMethod.GET)
	public String followerList(Model model, ProfileVo profile){
		return "user/follower";
	}

	//�ȷο� ��� (�˾�)
	@RequestMapping(value = "following", method = RequestMethod.GET)
	public String followList(Model model, ProfileVo profile){
		return "user/following";
	}
	
	//�ȷο� (�˾�>�˾� �� ���)
	@RequestMapping(value = "foll", method = RequestMethod.POST)
	public String followInsertOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		//return "user/follower";
		return "user/follow";
	}
	
	//�ȷο� ��� (�˾�>�˾� �� ���)
	@RequestMapping(value = "unfoll", method = RequestMethod.POST)
	public String followDeleteOne(HttpServletRequest req, MyFollowingVo myFollowingVo) {
		//return "user/follower";
		return "user/follow";
	}

	//���� �Ű� (�˾�)
	@RequestMapping(value = "us_report", method = RequestMethod.GET)
	public String userReport(){
		return "user/us_report";
	}
	
	//���� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "us_report", method = RequestMethod.POST)
	public String userReport(Model model, ReportListVo reportListVo){
		return "user/index";
	}

	//�ǵ� �Ű� (�˾�)
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String feedReport(){
		return "user/report";
	}
	
	//�ǵ� �Ű� (�˾�>�˾� �� ���)
	@RequestMapping(value = "report", method = RequestMethod.POST)
	public String feedReport(Model model, ReportListVo reportListVo){
		return "user/index";
	}
	
//////////////////////////////////////////////////////////////////////
///////////////////////////////���� ����///////////////////////////////
//////////////////////////////////////////////////////////////////////	
	
	//�� ������ ����
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String myProfile(HttpServletRequest req, ProfileVo profileVo) {
		userSerivce.myProfile(req, profileVo);
		return "user/profile";
	}
	
	//�� ������ ����
	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String myProfileUpdateOne(HttpServletRequest req, ProfileVo profileVo) {
		int result = userSerivce.myProfileUpdateOne(req, profileVo);
		return "user/profile";
	}
	
	//�� ���� ����
	@RequestMapping(value = "adm", method = RequestMethod.GET)
	public String myAdmin(Model model, ProfileVo prifileVo) {
		return "user/adm";
	}
	
	//�� ���� ����(��й�ȣ Ȯ��)
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String myAdminCheck() {
		return "user/check";
	}
	
	//�� ���� ����(��й�ȣ Ȯ��)
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public String myAdminCheck(Model model, LoginVo loginVo) {
		int result = userSerivce.myAdminCheck(model, loginVo);
		if(result == 1) {
		return "user/adm";
		}
		else {
			return "user/check";
		}
	}
	
	//�� ���� ���� ����
	@RequestMapping(value = "adm", method = RequestMethod.POST)
	public String myAdminUpdateOne(HttpServletRequest req, ProfileVo profileVo) {
		userSerivce.myAdminUpdateOne(req, profileVo);
		return "user/check";
	}
	
	//�� ���� ��Ȱ��ȭ (�˾� ���)
	@RequestMapping(value = "out", method = RequestMethod.POST)
	public String myAdminInactive(Model model, MyAdminVo myAdminVo) {
		return "index";
	}
	
	//�� ���� Ż�� (�˾� ���)
	@RequestMapping(value = "inactive", method = RequestMethod.POST)
	public String myAdminGoodbye(Model model, ProfileVo profileVo) {
		return "index";
	}

	//�׷� ����
	@RequestMapping(value = "group", method = RequestMethod.GET)
	public String groupInsertOne() {
		return "user/group";
	}
	
	//�׷� ���� �Ϸ�
	@RequestMapping(value = "group", method = RequestMethod.POST)
	public String groupInsertOne(HttpServletRequest req, GroupVo groupVo) {
		groupVo = userSerivce.groupInsertOne(req, groupVo);
		return "redirect:../group/?grnum=" + groupVo.getGrnum() + "&pronum=" + groupVo.getPronum();
	}
	   
	//����� ���� ��û
	@RequestMapping(value = "venture/add", method = RequestMethod.GET)
	public String ventureInsertOne(Model model) {
		return "user/venture/add";
	}
	
	//����� ���� ��û �Ϸ�
	@RequestMapping(value = "venture/add", method = RequestMethod.POST)
	public String ventureInsertOne(HttpServletRequest req, UpdateWaitVo updateWaitVo) {
		userSerivce.ventureInsertOne(req, updateWaitVo);
		return "user/venture/standby";
	}

	//����� ���� ��û ���� ���
	@RequestMapping(value = "venture/standby", method = RequestMethod.GET)
	public String ventureInsertOne() {
		return "user/venture/standby";
	}

	//����� ���� ����
	@RequestMapping(value = "venture", method = RequestMethod.GET)
	public String ventureAdmin(HttpServletRequest req) {
		userSerivce.ventureAdmin(req);
		return "user/venture/index";
	}
	
	//����� ���� ����
	@RequestMapping(value = "venture/edit", method = RequestMethod.POST)
	public String ventureAdminUpdateOne(HttpServletRequest req, MyVentureVo myVenture) {
		userSerivce.ventureAdminUpdateOne(req, myVenture);
		return "user/venture/index";
	}
	
	//ķ���� ���� ���
	@RequestMapping(value = "camp/add", method = RequestMethod.GET)
	public String campInsertOne() {
		return "user/camp/add";
	}

	//ķ���� ���� ��� �Ϸ�
	@RequestMapping(value = "camp/add", method = RequestMethod.POST)
	public String campInsertOne(Model model, CampVo campVo) {
		return "camp/detail";
	}
	
	//ķ���� ���� ����
	@RequestMapping(value = "camp", method = RequestMethod.GET)
	public String campAdmin(HttpServletRequest req) {
		userSerivce.campAdmin(req);
		return "user/camp/index";
	}
	
	//ķ���� ���� ����
	@RequestMapping(value = "camp/edit", method = RequestMethod.POST)
	public String campUpdateOne(Model model, CampVo campVo) {
		userSerivce.campUpdateOne(model, campVo);
		return "user/camp/index";
	}
}
