package com.bit.day12;

public interface Inter02 {
	void func01();
}
interface Inter03/* extends Inter02*/ {
	void func02();
}
interface Inter04 extends Inter02, Inter03 {			// 인터페이스 다중상속
	void func03();
//	int func02();										// Err. 리턴타입은 오버라이딩과 무관
	void func01();										// 그러나 구현부가 없기 때문에 오버라이드의 의미가 없다.
}