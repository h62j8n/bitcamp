package com.bit.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BitInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("controller 실행 전..."+handler);
		HttpSession session = request.getSession();
		if(session.getAttribute("login")==null) {
			response.sendRedirect("/sts02/login.bit");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
//		System.out.println("controller 실행 후&view 위임 전..."+handler);
//		System.out.println("controller 실행 후&view 위임 전..."+mav);
//		HttpSession session = request.getSession();
//		if(session.getAttribute("login")==null)mav.setViewName("login/login");
//		System.out.println("controller 실행 후&view 위임 전..."+mav);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("view 위임 후..."+handler);
		System.out.println("view 위임 후..."+ex);
		if(ex!=null) {
			request.setAttribute("err", ex.getMessage());
			request.getRequestDispatcher("/err.jsp").forward(request, response);
//			response.sendRedirect("/sts02/err.jsp");
		}
	}
}












