package com.bit;
public class Ex06 {
	public static void main(String[] args) {
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] kor = {'영', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구'};
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		String input = null;
		int age = 0;
		char gender = '여';
		
		do {
			System.out.print("주민번호 입력\n>");
			input = sc.nextLine();					// 최소 1번 실행
			
			char[] inputArray = input.toCharArray();	// 한글 변환
			for (int i=0; i<inputArray.length; i++) {
				for (int j=0; j<kor.length; j++) {
					if (inputArray[i] == kor[j]) {
						inputArray[i] = num[j];		// num[j] = (char)'0'+j;
					}
				}
			}
			input = new String(inputArray);
			
			char ch1 = input.charAt(0);
			char ch2 = input.charAt(1);
			char ch7 = input.charAt(6);
			
			if (ch7 != '-') {
				continue;	// '-'가 없을 시 이후의 반복문 중지, 다시 시작
			}
			if (input.length() != 14) {
				continue;	// 열 네자리가 아닐 경우 중지
			}
			
			boolean check = false;
			for (int i=0; i<input.length(); i++) {
				if (i==6) {continue;}
				if (!Character.isDigit(input.charAt(i))) {
					check = true;
				}
			}
			if (check) {
				continue;
			}

			String year = "";
			if (ch1 == '0' || ch1 == '1') {
				year = "20"+ch1+ch2;
			} else {
				year = "19"+ch1+ch2;
			}
			age = 2019-Integer.parseInt(year)+1;
			
			char ch8 = input.charAt(7);
			if (ch8 == '1' || ch8 =='3') {
				gender = '남';
			} else if (ch8 == '2' || ch8 == '4') {
				
			} else {		// 성별 오류 시 중지
				break;
			}
			
		} while (false);
		System.out.println("당신은 "+age+"세 "+gender+"성입니다.");
		
	}
}
