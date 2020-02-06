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
import com.bit.mvc03.model.Emp04Dto;

@WebServlet("/emp/detail.html")
public class DetailController extends HttpServlet{
	String[] err;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int sabun=Integer.parseInt(req.getParameter("idx"));
		Emp04Dao dao=new Emp04Dao();
		try {
			req.setAttribute("bean", dao.selectOne(sabun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("../detail.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		err=new String[2];
		req.setCharacterEncoding("utf-8");
		String[] paramName={"sabun","name","pay","etc"};
		String[] param=new String[paramName.length];
		for(int i=0; i<paramName.length; i++){
			param[i]=req.getParameter(paramName[i]);
		}
		// 기존 값(bean)을 가져와서
		// 신규 수정으로 변환된 bean으로
		Emp04Dao dao2=new Emp04Dao();
		Emp04Dto bean;
		try {
			bean = dao2.selectOne(Integer.parseInt(param[0]));
			bean.setName(param[1]);
			try{
				bean.setPay(Integer.parseInt(param[2]));
			}catch(NumberFormatException e){}
			bean.setEtc(param[3]);
			req.setAttribute("bean", bean);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		req.setAttribute("err", err);
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/detail.jsp");
		
		if(param[1].trim().isEmpty()){
			err[0]="이름을 입력하세요";
			rd.forward(req, resp);
			return ;
		}
		if(param[2].trim().isEmpty()){
			err[1]="금액을 입력하세요";
			rd.forward(req, resp);
			return;
		}
		
		int sabun=-1;
		String name=null;
		int pay=-1;
		String etc=null;
		try{
			sabun=Integer.parseInt(param[0].trim());
			name=param[1].trim();
			pay=Integer.parseInt(param[2].trim());
			etc=param[3].trim();
		}catch(NumberFormatException e){
			err[1]="숫자를 입력하세요";
			rd.forward(req, resp);
			return;
		}catch(Exception e){
			
		}
		Emp04Dao dao=new Emp04Dao();
		int result=0;
		try {
			result = dao.updateOne(sabun,name,pay,etc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.removeAttribute("err");
		doGet(req, resp);
	}
}













