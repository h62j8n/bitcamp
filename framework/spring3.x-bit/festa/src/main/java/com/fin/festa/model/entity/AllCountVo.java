package com.fin.festa.model.entity;

public class AllCountVo {		//��ú���-��ü�̿��ڼ�Vo

	private int profile;		//��ü����� ��
	private int group1;			//��ü�׷� ��
	private int myventure;		//��ü����� ��
	private int camp;			//��üķ���� ��
	
	@Override
	public String toString() {
		return "AllCountVo [profile=" + profile + ", group1=" + group1 + ", myventure=" + myventure + ", camp=" + camp
				+ "]";
	}
	
	public AllCountVo() {
		// TODO Auto-generated constructor stub
	}

	public AllCountVo(int profile, int group1, int myventure, int camp) {
		super();
		this.profile = profile;
		this.group1 = group1;
		this.myventure = myventure;
		this.camp = camp;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public int getGroup1() {
		return group1;
	}

	public void setGroup1(int group1) {
		this.group1 = group1;
	}

	public int getMyventure() {
		return myventure;
	}

	public void setMyventure(int myventure) {
		this.myventure = myventure;
	}

	public int getCamp() {
		return camp;
	}

	public void setCamp(int camp) {
		this.camp = camp;
	}
	
}
