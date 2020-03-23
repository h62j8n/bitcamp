package com.fin.festa.model.entity;

public class LoginVo {			//�α��� ���� 

	private String id;			//�α��� ID üũ
	private String pw;			//�α��� PW üũ
	private String proname;		//ID ã�⿡ ���
	private String proidnum;	//PW ã�⿡ ���
	
	@Override
	public String toString() {
		return "LoginVo [id=" + id + ", pw=" + pw + ", proname=" + proname + ", proidnum=" + proidnum + "]";
	}
	
	public LoginVo() {
		// TODO Auto-generated constructor stub
	}

	public LoginVo(String id, String pw, String proname, String proidnum) {
		super();
		this.id = id;
		this.pw = pw;
		this.proname = proname;
		this.proidnum = proidnum;
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

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProidnum() {
		return proidnum;
	}

	public void setProidnum(String proidnum) {
		this.proidnum = proidnum;
	}
	
	
}
