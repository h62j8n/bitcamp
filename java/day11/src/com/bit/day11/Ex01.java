package com.bit.day11;
class Lec01 {
	// �ʵ�
	public int su1 = 1234;							// �ν��Ͻ� ���� (non-static)
	private static int su2 = 4321;					// Ŭ���� ���� (static)
	
	public void func01() {
		System.out.println("func01");
	}
	public static void func02() {
		System.out.println("func02+su2"); 
	}
}
public class Ex01 {
	public static void main(String[] args) {
		
//		System.out.println(Lec01.su2);
		
//		System.out.println(com.bit.sec.Lec03.su2);
//		System.out.println(lec01.su1);
		
		Lec01.func02();
		
		Lec01 lec01 = new Lec01();
		Lec02 lec02 = new Lec02();					// default �ʵ�� �ν��Ͻ��� ���� ����
		
//		System.out.println(lec01.su1);
		
		lec01.func01();
	}
}
