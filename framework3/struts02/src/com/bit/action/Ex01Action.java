package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {

	@Override
	public String execute() throws Exception {
		// return this.ERROR;
		// 같은 말 : return "error";
		return "success";
	}
}
