package com.bit.mvc03.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc03.model.Emp04Dao;

@WebServlet("/emp/list.html")
public class ListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp04Dao dao=new Emp04Dao();
		try {
			request.setAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = null;
		rd=request.getRequestDispatcher("../list.jsp");
		rd.forward(request, response);
	}

}
