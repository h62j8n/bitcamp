package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex13Controller {
	@RequestMapping("/ex13")
	public void ex13() {
		
	}
	
	@RequestMapping(value = "/ex14", method = RequestMethod.GET)
	// form 액션값을 결정하는 것이 가능
	// "value = " : 한개만 있어서 늘 생략했지만, 인자가 두개가 되어서 명시 필요
	public void ex14(String id) {
		System.out.println(id);
	}
}
