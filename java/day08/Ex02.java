package com.bit;
class Ex02 {

  // ������ �����ε��� ������ ���� ȣ��
  public Ex02() {
	System.out.println("����0 ������ ȣ�� "+this);
	this.func();
  }
  public Ex02(int a) {
	this(); // ����1 �����ڰ� ����0 �����ڸ� ȣ��. �ݵ�� ������ �� �ֻ�ܿ� ��� ��.
	System.out.println("����1 ������ ȣ�� "+this);
	// �� �����ڿ��� ����� this�� �ּҰ��� �����Ƿ� ��ü�� �������� �� �� �ִ�
//	this(); // Err.
  }

  public static void main(String[] args) {
	new Ex02(100); // �������� ���� ���� �ν��Ͻ� �����ϰ� '����1 ������'�� ȣ����
  }

  public void func() {
	System.out.println("func()");
  }
}