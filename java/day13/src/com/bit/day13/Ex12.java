package com.bit.day13;

interface Inter12 {
	void func01();
}

public class Ex12 {
	public static void main(String[] args) {
//		new Inter12();							// 1. err ��ü ���� �Ұ�
		
//		new Inter12() {							// 2. �������̽��� �����θ� ���� ����
//			void func01(){}
//		};
		
		Inter12 ele = new Inter12() {			// 3. Ŭ���� Ÿ�� ���� (���������� �ɼ�)
			public void func01(){}
		};
		ele.func01();
	}
}
