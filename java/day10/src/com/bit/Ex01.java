package com.bit;

public class Ex01 {
	public static void main(String[] args) {
		java.lang.Integer num1;
		
		num1 = new Integer("100");
		System.out.println(num1);			// "100"�̶�� ���ڿ��� �־����� Integer ������ ����
		
		num1 = new Integer(100);			// ?? ��Ű���� ��������
		Integer num2 = new Integer("200");
		// # ���䷡�� / �ڽ�
		Integer num3 = 100;					// ����Ÿ��(Integer)�� ���ͷ�Ÿ��(int) ����ġ(��Ģ�� �Ұ���) > auto wrapping(boxing)
		
		// # ���� / ��ڽ�
		System.out.println(num1+1);			// (Integer)100 + (int)1 > Unwrapping : (int)100 + (int)1 
		System.out.println(num1+num2);		// (Integer)100 + (Integer)200 > Unwrapping : (int)100+(int)200
		int b = num2+num3;
		
		// API Integer fields
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		
		// API Integer method
		Integer num4 = new Integer("100");
		byte b1 = num4.byteValue();			// ??(num4-����� ǥ��)�� byte�� �� ���
		System.out.println(num4+" : "+b1);
		
		System.out.println(num1 == num4);	// value��/���۷����� ��. unwrapping �ߴٰ� �ؼ� ���� ���� ���� �ƴ�
		System.out.println(num1.equals(num4));
		
		String msg = "1234";
		Integer num5 = Integer.valueOf(msg);// valueOf(String s) : ���ڸ� ������ ���ڿ��� Integer������ ��ȯ 
		System.out.println(num5);
		System.out.println(num5.intValue());// Integer�� ���� int�� ������ ��ȯ
		
		int num6 = Integer.max(2, 3);		// �Ķ������ �� �� �� ū ���� ��ȯ
		System.out.println(num6);
		
		int num7 = Integer.parseInt(msg);	// ?? int�� ��ȯ
		int num8 = Integer.valueOf(msg);	// ?? ���� �Ŀ� int�� ��ȯ (jdk ���� ȣȯ���� ����)
		
		int num9 = Integer.reverse(num7);	// ��Ʈ���� �Ųٷ� ��ȯ ���� �� ��
		
		int num10 = 16;						// ���� ��ȯ �޼ҵ�
		System.out.println(num10+"�� 2���� : "+Integer.toBinaryString(num10));
		System.out.println(num10+"�� 8���� : "+Integer.toOctalString(num10));
		System.out.println(num10+"�� 16���� : "+Integer.toHexString(num10));
		
		int num11 = Integer.compare(1, 1);	// static
		System.out.println(num11);
		int num12 = num4.compareTo(99);		// non-static
		System.out.println(num12);
		
	}
}
