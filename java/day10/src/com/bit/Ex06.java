package com.bit;
public class Ex06 {
	public static void main(String[] args) {
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] kor = {'��', '��', '��', '��', '��', '��', '��', 'ĥ', '��', '��'};
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		String input = null;
		int age = 0;
		char gender = '��';
		
		do {
			System.out.print("�ֹι�ȣ �Է�\n>");
			input = sc.nextLine();					// �ּ� 1�� ����
			
			char[] inputArray = input.toCharArray();	// �ѱ� ��ȯ
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
				continue;	// '-'�� ���� �� ������ �ݺ��� ����, �ٽ� ����
			}
			if (input.length() != 14) {
				continue;	// �� ���ڸ��� �ƴ� ��� ����
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
				gender = '��';
			} else if (ch8 == '2' || ch8 == '4') {
				
			} else {		// ���� ���� �� ����
				break;
			}
			
		} while (false);
		System.out.println("����� "+age+"�� "+gender+"���Դϴ�.");
		
	}
}
