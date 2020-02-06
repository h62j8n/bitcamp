package com.bit.mvc03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntroController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String page = this.getInitParameter("pageName");
		String img = this.getInitParameter("imgName");
		System.out.println(page+","+img);
		req.getRequestDispatcher("intro.jsp")
					.forward(req, resp);
	}
}
