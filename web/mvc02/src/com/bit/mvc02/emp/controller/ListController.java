package com.bit.mvc02.emp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc02.emp.model.Emp02Dao;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext cntxt = getServletContext();
		Enumeration<String> enu = cntxt.getInitParameterNames();
		HashMap<String, String> map = new HashMap<String, String>();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			map.put(name, cntxt.getInitParameter(name));
		}
		
		Emp02Dao dao = null;
		try {
			dao = new Emp02Dao(map);
			req.setAttribute("list", dao.selectAll());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}
}
