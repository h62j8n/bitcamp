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
//////////////////////////////로그인 관련//////////////////////////////
//////////////////////////////////////////////////////////////////////

	@Autowired
	private MemberService memberService;

	// 로그인 화면 (팝업)
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	// 로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody int login(HttpServletRequest req, LoginVo loginVo) {
		int result = memberService.login(req, loginVo);
		/*
		 * if(result == 0) { System.out.println("정상"); return "user/index"; } else
		 * if(result == 1) { System.out.println("정지"); return "member/stop"; } else
		 * if(result == 2){ System.out.println("추방"); return "member/kick"; } else
		 * if(result == 3){ System.out.println("관리자"); return "admin/index"; } else {
		 * System.out.println("아이디 비밀번호 확인");
		 * 
		 * return "redirect:/?err=Err"; }
		 */		// 성공시 로그인정보, 가입그룹목록, 북마크, 채팅, 팔로워, 팔로잉 목록을 세션에 담아서 가져간다.
		return result;
	}
	
	//정지
	@RequestMapping(value = "stop", method = RequestMethod.GET)
	public String stop() {
		return "member/stop";
	}
	
	//추방
	@RequestMapping(value = "kick", method = RequestMethod.GET)
	public String kick() {
		return "member/kick";
	}

	// 로그아웃 (팝업)
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}

	// 로그아웃 (팝업>팝업 내 기능)
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest req) {
		System.out.println("로그아웃 팝업");
		memberService.logout(req);
		
		return "index";
	}

	// 회원가입 화면
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String memberInsertOne() {
		return "member/join";
	}

	// ID중복체크
	@RequestMapping(value = "join/idcheck", method = RequestMethod.POST)
	public String idCheck(Model model, LoginVo loginVo) {
		return "member/join";
	}

	// 회원가입 성공
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String memberInsertOne(Model model, ProfileVo profileVo) {
		return "member/success";
	}

	// 회원가입 성공
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String memberInsertSuccess() {
		return "member/success";
	}

	// ID찾기 화면 (팝업)
	@RequestMapping(value = "find_id", method = RequestMethod.GET)
	public String findId() {
		return "member/find_id";
	}

	// ID찾기 처리 (팝업>팝업 내 기능)
	@RequestMapping(value = "find_id", method = RequestMethod.POST)
	public String findId(Model model, LoginVo loginVo) {
		return "member/find_id";
	}

	// PW찾기 화면 (팝업)
	@RequestMapping(value = "find_pw", method = RequestMethod.GET)
	public String findPw() {
		return "member/find_pw";
	}

	// PW찾기 처리 (팝업>팝업 내 기능)
	@RequestMapping(value = "find_pw", method = RequestMethod.POST)
	public String findPw(Model model, LoginVo loginVo) {
		return "member/find_pw";
	}

}
