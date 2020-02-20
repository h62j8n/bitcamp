package com.bit.mvc01.model;

import java.sql.Date;

public class Emp01Dto {	
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	private String etc;
	private int cnt;
   
   //bean과는 다르게 default 생성자 무조건 생성
   public Emp01Dto() {
   
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
