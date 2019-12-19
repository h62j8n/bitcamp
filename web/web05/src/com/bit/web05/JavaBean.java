package com.bit.web05;

import java.sql.Date;

public class JavaBean {
	private int num;
	private String sub;
	private String id;
	private String nick;
	private Date nalja;
	private int cnt;
	private String content;
	
	// setter
	public void setNum(int num) {
		this.num = num;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// getter
	public int getNum() {
		return num;
	}
	public String getSub() {
		return sub;
	}
	public String getId() {
		return id;
	}
	public String getNick() {
		return nick;
	}
	public Date getNalja() {
		return nalja;
	}
	public int getCnt() {
		return cnt;
	}
	public String getContent() {
		return content;
	}
}