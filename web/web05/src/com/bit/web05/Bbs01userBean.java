package com.bit.web05;

public class Bbs01userBean {
	private int idx;
	private String id;
	private String pw;
	private String nick;
	private int loginCnt;
	
	// getter
	public int getIdx() {
		return idx;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getNick() {
		return nick;
	}
	public int getLoginCnt() {
		return loginCnt;
	}
	
	// setter
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}
}
