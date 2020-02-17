package com.bit;

import java.sql.Date;

public class Emp02Vo {
   private int sabun;
   private String name;
   private int pay;
   private Date nalja;

   public Emp02Vo() {

   }

   public Emp02Vo(int sabun, String name, int pay, Date nalja) {
      super();
      this.sabun = sabun;
      this.name = name;
      this.pay = pay;
      this.nalja = nalja;
   }

   public Date getNalja() {
      return nalja;
   }

   public void setNalja(Date nalja) {
      this.nalja = nalja;
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

   public int getPay() {
      return pay;
   }

   public void setPay(int pay) {
      this.pay = pay;
   }

   @Override
   public String toString() {
      return "Emp02Vo [sabun=" + sabun + ", name=" + name + ", nalja="
            + nalja + ", pay=" + pay + "]";
   }

}