package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc01.model.Emp01Dao;

public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("idx");
		int sabun = 0;
		sabun = Integer.parseInt(param);
		req.setAttribute("sabun", sabun);
		
		RequestDispatcher rd = req.getRequestDispatcher("delete.jsp");
		rd.forward(req, resp);
   }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		Emp01Dao dao = new Emp01Dao();
		int result = dao.deleteOne(sabun);
		if (result > 0) {
			resp.sendRedirect("list.html");
		} else {
			resp.sendRedirect("detail.html?idx="+sabun);
		}
	}
}