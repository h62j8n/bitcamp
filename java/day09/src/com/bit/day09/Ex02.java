package com.bit.day09;

public class Ex02 {
	public static void main(String[] args) {
		/* �Ʒ� ���� ����� ��
		 abcd
		 �����ٶ�
		 1234
		 !@#$
		 */
		String msg1 = "abcd\n�����ٶ�\n1234\n!@#$";	// ���� ����� ���� �̷���.
		System.out.println(msg1);
		System.out.println("-------------------------");
		
		String msg2 = "";
		int cnt = msg2.length();
		System.out.println(cnt);
		System.out.println("-------------------------");
		
/* .isEmpty()
		boolean empty = false;
		if (cnt == 0) {
			empty = true;
		}
		System.out.println("���ڰ� ����°�? "+empty);
*/		
		boolean empty = msg2.isEmpty();
		System.out.println("���ڰ� ����°�? "+empty);
		System.out.println("-------------------------");
		
		System.out.println(msg1.charAt(0));
		System.out.println(msg1.charAt(5));
		
		char ch = msg1.charAt(5);
		System.out.println(ch);
		System.out.println("-------------------------");
		
//		String msg3 = "abcd";
		String msg3 = "�ѱ�";
		char[] arr3 = msg3.toCharArray();
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println("\n-------------------------");
		
		String msg4;
		msg4 = new String(arr3);
		System.out.println(msg4);
		System.out.println("-------------------------");
		
		byte[] arr4 = msg3.getBytes();
		for (int i=0; i<arr4.length; i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println("\n-------------------------");
		
		for (int i=0; i<arr3.length; i++) {
			System.out.println((int)arr3[i]);
		}
		System.out.println("-------------------------");
		
		String msg5 = new String(arr4);
		System.out.println(msg5);
	}
}
