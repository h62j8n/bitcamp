package com.bit;

class Ex03 { // = class Ex03 extends java.lang.Object { 3. ����� ObjectŬ�������� ��ӹ޴´ٴ� ���� �� �����Ǿ� �־���.
  public static void main(String[] args) {

	Ex03 me = new Ex03();
	System.out.println(me);
	System.out.println(me.toString());
	// 2. �������� me�� ȣ������ �� �ҷ��� ���� ������ ObjectŬ�������� ��ӹ��� toString()�� ����Ѵ�.
	// �̿� ���� me.toString() ��(�ּ��� �ؽ��±װ�)�� �ڵ����� �ҷ��´�.

	Object obj = new Object();
	System.out.println(obj);
	System.out.println(obj.toString());		// 1. ObjectŬ������ toString()�޼ҵ尡 ����ִ�.
	System.out.println(obj.hashCode());		// toString() ���� ���� @ ������ ���� int������ ǥ���� ��
  }
}