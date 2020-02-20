package com.bit.mvc03.utils;

import java.util.Date;

@MyAnnotation("")
public class JavaBean {
	
	private int su1;
	private double su2;
	private boolean boo;
	private char ch;
	private String msg;
	private Date nalja;
	
	public JavaBean() {
	}
	
	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public int getSu1() {
		return su1+1000;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}

	public double getSu2() {
		return su2;
	}

	public void setSu2(double su2) {
		this.su2 = su2;
	}

	public boolean isBoo() {
		return boo;
	}

	public void setBoo(boolean boo) {
		this.boo = boo;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
