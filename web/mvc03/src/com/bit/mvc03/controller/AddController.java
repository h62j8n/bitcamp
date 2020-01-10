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

@WebServlet("/emp/add.html")
public class AddController extends HttpServlet {
	String[] err;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		err=new String[2];
		String[] param=new String[3];
		param[0]=req.getParameter("name");
		param[1]=req.getParameter("pay");
		param[2]=req.getParameter("etc");
		
		req.setAttribute("err", err);
		req.setAttribute("vals",param);
		
		for(int i=0; i<2; i++){
			if(param[i].trim().isEmpty()){
				if(i==0)err[i]="이름을 입력하세요";
				else err[i]="금액을 입력하세요";
				doGet(req, resp);
				return;
			}
		}
		
		String name=param[0].trim();
		int pay=-1;
		try{
			pay=Integer.parseInt(param[1]);
		}catch(NumberFormatException ex){
			err[1]="숫자로 입력하세요";
			doGet(req, resp);
			return;
		}
		String etc=param[2].trim();
		
		Emp04Dao dao=new Emp04Dao();
		try {
			dao.insertOne(name, pay, etc);
		} catch (SQLException e) {
			err[0]="이름은 5자이내만 입력하세요";
			doGet(req, resp);
			return;
		}
		resp.sendRedirect("list.html");
	}
}












