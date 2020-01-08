package com.bit.mvc02.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc02.dept.model.Dept02Dao;

public class DeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		
		ServletContext cntxt = getServletContext();
		String driver = cntxt.getInitParameter("driver");
		String url = cntxt.getInitParameter("url");
		String user = cntxt.getInitParameter("user");
		String password = cntxt.getInitParameter("password");
		
		try {
			Dept02Dao dao = new Dept02Dao(driver, url, user, password);
			dao.deleteOne(deptno);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<script type=\"text/javascript\">location.replace(\"list.html\");</script>");
		out.flush();
		out.close();
	}
}
