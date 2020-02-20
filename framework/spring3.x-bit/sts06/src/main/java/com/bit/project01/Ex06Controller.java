package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex06Controller {
	@RequestMapping("/ex06")
	public String func01(Model model) {
		model.addAttribute("serverTime", "6page");
		
		return "home";
	}
}
