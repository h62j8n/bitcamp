package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc01.model.Emp01Dao;

public class EditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		
		Emp01Dao dao = new Emp01Dao();
		req.setAttribute("bean", dao.selectOne(sabun));
		
		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
   }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String param1 = req.getParameter("sabun");
		String param2 = req.getParameter("name");
		String param3 = req.getParameter("pay");
		String param4 = req.getParameter("etc");
		
		int sabun = 0;
		String name = null;
		int pay = 0;
		String etc = null;
		
		sabun = Integer.parseInt(param1.trim());
		name = param2.trim();
		pay = Integer.parseInt(param3.trim());
		etc = param4.trim();
		
		Emp01Dao dao = new Emp01Dao();
		int result = dao.updateOne(sabun, name, pay, etc);
		
		if (result > 0) {
			resp.sendRedirect("detail.html?idx="+sabun);
		} else {
			resp.sendRedirect("edit.html?idx="+sabun);
		}
	}
}