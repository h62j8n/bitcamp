package com.fin.festa.model.entity;

import java.sql.Date;

public class GroupChatVo {		//ä��

	private int grnum;			//�׷��ȣ
	private int pronum;			//ȸ����ȣ
	private int joinstatus;		//���ӻ���
	private String mymsg;		//�� �޼���
	private Date msgdate;		//�޼��������
	
	@Override
	public String toString() {
		return "GroupChatVo [grnum=" + grnum + ", pronum=" + pronum + ", joinstatus=" + joinstatus + ", mymsg=" + mymsg
				+ ", msgdate=" + msgdate + "]";
	}
	
	public GroupChatVo() {
		// TODO Auto-generated constructor stub
	}

	public GroupChatVo(int grnum, int pronum, int joinstatus, String mymsg, Date msgdate) {
		super();
		this.grnum = grnum;
		this.pronum = pronum;
		this.joinstatus = joinstatus;
		this.mymsg = mymsg;
		this.msgdate = msgdate;
	}

	public int getGrnum() {
		return grnum;
	}

	public void setGrnum(int grnum) {
		this.grnum = grnum;
	}

	public int getPronum() {
		return pronum;
	}

	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	public int getJoinstatus() {
		return joinstatus;
	}

	public void setJoinstatus(int joinstatus) {
		this.joinstatus = joinstatus;
	}

	public String getMymsg() {
		return mymsg;
	}

	public void setMymsg(String mymsg) {
		this.mymsg = mymsg;
	}

	public Date getMsgdate() {
		return msgdate;
	}

	public void setMsgdate(Date msgdate) {
		this.msgdate = msgdate;
	}
	
	
}
