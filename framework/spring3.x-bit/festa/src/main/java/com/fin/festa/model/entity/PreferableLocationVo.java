package com.fin.festa.model.entity;

public class PreferableLocationVo {		//��ú���-��ȣ��������Vo

	private int addrcnt;		//��ȣ���� �ο���
	private String proaddr;		//��ȣ���� ��
	private int rn;				//��·ο�ѹ�
	
	@Override
	public String toString() {
		return "PreferableLocationVo [addrcnt=" + addrcnt + ", proaddr=" + proaddr + ", rn="+rn+"]";
	}

	public PreferableLocationVo() {
		// TODO Auto-generated constructor stub
	}

	
	public int getAddrcnt() {
		return addrcnt;
	}

	public void setAddrcnt(int addrcnt) {
		this.addrcnt = addrcnt;
	}

	public String getProaddr() {
		return proaddr;
	}

	public void setProaddr(String proaddr) {
		this.proaddr = proaddr;
	}
	
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public PreferableLocationVo(int addrcnt, String proaddr, int rn) {
		super();
		this.addrcnt = addrcnt;
		this.proaddr = proaddr;
		this.rn = rn;
	}
	
	
}
