package com.bit.project01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex11Controller {
	@RequestMapping("ex11")
	/*
	// public String ex11(@RequestParam("id") String id) {
	// 어노테이션으로 파라미터의 id값을 받을 수 있다
	// public String ex11(@RequestParam String id) {
	public String ex11(String id, Model model) {
	// 파라미터명과 값이 같을 경우 어노테이션 생략 가능
	// public String ex11(@RequestParam("pw") String id) {	// 다를 경우 명시
		model.addAttribute("id", id);
		return "ex11";
		
	}
	*/
	
	// Model : 클라이언트측에 값을 보냄
	public String ex11(@ModelAttribute("id") String id) {
		return "ex11";
	}
	// http://localhost:8080/project01/ex11?id=abc
	
	// @RequestMapping("/ex12/{1}/{2}")
	// public String ex12(@PathVariable("1") String id, @PathVariable("2") String pw) {
	@RequestMapping("/ex12/{id}/{2}")
	public String ex12(@PathVariable String id, @PathVariable("2") String pw) {
		// 생략 가능하나 가독성 문제로 지양
		System.out.println(id);
		System.out.println(pw);
		return "ex12";
	}
	// console + http://localhost:8080/project01/ex12/abc/1234
	
}
