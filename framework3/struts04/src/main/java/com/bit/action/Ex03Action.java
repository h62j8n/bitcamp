package com.bit.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex03Action extends ActionSupport {
	String id, pw;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String execute() throws Exception {
		if (this.hasErrors()) return this.INPUT;
		return this.SUCCESS;
	}
	
	@Override
	public void validate() {
		if (pw.isEmpty()) {
//			addFieldError(fieldName, errorMessage);
			addFieldError("pw", "패스워드 미입력");
			System.out.println("err");
		}
		System.out.print("id: "+id);
		System.out.println(", pw: "+pw);
	}
}
