package com.bit.day13;

interface Inter {
	public void func01();
}
interface Inter02 {
	public void func02();
}
abstract class Cl11 {
	void func04() {}
	abstract void func05();
}
public class Ex11 {
	String msg2 = new String("어노니머스");	// 어노니머스 클래스도 익숙한 클래스 객체와 동일한 형태
	Object obj3 = new Object() {			// 필드로 사용하는 어노니머스 클래스
		public String toString() {
			return "어노니머스";
		}
	};										// public, static, final 모두 사용할 수 있다
	
	public static Inter func() {				// 리턴타입 Object > 못써서 Inter로 바꿈(다형성)
		class Local11 implements Inter {		// func01()이 생성된 인터페이스 구현
			public void func01() {
				System.out.println("Local func01");
			}
		} // Local11 end
		
//		Local11 me = new Local11();		// 1일반적 내부클래스 객체생성
//		me.func01();
//		new Local11()).func01();		// 2변형
		
		
		
//		return new Local11();							// 1. func() : Local11 객체를 생성하여 리턴
/*		return new class Local11 implements Inter() {	// 2. 1을 풀어서 쓰면. (오류)
 *			public void func01() {
 *				System.out.println("Local func01");
 *			}
 *		};
 */

/*
 *		return new Inter() {							// 3. 2의 변형 (사용이 가능)
 *			public void func01() {
 *				System.out.println("Local func01");
 *			}
 *		};
 */

		Inter local = new Inter() {						// 4. 3의 최후 변형 (anonymous class)
			public void func01() {						// 인터페이스를 상속받는 클래스를 통해
				System.out.println("Local func01");		// 인터페이스에 구현되어있지 않은 부분을 구현하고
			}											// 객체를 생성한다.
		};
		return local;
		
		
		
	} // func end
	
	public static void main(String[] args) {
//		func();
//		Object obj = func();					// Object클래스에 func()이 없어서 에러
		Inter obj = func();						// Object(조상클래스 상속)의 느낌으로, 인터페이스 사용
		obj.func01();
		
		Inter02 ele2 = new Inter02() {
			public void func02() {}
			public void func03() {}
		};
		
		Cl11 cl = new Cl11() {
			void func05() {}
		};
		Object obj2 = new Object() {			// 로컬변수
			public String toString() {
				return "어노니머스";
			}
		};
		System.out.println(obj2);
	}
}
