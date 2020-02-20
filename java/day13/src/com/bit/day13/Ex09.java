package com.bit.day13;

class Outter09 {
	static int su1 = 1111;
	int su2 = 2222;
	
	class Inner09 {
		int su3 = 3333;
		public Inner09() {
			System.out.println("new Inner()");
		}
		public void func03() {
			System.out.println("Inner func03");
			System.out.println(su1);
			System.out.println(su2);
			func01();
			func02();				// func03을 호출한 시점에 이미 객체가 생성되어 있음
		}
	}
	
	public Outter09() {}
	public static void func01() {}
	public void func02() {
		Inner09 inn2 = new Inner09();
		System.out.println(inn2.su3);
		inn2.func03();
	}
}

public class Ex09 {
	public static void main(String[] args) {
		Outter09 outt = new Outter09();
		Outter09.Inner09 inn = null;			// 윗줄을 먼저 수행해야 객체 생성이 가능
		inn = outt.new Inner09();				// 타입이 동일해야 가능
		System.out.println(inn.su3);
		inn.func03();
	}
}
