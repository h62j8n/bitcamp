package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp01Dao;

public class EmpListController implements Controller {
	Emp01Dao dao;
	
	public void setDao(Emp01Dao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("controller run...");
		ModelAndView mav=new ModelAndView("emp/list");
		mav.addObject("list", dao.selectAll());
		return mav;
	}

}
