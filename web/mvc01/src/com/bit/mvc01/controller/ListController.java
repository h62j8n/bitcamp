package com.bit.mvc01.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc01.model.Emp01Dao;
import com.bit.mvc01.model.Emp01Dto;

public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// model
		Emp01Dao dao = new Emp01Dao();
		ArrayList<Emp01Dto> list = dao.selectAll();
		req.setAttribute("alist", list);
		// view ю╖юс
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
   }
}