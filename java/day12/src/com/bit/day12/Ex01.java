package com.bit.day12;

class Cl01 {
	int num1 = 1234;
	
	public Cl01() {}
	public void func01() {
		System.out.println("부모클래스의 func01");
	}
	public final void func02() {
		System.out.println("부모클래스의 final func02");
	}
}
class Cl101 extends Cl01 {
	int num1 = 1111;
	int num2 = 2222;
	
	public void func01() {							// 오버라이드
		System.out.println("자식클래스의 func01");
	}
	public void func03() {
		System.out.println("자식클래스의 func03");
	}
}
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("-----부모타입>");
		Cl01 parent = new Cl01();
		System.out.println(parent.num1);
		parent.func01();
		parent.func02();
		System.out.println("-----자식타입>");
		Cl101 child = new Cl101();
		System.out.println(child.num2);
		child.func03();
		System.out.println(child.num1);
		child.func01();
		child.func02();
		
		System.out.println("-----부모타입>");
		// 다형성
//		Cl101 cl1 = new Cl01();						// 자식클래스타입의 참조변수를 이용해 부모클래스의 인스턴스를 생성 불가
//		(부모클래스의 시점에서 자식클래스 타입을 파악할 수 없음)
		Cl01 cl1 = new Cl101();						// 부모클래스타입의 참조변수를 이용해 자식클래스의 인스턴스를 생성 가능
		cl1.func01();								// 오버라이드된 자식클래스의 메소드 호출
		cl1.func02();
		System.out.println(cl1.num1);				// 부모클래스의 필드값을 가져옴 (필드는 오버라이드가 없기 때문)
//		cl1.func03();
//		(부모클래스에 정의되지 않은 메소드를 사용할 수 없음)
		
		System.out.println("-----자식타입>");
		Cl101 cl2 = (Cl101)cl1;						// 형변환도 가능 (항상 그런 것은 아니다)
		cl2.func01();
		cl2.func02();
		cl2.func03();
		
	}
}