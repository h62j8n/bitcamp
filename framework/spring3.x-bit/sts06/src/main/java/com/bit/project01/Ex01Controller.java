package com.bit.project01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex01Controller /*implements org.springframework.web.servlet.mvc.Controller*/ {

	@RequestMapping("/ex01")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("home", "serverTime", "h62j8n 1page");
		// home.jsp 호출, serverTime과 h62j8n 출력
	}

}
