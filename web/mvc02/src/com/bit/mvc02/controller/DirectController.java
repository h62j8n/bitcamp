package com.bit.mvc02.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prefix = getInitParameter("prefix");
		String path = getInitParameter("viewName");
		String suffix = getInitParameter("suffix");
		
		Enumeration<String> enu = getInitParameterNames();
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(prefix + path + suffix);
		rd.forward(req, resp);
	}
}
