package com.bit.mvc03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mvc03.model.Emp04Dao;
import com.sun.corba.se.spi.orbutil.fsm.State;

@WebServlet("/emp/delete.html")
public class DeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param=req.getParameter("idx");
		int sabun=Integer.parseInt(param);
		
		Emp04Dao dao=new Emp04Dao();
		int result=0;
		try {
			result=dao.deleteOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//resp.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = resp.getWriter();
		if(result>0){
			out.print("ok");
		}
		out.flush();
		out.close();
	}
}












