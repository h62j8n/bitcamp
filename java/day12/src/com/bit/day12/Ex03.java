package com.bit.day12;

abstract class Cl03 {								// �߻� Ŭ����
	int su1 = 1234;
	
	public static void func01() {
		System.out.println("Cl03 static func01");
	}
	public void func02() {
		System.out.println("Cl03 non-static func02");
	}
//	public abstract void func03();					// �߻� �޼ҵ�
//	public abstract void func04();
}

class Cl33 extends Cl03 {
	Cl33 cl33 = new Cl33();							// �߻�޼ҵ尡 ���� �߻�Ŭ������ ���. ��ü ������ ����
}

public class Ex03 {
	public static void main(String[] args) {
//		Cl03 cl03 = new Cl03();
//		(��ü ���� �Ұ�)
		
	}
}
