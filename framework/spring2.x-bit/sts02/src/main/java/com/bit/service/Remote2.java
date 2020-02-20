package com.bit.service;

public class Remote2 {
	String msg;
	int num;
	boolean tf;
	
	public void setTf(boolean tf) {
		this.tf = tf;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void func1() {
		System.out.println("msg="+msg);
		System.out.println("num+1="+(num+1));
		System.out.println("tf="+tf);
	}

}
