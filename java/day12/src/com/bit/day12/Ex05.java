package com.bit.day12;

interface Inter01 {
	public static final int num1 = 1111;				// �ʵ尡 ������ ����� ������ �ִ�.
	public final int num2 = 2222;						// (public, static, final. ���� ����)
	public int num3 = 3333;
	int num4 = 4444;
//	Inter01(){};										// �����ڰ� ����.

	//	public void func00() {};							// �������̽��� �߻�޼ҵ尡 �ƴ� �޼ҵ带 ���� �� ����.
	public abstract void func01();
	public void func02();									// ���� 'abstract'�� �����ص� �߻�޼ҵ�
	void func03();											// 'public'�� �������� �ʾƵ� public�̴�.
	
}
//public class Ex05 extends Machine, Cl01 {				// Ŭ������ ���߻���� �Ұ�
public class Ex05 extends Machine implements Inter01 {
	public static void main(String[] args) {
//		Object me = new Ex05();							// �θ� ObjectŬ������ �ۼ����� ���� func01()�޼ҵ带 ������ �� ����.
		Inter01 me = new Ex05();						// �������̽��� �����ϴ�
		me.func01();
		
		System.out.println(num1);							// = Inter01.num1 : ����� ������ ��� static�̴�.
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
	}
	
	public void func01() {
		System.out.println("Ex05���� ������ func01");
	}

	public void func02() {}								// �������̽��� �߻�޼ҵ带 ���� �������̵�
	public void func03() {}
}
