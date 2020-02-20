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
//		�α��� ���� ��� 3���� Ȯ���ϱ�
//		System.out.println(session.getId());
		System.out.println("������ ������ �ð�" + session.getCreationTime());
		System.out.println("���ǿ� ������ �ð�" + session.getLastAccessedTime());
		System.out.println("������ �����Ǵ� �ð�" + session.getMaxInactiveInterval());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
//		�α��� ������ ����ϴ� 3���� ���
		session.setAttribute("login", null);
//		session.removeAttribute("login");
//		session.invalidate();					// ���� ����
		
		resp.sendRedirect("login.html");
	}
}