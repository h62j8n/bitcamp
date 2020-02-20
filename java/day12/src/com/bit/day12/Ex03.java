package com.bit.day12;

abstract class Cl03 {								// 추상 클래스
	int su1 = 1234;
	
	public static void func01() {
		System.out.println("Cl03 static func01");
	}
	public void func02() {
		System.out.println("Cl03 non-static func02");
	}
//	public abstract void func03();					// 추상 메소드
//	public abstract void func04();
}

class Cl33 extends Cl03 {
	Cl33 cl33 = new Cl33();							// 추상메소드가 없는 추상클래스를 상속. 객체 생성이 가능
}

public class Ex03 {
	public static void main(String[] args) {
//		Cl03 cl03 = new Cl03();
//		(객체 생성 불가)
		
	}
}
