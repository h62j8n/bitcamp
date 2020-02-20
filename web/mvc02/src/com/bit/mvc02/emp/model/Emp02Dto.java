package com.bit.mvc02.emp.model;

import java.sql.Date;

public class Emp02Dto {
	private int sabun;
	private String name;
	private Date nalja;
	private int deptno;
	
	public Emp02Dto() {}
	public Emp02Dto(int sabun, String name, Date nalja, int deptno) {
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
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

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Emp02Dto [sabun=" + sabun + ", name=" + name + ", nalja="
				+ nalja + ", deptno=" + deptno + "]";
	}
}
