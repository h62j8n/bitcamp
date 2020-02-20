package com.bit.project01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex05Controller {
	@RequestMapping("/ex05")
	public String func01(Model model, HttpServletRequest req, HttpSession session) {
		System.out.println("model : " + model);
		System.out.println("req : " + req);
		System.out.println("session : " + session);
		
		return "home";
	}
}
