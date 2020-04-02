package com.fin.festa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.ProfileVo;
import com.fin.festa.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

//////////////////////////////////////////////////////////////////////
//////////////////////////////�α��� ����//////////////////////////////
//////////////////////////////////////////////////////////////////////

	@Autowired
	private MemberService memberService;

	// �α��� ȭ�� (�˾�)
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	// �α��� ó��
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody ProfileVo login(HttpServletRequest req, LoginVo loginVo) {
		ProfileVo profile = memberService.login(req, loginVo);

		return profile;
	}
	
	//����
	@RequestMapping(value = "stop", method = RequestMethod.GET)
	public String stop() {
		return "member/stop";
	}
	
	//�߹�
	@RequestMapping(value = "kick", method = RequestMethod.GET)
	public String kick() {
		return "member/kick";
	}

	// �α׾ƿ� (�˾�)
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}

	// �α׾ƿ� (�˾�>�˾� �� ���)
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest req) {
		System.out.println("�α׾ƿ� �˾�");
		memberService.logout(req);
		
		return "index";
	}

	// ȸ������ ȭ��
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String memberInsertOne() {
		return "member/join";
	}

	// ID�ߺ�üũ
	@RequestMapping(value = "join/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(Model model, LoginVo loginVo) {
		System.out.println("����");
		int result = memberService.idCheck(model, loginVo);
		System.out.println(result);
		return result;
	}

	// ȸ������ ����
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String memberInsertOne(Model model, ProfileVo profileVo) {
		memberService.memberInsertOne(model, profileVo);
		return "member/success";
	}

	// ȸ������ ����
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String memberInsertSuccess() {
		return "member/success";
	}

	// IDã�� ȭ�� (�˾�)
	@RequestMapping(value = "find_id", method = RequestMethod.GET)
	public String findId() {
		return "member/find_id";
	}

	// IDã�� ó�� (�˾�>�˾� �� ���)
	@RequestMapping(value = "find_id", method = RequestMethod.POST)
	@ResponseBody
	public ProfileVo findId(Model model, LoginVo loginVo) {
		ProfileVo profile =  memberService.findId(model, loginVo);
		
		return profile;
	}

	// PWã�� ȭ�� (�˾�)
	@RequestMapping(value = "find_pw", method = RequestMethod.GET)
	public String findPw() {
		return "member/find_pw";
	}

	// PWã�� ó�� (�˾�>�˾� �� ���)
	@RequestMapping(value = "find_pw", method = RequestMethod.POST)
	@ResponseBody
	public ProfileVo findPw(Model model, LoginVo loginVo) {
		ProfileVo profile =  memberService.findPw(model, loginVo);
		return profile;
	}
	
	// PW ������Ʈ
	@RequestMapping(value="update_pw", method= RequestMethod.POST)
	public String updatePw(Model model,ProfileVo profile) {
		System.out.println("����");
		memberService.updatePw(model, profile);
		return "index";
	}

}
