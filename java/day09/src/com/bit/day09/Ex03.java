package com.bit.day09;

public class Ex03 {
	public static void main(String[] args) {
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		String input = null;
	
		System.out.print("�ֹι�ȣ�� �Է��ϼ���.\n>");
		input = scan.nextLine();
		
		final int SIZE = 14;
		int length = input.length();
		boolean middleBar = false;
		
		// ��ȿ�� �˻�
		while (true) {
			if (length == SIZE) {
				middleBar = input.charAt(6) == '-';
				if (!middleBar) {		// '-'�� ���� ���
					System.out.print("����� ��Ȯ�� �Է����ּ���. (��: 000000-0000000)\n>");
					input = scan.nextLine();
				} else {
					break;
				}
				for (int i=0; i<SIZE; i++) {
					
				}
			} else {					// 14�ڸ��� �ƴ� ���
				System.out.print("���ڸ� ��Ȯ�� �Է����ּ���.\n>");
				input = scan.nextLine();
			}
		}		
		
		char[] hangulArr =  {'��', '��', '��', '��', '��', '��', '��', 'ĥ', '��', '��'};
		char gender = '��';
		int age = 2019+1;
		
		char ch1 = input.charAt(0);
		char ch2 = input.charAt(1);
		char ch8 = input.charAt(7);
		int i1 = 0;
		int i2 = 0;
		int i8 = 0;
		
		boolean num = (ch1 >= '0' && ch1 <= '9');
		if (!num) {
			for (int i=0; i<hangulArr.length; i++) {
				if (ch1 == hangulArr[i]) {
					i1 = i;
				}
				if (input.charAt(1) == hangulArr[i]) {
					i2 = i;
				}
				if (input.charAt(7) == hangulArr[i]) {
					i8 = i;
				}
			}
		} else {
			i1 = ch1-'0';
			i2 = ch2-'0';
			i8 = ch8-'0';
		}

		age -= i1*10+i2;
		if (i1==0 || i1==1) {
			age -= 2000;
		} else {
			age -= 1900;
		}
		
		switch (i8) {
		case 1: case 3:
			 gender = '��';
			 break;
		case 2: case 4:
			 gender = '��';
		}
		
		System.out.println("����� "+age+"�� "+gender+"���Դϴ�.");
	}
	public static void toInteger() {}
}
