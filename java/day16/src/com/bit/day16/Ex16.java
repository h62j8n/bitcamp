package com.bit.day16;

import java.util.Random;

public class Ex16 {
	public static void main(String[] args) {
		Random ran = new Random();
		System.out.println(ran);						// �ּҰ�
		
		System.out.println(ran.nextInt());				// Int ���� ���� ������ �������ͷ�
		System.out.println(ran.nextDouble());			// Double ���� ���� ������ �Ǽ����ͷ� (Math.Random()�� ����)
		
		System.out.println(ran.nextInt(3));				// (0 <= ran && ran <= �Ű�����-1) ����
	}
}
