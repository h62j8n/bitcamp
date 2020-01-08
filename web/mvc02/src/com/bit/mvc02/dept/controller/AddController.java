package com.bit.mvc02.dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc02.dept.model.Dept02Dao;

public class AddController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		
		ServletContext cntxt = getServletContext();
		
		// cntxt È®ÀÎ¿ë
//		Enumeration<String> enu = cntxt.getInitParameterNames();
//		while (enu.hasMoreElements()) {
//			String paramName = enu.nextElement();
//			String value = context.getInitParameter(paramName);
//			System.out.println(paramName + " : " + value);
//		}
		
		String driver = cntxt.getInitParameter("driver");
		String url = cntxt.getInitParameter("url");
		String user = cntxt.getInitParameter("user");
		String password = cntxt.getInitParameter("password");
		
		try {
			Dept02Dao dao = new Dept02Dao(driver, url, user, password);
			dao.insertOne(dname, loc);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/mvc02/dept/list.html");
	}
}
