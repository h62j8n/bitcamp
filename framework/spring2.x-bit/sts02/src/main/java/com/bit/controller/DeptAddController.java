package com.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Dept01Dao;
import com.bit.model.entity.Dept01Vo;

public class DeptAddController extends AbstractCommandController{
	Dept01Dao dao;
	
	public void setDao(Dept01Dao dao) {
		this.dao = dao;
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		Dept01Vo bean=(Dept01Vo) command;
		if(bean.getDname().isEmpty()) {
			ObjectError error=new ObjectError("dname", "NAME NOT NULL");
			errors.addError(error);
		}
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		String path="redirect:list.bit";
		request.setCharacterEncoding("utf-8");
		if(errors.hasErrors()) {
			List<ObjectError> list = errors.getAllErrors();
			ObjectError err = list.get(0);
			path+="?err="+err.getDefaultMessage();
		}else {
			Dept01Vo bean=(Dept01Vo) command;
			dao.insertOne(bean);
		}
		ModelAndView mav=new ModelAndView(path);
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// mysql시 url에 다음 추가 
//		// ?useUnicode=true&amp;characterEncoding=UTF-8
//		//
//		// post한글처리
//		request.setCharacterEncoding("utf-8");
//		
//		Dept01Vo bean=new Dept01Vo();
//		bean.setDname(request.getParameter("dname"));
//		bean.setLoc(request.getParameter("loc"));
//		dao.insertOne(bean);
//		ModelAndView mav=new ModelAndView("redirect:list.bit");
//		return mav;
//	}

}
