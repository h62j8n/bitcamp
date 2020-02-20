package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp01Dao;

public class LoginController implements Controller {
	Emp01Dao dao;
	
	public void setDao(Emp01Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int sabun=Integer.parseInt(request.getParameter("sabun"));
		String name=request.getParameter("name");
		boolean tf=dao.loginCheck(sabun,name);
		ModelAndView mav=null;;
		mav=new ModelAndView("redirect:/dept/list.bit");
		if(tf) {
			HttpSession session = request.getSession();
			session.setAttribute("login", name);
		}else {
			mav.setViewName("login/login");
			mav.addObject("err", "로그인 실패");
		}
		return mav;
	}

}















