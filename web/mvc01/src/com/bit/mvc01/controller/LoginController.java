package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.mvc01.model.Emp01Dao;
import com.bit.mvc01.model.Emp01Dto;

public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String param1 = req.getParameter("sabun");
		String param2 = req.getParameter("name");
		int sabun = Integer.parseInt(param1);
		String name = param2.trim();
		
		//
		Emp01Dao dao = new Emp01Dao();
		Emp01Dto bean = dao.login(sabun, name);
		
		if (bean.getCnt() > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("login", bean);
			resp.sendRedirect("index.html");
		} else {
			resp.sendRedirect("login.html");
		}
	}
}