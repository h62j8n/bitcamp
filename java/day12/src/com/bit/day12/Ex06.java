package com.bit.day12;

public class Ex06 implements Inter02, Inter03 {			// �������̽� ���߻��
	public static void main(String[] args) {
		Inter02 me = new Ex06();
		me.func01();
	}
	public void func01() {
		System.out.println("����");
	}
	public void func02() {}
}
