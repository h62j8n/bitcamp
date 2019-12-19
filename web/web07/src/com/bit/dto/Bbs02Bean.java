package com.bit.dto;

import java.sql.Date;

public class Bbs02Bean {
	int num;
	String id;
	String sub;
	String content;
	Date nalja;
	int num_ref, num_no, num_lev;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNalja() {
		return nalja;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	public int getNum_ref() {
		return num_ref;
	}
	public void setNum_ref(int num_ref) {
		this.num_ref = num_ref;
	}
	public int getNum_no() {
		return num_no;
	}
	public void setNum_no(int num_no) {
		this.num_no = num_no;
	}
	public int getNum_lev() {
		return num_lev;
	}
	public void setNum_lev(int num_lev) {
		this.num_lev = num_lev;
	}
	
}
