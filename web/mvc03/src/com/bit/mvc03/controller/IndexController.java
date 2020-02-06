package com.bit.mvc03.controller;

import java.io.IOException;

import javax.jws.soap.InitParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @어노테이션 - meta data
@WebServlet(
		value={"/index.html","/index.bit"}
		, initParams={
			@WebInitParam(name="pageName",value="index")
			,@WebInitParam(name="imgName",value="big01")
		}
)
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String page=this.getInitParameter("pageName");
		String img = this.getInitParameter("imgName");
		System.out.println(page+","+img);
		req.getRequestDispatcher("index.jsp")
			.forward(req, resp);
	}
}





