package com.bit.day13;

public class Ex06 {
	static class Inner06 {
		int num1 = 1111;				// �ʵ�
		static int num2 = 2222;
		
		public Inner06() {				// ������
			System.out.println("new Inner Object");
		}
		
		public static void func02() {
			System.out.println("Inner static func02");
		}
		
		public void func01() {			// �޼ҵ�
			System.out.println("Inner func01()");
		}
	}
	public static void main(String[] args) {
//		System.out.println(Inner06.num1);	// Err : ��ü ���� ���� �ν��Ͻ� ���� ȣ�� �Ұ�
		Inner06 inn = new Inner06();
		System.out.println(inn.num1);
		
		inn.func01();
		Inner06.func02();
	}
}
