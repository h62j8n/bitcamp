package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Dept01Dao;

public class DeptDeleteController extends AbstractController{
	Dept01Dao dao;
	
	public void setDao(Dept01Dao dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		dao.deleteOne(deptno);
		ModelAndView mav=new ModelAndView("redirect:list.bit");
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		if("POST".equals(request.getMethod())) {
//		int deptno=Integer.parseInt(request.getParameter("deptno"));
//		dao.deleteOne(deptno);
//		}
//		ModelAndView mav=new ModelAndView("redirect:list.bit");
//		return mav;
//	}

}
