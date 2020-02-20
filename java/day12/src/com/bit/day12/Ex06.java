package com.bit.day12;

public class Ex06 implements Inter02, Inter03 {			// 인터페이스 다중상속
	public static void main(String[] args) {
		Inter02 me = new Ex06();
		me.func01();
	}
	public void func01() {
		System.out.println("구현");
	}
	public void func02() {}
}
