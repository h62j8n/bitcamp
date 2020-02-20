package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

// 클래스 매핑은 선택적 (패스 결정)
//@RequestMapping("/ex")
@RequestMapping("/")
public class Ex10Controller {
	
	
//	@RequestMapping("/ex01")
	// err : 매핑값 중복 (Ex01Controller에서 매핑됨)
//	메소드 매핑은 필수 (파일명 결정)
	// @RequestMapping("/ex10")
	@RequestMapping("ex10")
	public String ex10() {
		return "";
	}
}
