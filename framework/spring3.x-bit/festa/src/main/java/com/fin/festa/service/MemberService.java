package com.fin.festa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.fin.festa.model.entity.LoginVo;
import com.fin.festa.model.entity.ProfileVo;

public interface MemberService {

		int  login(HttpServletRequest req, LoginVo loginVo);

		void  logout(HttpServletRequest req);

		void  memberInsertOne(Model model, ProfileVo profileVo);
		
		void  idCheck(Model model, LoginVo loginVo);
		 
		ProfileVo  findId(Model model, LoginVo loginVo);
		
		ProfileVo  findPw(Model model, LoginVo loginVo);

		String updatePw(Model model, ProfileVo profile);
}
