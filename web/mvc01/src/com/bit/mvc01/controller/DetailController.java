package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc01.model.Emp01Dao;

public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		int sabun=Integer.parseInt(param);
		
		// model
		Emp01Dao dao=new Emp01Dao();
		req.setAttribute("bean", dao.selectOne(sabun));
		
		// view
		RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
   }
}