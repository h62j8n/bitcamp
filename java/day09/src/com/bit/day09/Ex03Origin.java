package com.bit.day09;

public class Ex03Origin {
		public static void main(String[] args) {

			java.util.Scanner scan = new java.util.Scanner(System.in);
			String input = null;
			
			System.out.print("�ֹι�ȣ�� �Է��ϼ���.\n>");
			input = scan.nextLine();
			
			final int SIZE = 14;
			int length = input.length();
			boolean middleBar = false;
			
			char gender = '��';
			int age = 2019+1;
			char ch1 = input.charAt(0);
			char ch2 = input.charAt(1);
			char ch8 = input.charAt(7);
			
			age -= (ch1-'0')*10+(ch2-'0');		// -'0' : charŸ�� ���ڸ� intŸ�� ������ ����ϱ� ����.
			if (ch1=='0' || ch1=='1') {
				age -= 2000;
			} else {
				age -= 1900;
			}
			
			switch (ch8) {
				case '1': case '3':
					 gender = '��';
					 break;
				case '2': case '4':
					 gender = '��';
			}
			System.out.println("����� "+age+"�� "+gender+"���Դϴ�.");
		}
	}
