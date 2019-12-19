package com.bit.day09;

public class Ex01 {
	public static void main(String[] args) {

//		msg1 = new String();	// ��: "" (���ڰ� ���� ���ڿ�. null�� �ٸ���)
		String msg1 = "abcd";
		String msg2 = new String("abcd");
		String msg3 = "abcd";
		String msg4 = new String(msg1);				// �޼ҵ念��, new�� �Բ� ����ǹǷ� ���ο� �ּҰ� ����

		System.out.print("msg1 == msg2\t\t: ");
		System.out.println(msg1 == msg2);			// false. ��������(��ü�� ��ü)�� ��
		
		System.out.print("msg1 == msg3\t\t: ");
		System.out.println(msg1 == msg3);			// true. Ŭ���� ����. ���� ��ü(������ �ּҰ�)
		// ���α׷� ���� �� �ʱ�ȭ�� ���ڿ����� ��� �ּҰ����� �־�δµ� �̶� ���� ���ڿ��� ���� �ּҿ� ����
		
		System.out.print("msg1.equals(msg2)\t: ");
		System.out.println(msg1.equals(msg2));		// true. ���ڿ����ͷ��� ��
		
		System.out.print("msg1 == msg4\t\t: ");
		System.out.println(msg1 == msg4);			// false. �޼ҵ念��. �ּҰ� �ٸ�
		
		System.out.print("\"abcd\".equals(msg1)\t: ");
		System.out.println("abcd".equals(msg1));	// true. ������ ���ڿ�
		
		
		// .equals()�� ��� ������(==)
		String msg5 = "ab"+"cd";
		String msg6 = "ab".concat("cd");
		
		System.out.print("msg5 == \"abcd\"\t\t: ");
		System.out.println(msg5 == "abcd");			// true. ���������� ���ͷ��� ���������� ��Ģ������ �Ұ��� ������ ���ڿ��� ���������� ����
		
		System.out.print("msg6 == \"abcd\"\t\t: ");
		System.out.println(msg6 == "abcd");			// false. ���ο� ��ü ����.
		
		// �ּ� �� �񱳿� ���ڿ� �� ��
		Ex01 me = new Ex01();
		Ex01 you = me;

		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print(">");
		String msg7 = scan.nextLine();				// "java"
		
		System.out.print("me == you\t\t: ");
		System.out.println(me == you);				// true. �������� me�� you�� ���� ��ü�� ����Ų��.
		
		System.out.print("msg7 == \"java\"\t\t: ");
		System.out.println(msg7 == "java");			// false. msg7�� "java"�� �ּҰ��� �ٸ���.
		
		System.out.print("msg7.equals(\"java\")\t: ");
		System.out.println(msg7.equals("java"));	// true. ���ڿ� �� ��
	}
}
