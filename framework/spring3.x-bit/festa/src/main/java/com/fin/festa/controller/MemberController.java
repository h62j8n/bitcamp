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
	public @ResponseBody int login(HttpServletRequest req, LoginVo loginVo) {
		int result = memberService.login(req, loginVo);
		/*
		 * if(result == 0) { System.out.println("����"); return "user/index"; } else
		 * if(result == 1) { System.out.println("����"); return "member/stop"; } else
		 * if(result == 2){ System.out.println("�߹�"); return "member/kick"; } else
		 * if(result == 3){ System.out.println("������"); return "admin/index"; } else {
		 * System.out.println("���̵� ��й�ȣ Ȯ��");
		 * 
		 * return "redirect:/?err=Err"; }
		 */		// ������ �α�������, ���Ա׷���, �ϸ�ũ, ä��, �ȷο�, �ȷ��� ����� ���ǿ� ��Ƽ� ��������.
		return result;
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
	public String idCheck(Model model, LoginVo loginVo) {
		return "member/join";
	}

	// ȸ������ ����
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String memberInsertOne(Model model, ProfileVo profileVo) {
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
	public String findId(Model model, LoginVo loginVo) {
		return "member/find_id";
	}

	// PWã�� ȭ�� (�˾�)
	@RequestMapping(value = "find_pw", method = RequestMethod.GET)
	public String findPw() {
		return "member/find_pw";
	}

	// PWã�� ó�� (�˾�>�˾� �� ���)
	@RequestMapping(value = "find_pw", method = RequestMethod.POST)
	public String findPw(Model model, LoginVo loginVo) {
		return "member/find_pw";
	}

}
