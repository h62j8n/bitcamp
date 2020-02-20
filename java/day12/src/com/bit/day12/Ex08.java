package com.bit.day12;

abstract class Cl08 /*extends Object*/ {
	static int su1 = 1234;
	int su2 = 2222;
	
	public Cl08() {								// abstract 클래스도 객체를 생성할 수 있다.
		super();
		System.out.println("create Cl08 object");
	}
	
	public static void func01() {
		System.out.println("func01");
	}
	public abstract void func02();
}

public class Ex08 extends Cl08 {
	public Ex08() {
		super();
		System.out.println("create Ex08 object");
	}
	public static void main(String[] args) {
		System.out.println(Cl08.su1);			// static : 객체 생성 없이 사용 가능
		Cl08.func01();
		Cl08 me = new Ex08();
		me.func02();
	}

	public void func02() {
		System.out.println("func02");
	}
}
