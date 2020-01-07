package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc01.model.Emp01Dao;

public class AddController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// post방식 한글 처리
		req.setCharacterEncoding("utf-8");
		
		String param1 = req.getParameter("name");
		String param2 = req.getParameter("pay");
		String param3 = req.getParameter("etc");
		String name = param1.trim();
		if (name.isEmpty()){
			resp.sendRedirect("add.html?err=nameErr");
			return;
		}
		int pay = 0;
		try {
			pay = Integer.parseInt(param2.trim());
		} catch (NumberFormatException e) {
			resp.sendRedirect("add.html?err=payErr");
			return;
		}
		
		String etc = param3.trim();
		
		// validation
		
		// model
		Emp01Dao dao = new Emp01Dao();
		dao.insertOne(name, pay, etc);
		
		// redir
		resp.sendRedirect("list.html");
	}
}