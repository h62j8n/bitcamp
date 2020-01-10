package com.bit.mvc03.model;

public class Emp04Dto {
	private int sabun;
	private String name;
	private String nalja;
	private int pay;
	private String etc;
	
	public Emp04Dto() {
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

	public String getNalja() {
		return nalja;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "Emp04Dto [sabun=" + sabun + ", name=" + name + ", nalja="
				+ nalja + ", pay=" + pay + ", etc=" + etc + "]";
	}
		
}
