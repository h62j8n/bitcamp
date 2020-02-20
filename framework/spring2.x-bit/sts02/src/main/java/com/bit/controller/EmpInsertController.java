package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp01Dao;
import com.bit.model.entity.Emp01Vo;

public class EmpInsertController implements Controller {
	Emp01Dao dao;
	
	public void setDao(Emp01Dao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Emp01Vo bean=new Emp01Vo(
				0,
				request.getParameter("name"),
				null,
				Integer.parseInt(request.getParameter("pay")),
				Integer.parseInt(request.getParameter("deptno"))				
				);
		dao.insertOne(bean);
		return new ModelAndView("redirect:list.bit");
	}

}














