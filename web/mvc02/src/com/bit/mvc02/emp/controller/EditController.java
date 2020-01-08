package com.bit.mvc02.emp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc02.emp.model.Emp02Dao;
import com.bit.mvc02.emp.model.Emp02Dto;

@WebServlet("/emp/detail.html")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext cntxt=getServletContext();
		Enumeration<String> enu = cntxt.getInitParameterNames();
		Map<String,String> map = new HashMap();
		while(enu.hasMoreElements()){
			String key = enu.nextElement();
			map.put(key,cntxt.getInitParameter(key));
		}
		
		Emp02Dao dao=null;
		try {
			dao = new Emp02Dao(map);
			Emp02Dto bean = dao.selectOne(Integer.parseInt(req.getParameter("sabun")));
			req.setAttribute("bean", bean);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
}
