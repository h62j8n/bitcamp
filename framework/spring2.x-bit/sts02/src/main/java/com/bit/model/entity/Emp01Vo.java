package com.bit.model.entity;

import java.sql.Timestamp;

public class Emp01Vo {

	private int sabun;
	private String name;
	private Timestamp nalja;
	private int pay;
	private int deptno;
	
	public Emp01Vo() {
	}

	public Emp01Vo(int sabun, String name, Timestamp nalja, int pay, int deptno) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
		this.deptno = deptno;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getNalja() {
		return nalja;
	}

	public void setNalja(Timestamp nalja) {
		this.nalja = nalja;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp01Vo [sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + ", pay=" + pay + ", deptno=" + deptno
				+ "]";
	}
	
}
