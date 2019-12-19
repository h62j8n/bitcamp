package com.bit.day12;

interface Inter01 {
	public static final int num1 = 1111;				// 필드가 없지만 상수형 변수는 있다.
	public final int num2 = 2222;						// (public, static, final. 생략 가능)
	public int num3 = 3333;
	int num4 = 4444;
//	Inter01(){};										// 생성자가 없다.

	//	public void func00() {};							// 인터페이스에 추상메소드가 아닌 메소드를 넣을 수 없다.
	public abstract void func01();
	public void func02();									// 따라서 'abstract'를 생략해도 추상메소드
	void func03();											// 'public'을 기재하지 않아도 public이다.
	
}
//public class Ex05 extends Machine, Cl01 {				// 클래스의 다중상속이 불가
public class Ex05 extends Machine implements Inter01 {
	public static void main(String[] args) {
//		Object me = new Ex05();							// 부모 Object클래스에 작성하지 않은 func01()메소드를 수행할 수 없다.
		Inter01 me = new Ex05();						// 인터페이스는 가능하다
		me.func01();
		
		System.out.println(num1);							// = Inter01.num1 : 상수형 변수는 모두 static이다.
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
	}
	
	public void func01() {
		System.out.println("Ex05에서 구현한 func01");
	}

	public void func02() {}								// 인터페이스의 추상메소드를 강제 오버라이드
	public void func03() {}
}
