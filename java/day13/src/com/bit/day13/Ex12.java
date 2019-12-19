package com.bit.day13;

interface Inter12 {
	void func01();
}

public class Ex12 {
	public static void main(String[] args) {
//		new Inter12();							// 1. err 객체 생성 불가
		
//		new Inter12() {							// 2. 인터페이스의 구현부를 갖다 붙임
//			void func01(){}
//		};
		
		Inter12 ele = new Inter12() {			// 3. 클래스 타입 지정 (참조변수는 옵션)
			public void func01(){}
		};
		ele.func01();
	}
}
