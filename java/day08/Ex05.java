package com.bit;

class Ex05p {
  int num = 1234;
  public void func() {
	System.out.println("�θ�Ŭ������ ���");
  }
}

class Ex05 extends Ex05p {
  // �������̵�
  int num = 4321;
  public void func() {
	System.out.println("�ڽ�Ŭ������ ���");

  /* #1 �ʵ�� �������̵� ����� �ƴϴ� - ������� ����... */
	System.out.println("num = "+num);
	System.out.println("this.num = "+this.num);
	System.out.println("super.num = "+super.num);


  }

  public static void main(String[] args) {
/*	Ex05 me = new Ex05();
	me.func(); // ����� ���� �θ�Ŭ������ ���ǵ� �޼ҵ� func()�� ������ �� �ִ�.
	System.out.println(me.num);

	this.func();
	super.func();
*/

	final int A = 1234;
	System.out.println("A = "+A);
  }
}