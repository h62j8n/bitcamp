package com.bit.project01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex02Controller {

	@RequestMapping("/ex02")
	public ModelAndView func() {
		return new ModelAndView("home", "serverTime", "h62j8n 2page");
	}

}
