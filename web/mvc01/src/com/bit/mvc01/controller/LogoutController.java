package com.bit.mvc01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("logout.jsp");
		rd.forward(req, resp);
		
		HttpSession session = req.getSession();
//		로그인 세션 취소 3가지 확인하기
//		System.out.println(session.getId());
		System.out.println("세션이 생성된 시간" + session.getCreationTime());
		System.out.println("세션에 접속한 시간" + session.getLastAccessedTime());
		System.out.println("세션이 유지되는 시간" + session.getMaxInactiveInterval());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
//		로그인 세션을 취소하는 3가지 방법
		session.setAttribute("login", null);
//		session.removeAttribute("login");
//		session.invalidate();					// 세션 갱신
		
		resp.sendRedirect("login.html");
	}
}