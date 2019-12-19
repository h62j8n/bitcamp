package com.bit.day09;

public class Ex03Origin {
		public static void main(String[] args) {

			java.util.Scanner scan = new java.util.Scanner(System.in);
			String input = null;
			
			System.out.print("주민번호를 입력하세요.\n>");
			input = scan.nextLine();
			
			final int SIZE = 14;
			int length = input.length();
			boolean middleBar = false;
			
			char gender = '남';
			int age = 2019+1;
			char ch1 = input.charAt(0);
			char ch2 = input.charAt(1);
			char ch8 = input.charAt(7);
			
			age -= (ch1-'0')*10+(ch2-'0');		// -'0' : char타입 숫자를 int타입 값으로 출력하기 위함.
			if (ch1=='0' || ch1=='1') {
				age -= 2000;
			} else {
				age -= 1900;
			}
			
			switch (ch8) {
				case '1': case '3':
					 gender = '남';
					 break;
				case '2': case '4':
					 gender = '여';
			}
			System.out.println("당신은 "+age+"세 "+gender+"성입니다.");
		}
	}
