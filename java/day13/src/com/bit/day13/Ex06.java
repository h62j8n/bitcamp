package com.bit.day13;

public class Ex06 {
	static class Inner06 {
		int num1 = 1111;				// 필드
		static int num2 = 2222;
		
		public Inner06() {				// 생성자
			System.out.println("new Inner Object");
		}
		
		public static void func02() {
			System.out.println("Inner static func02");
		}
		
		public void func01() {			// 메소드
			System.out.println("Inner func01()");
		}
	}
	public static void main(String[] args) {
//		System.out.println(Inner06.num1);	// Err : 객체 생성 없이 인스턴스 변수 호출 불가
		Inner06 inn = new Inner06();
		System.out.println(inn.num1);
		
		inn.func01();
		Inner06.func02();
	}
}
