package com.bit.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex01")
public class Ex01Controller extends HttpServlet {
	Logger log = Logger.getLogger("com.bit.controller.Ex01Controller");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.severe("log.severe : 심각메세지로 출력");
		log.warning("log.warning : 경고메세지로 출력");
		log.info("log.info : ex01 page 출력");
		
		// 콘솔에 출력되지 않는 메세지 (info 이하 레벨)
		log.config("config");
		log.fine("fine");
		log.finer("finer");
		log.finest("finest");
		
		// 세션 갱신
/*
		HttpSession session = req.getSession();
		log.info(session.getId());
		System.out.println(session.getId());
		
		session.invalidate();
		System.out.println("세션갱신");
		
		log.info(session.getId());
		System.out.println(session.getId());

		// "세션갱신" 메세지 전후의 log와 print의 출력 시점이 다르다.
		// id값을 확인해보면 갱신이 안되는데 강사님이 이유를 모르심
 */
		
		System.out.println("");
		HttpSession session = req.getSession();
		session.removeAttribute("msg");
	}
}
