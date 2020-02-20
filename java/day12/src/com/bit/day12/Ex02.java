package com.bit.day12;

public class Ex02 {
	int su = 1234;
	public void func01() {
		System.out.println("func01");
	}
	public static void main(String[] args) {
		Object me = new Ex02();
//		me.func01();
//		부모 Object클래스에 정의된 메소드가 아니어서 사용할 수 없음
		System.out.println(me.toString());
//		부모 Object클래스에 정의된 메소드는 사용할 수 있음
		System.out.println(((Ex02)me).su);
//		형변환 후 필드 사용 가능
		
		System.out.println("-----");
		
		int su1 = 6;
		int su2 = 2;
		double su3 = 1.5;
		double su4 = 0.5;
		Number su5 = new Integer(su1);								// 다형성. 부모 Number타입인 Integer객체 생성이 가능
		Number su6 = new Integer(su2);
		System.out.println(su1+"+"+su2+"="+plus(su1, su2));
		System.out.println(su1+"+"+su2+"="+plus(su1, su4));			// 정수 su1의 오토캐스팅, plus(double, double)로 수행
		System.out.println(su1+"-"+su2+"="+minus(su1, su2));
		System.out.println(su1+"x"+su2+"="+multi(su1, su2));
		System.out.println(su1+"÷"+su2+"="+div(su1, su2));
		System.out.println(su3+"÷"+su2+"="+div(su3, su2));
	}
	public static Number div(int a, int b) {						// 다형성에 의해 부모타입 Number를 리턴타입으로 받을 수 있음
		if (a%b == 0) {			// 나누어 떨어지면 정수형
			return a/b;
		} else {
			return a*1.0/b;		// 그렇지 않으면 실수형
		}
	}
	public static Number div(double a, double b) {
		if (a%b == 0) {			// 나누어 떨어지면 정수형
			return a/b;
		} else {
			return a*1.0/b;		// 그렇지 않으면 실수형
		}
	}
	public static int multi(int a, int b) {
		return a*b;
	}
	public static int plus(int a, int b) {
		return a+b;
	}
	public static double plus(double a, double b) {
		return a+b;
	}
	public static int minus(int a, int b) {
		return a-b;
	}
}
