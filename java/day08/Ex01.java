package com.bit;

class Ex01 {
	  static int b = 1234;
	  int a = 100;

	  public static void main(String[] args) {
		  Ex01 my = new Ex01();
		my.plus(20);
		System.out.println("a = "+my.a);
		// 1-3. plus()�޼ҵ��� �Ű����� �� ����� �����ϰ� ������� a�� 100 ���
		// 3-3. �������a+=��������a ���� �� 120 ���

		my.plus(20, my);
		System.out.println("a = "+my.a);
		// 3-6. �������a+=��������a(3-3)�� ���� ��� ���

		System.out.println("b = "+b); 			// = 2-2. com.bit.Ex01.b�� ����
	  }

	  public void plus() {
		a++; // 3-1. this.a++;�� ����
	  }
	  public void plus(int a) { 				// 1-1. ���������� �������� �̸��� ������ ���
//		a+=a; // 1-2. ������� a�� 100�� �ƴ�, �Ű������� ���� �������� ���� (20+20)
		this.a+=a; // 3-2. �������a+=��������a (100+=20)

		b++;
	  }
	  public void plus(int a, Ex01 my) {
		my.a+=a;								// 3-4. this.a+=a(3-2)�� ���� ����
//		System.out.println(this == my);			// 3-5. this�� my(�ڱ��ڽ� ��ü)���� ����
	  }
}