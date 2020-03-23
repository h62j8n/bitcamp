package com.fin.festa.model.entity;

public class AgeCountVo {		//��ú���-ȸ�� ���ɺ���Vo

	private int age10;		//ȸ�����ɴ� 10�� �ۼ�Ʈ
	private int age20;		//ȸ�����ɴ� 20�� �ۼ�Ʈ
	private int age30;		//ȸ�����ɴ� 30�� �ۼ�Ʈ
	private int age40;		//ȸ�����ɴ� 40�� �ۼ�Ʈ
	private int age50;		//ȸ�����ɴ� ��Ÿ(50�̻�)
	
	@Override
	public String toString() {
		return "AgeCountVo [age10=" + age10 + ", age20=" + age20 + ", age30=" + age30 + ", age40=" + age40 + ", age50="
				+ age50 + "]";
	}
	
	public AgeCountVo() {
		// TODO Auto-generated constructor stub
	}

	public AgeCountVo(int age10, int age20, int age30, int age40, int age50) {
		super();
		this.age10 = age10;
		this.age20 = age20;
		this.age30 = age30;
		this.age40 = age40;
		this.age50 = age50;
	}

	public int getAge10() {
		return age10;
	}

	public void setAge10(int age10) {
		this.age10 = age10;
	}

	public int getAge20() {
		return age20;
	}

	public void setAge20(int age20) {
		this.age20 = age20;
	}

	public int getAge30() {
		return age30;
	}

	public void setAge30(int age30) {
		this.age30 = age30;
	}

	public int getAge40() {
		return age40;
	}

	public void setAge40(int age40) {
		this.age40 = age40;
	}

	public int getAge50() {
		return age50;
	}

	public void setAge50(int age50) {
		this.age50 = age50;
	}
	
}
