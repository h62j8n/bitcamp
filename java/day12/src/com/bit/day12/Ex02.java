package com.bit.day12;

public class Ex02 {
	int su = 1234;
	public void func01() {
		System.out.println("func01");
	}
	public static void main(String[] args) {
		Object me = new Ex02();
//		me.func01();
//		�θ� ObjectŬ������ ���ǵ� �޼ҵ尡 �ƴϾ ����� �� ����
		System.out.println(me.toString());
//		�θ� ObjectŬ������ ���ǵ� �޼ҵ�� ����� �� ����
		System.out.println(((Ex02)me).su);
//		����ȯ �� �ʵ� ��� ����
		
		System.out.println("-----");
		
		int su1 = 6;
		int su2 = 2;
		double su3 = 1.5;
		double su4 = 0.5;
		Number su5 = new Integer(su1);								// ������. �θ� NumberŸ���� Integer��ü ������ ����
		Number su6 = new Integer(su2);
		System.out.println(su1+"+"+su2+"="+plus(su1, su2));
		System.out.println(su1+"+"+su2+"="+plus(su1, su4));			// ���� su1�� ����ĳ����, plus(double, double)�� ����
		System.out.println(su1+"-"+su2+"="+minus(su1, su2));
		System.out.println(su1+"x"+su2+"="+multi(su1, su2));
		System.out.println(su1+"��"+su2+"="+div(su1, su2));
		System.out.println(su3+"��"+su2+"="+div(su3, su2));
	}
	public static Number div(int a, int b) {						// �������� ���� �θ�Ÿ�� Number�� ����Ÿ������ ���� �� ����
		if (a%b == 0) {			// ������ �������� ������
			return a/b;
		} else {
			return a*1.0/b;		// �׷��� ������ �Ǽ���
		}
	}
	public static Number div(double a, double b) {
		if (a%b == 0) {			// ������ �������� ������
			return a/b;
		} else {
			return a*1.0/b;		// �׷��� ������ �Ǽ���
		}
	}
	public static int multi(int a, int b) {
		return a*b;
	}
	public static int plus(int a, int b) {
		return a+b;
	}
	public static double plus(double a, double b) {
		return a+b;
	}
	public static int minus(int a, int b) {
		return a-b;
	}
}
