package com.bit.model.entity;

public class JavaBean {
	private String id, pw;
	
	public JavaBean() {
		System.out.println("create bean");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
