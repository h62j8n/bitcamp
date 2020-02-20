package com.bit.day16;

public class Ex02 {
	public static void main(String[] args) {
		StringBuffer buf1 = new StringBuffer();
		System.out.println(buf1.capacity());		// default : 16
		
		for (int i=0; i<16; i++) {
			buf1.append('a');
			System.out.print(buf1.length()+" : ");
			System.out.println(buf1.capacity());
		}
		
		// ����뷮 �ʰ� ��
		buf1.append('a');
		System.out.print(buf1.length()+" : ");
		System.out.println(buf1.capacity());		// default : 16 �ʰ� ������ ������ ���ڿ� ����(17)�� �ι�� ������� Ȯ��
		buf1.trimToSize();							// .trimToSize() : ����뷮�� �ʰ��� ���ڿ� ���̸�ŭ�� Ȯ��
		System.out.print(buf1.length()+" : ");
		System.out.println(buf1.capacity());
		
		StringBuffer buf2 = new StringBuffer(5);	// StringBuffer ��ü ���� �� �⺻ ��������� 5�� ������ �� �ִ�.
		System.out.println(buf2.capacity());
//		String str = new String(5);					// Err : StringŬ������ ��������� ����. ?

		String str = "javaweb";
		char[] chs = str.toCharArray();
		
		StringBuilder build1 = new StringBuilder("���ڿ�");	// StringBuffer(CharSequence seq)
		StringBuffer buf3 = new StringBuffer(build1);		// : �����ڷ� ����Ŭ������ ���� �� �ֱ� ������ ���� ���� �Ѱܹ��� �� �ִ�.
		
		System.out.println(buf3.capacity());				// ��ü ���� �� ���ڿ��� ����� ��� ��������� �ش� ���ڿ��� ����+16
	}
}
