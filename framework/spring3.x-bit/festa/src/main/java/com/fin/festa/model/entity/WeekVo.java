package com.fin.festa.model.entity;

public class WeekVo {			//������ �ű԰�������ȲVo

	private int monday;			//������ �����Ͻű԰����� ��
	private int tuesday;		//������ ȭ���Ͻű԰����� ��
	private int wednesday;		//������ �����Ͻű԰����� ��
	private int thursday;		//������ ����Ͻű԰����� ��
	private int friday;			//������ �ݿ��Ͻű԰����� ��
	private int saturday;		//������ ����Ͻű԰����� ��
	private int sunday;			//������ �Ͽ��Ͻű԰����� ��
	
	@Override
	public String toString() {
		return "WeekVo [monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday="
				+ thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + "]";
	}
	
	public WeekVo() {
		// TODO Auto-generated constructor stub
	}

	public WeekVo(int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
		super();
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}
	
}
