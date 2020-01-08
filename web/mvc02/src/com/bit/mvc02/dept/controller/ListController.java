package com.bit.mvc02.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc02.dept.model.Dept02Dao;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String driver = getInitParameter("driver");
		String url = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		
		Dept02Dao dao;
		
		try {
			dao = new Dept02Dao(driver, url, user, password);
			req.setAttribute("list", dao.selectAll());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// view
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");	// 매핑할 때 dept 경로가 지정되어 있음
		rd.forward(req, resp);
	}
}
