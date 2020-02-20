package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex04Action implements Action {

	private String msg;
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(msg);
		return this.SUCCESS;
	}
}