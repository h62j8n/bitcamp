package com.bit.day15;

import java.util.Scanner;

public class Ex17 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		String[] subject = {"����", "����", "����"};
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
//		ArrayList data = new ArrayList();
		
		while (true) {
			try {
				System.out.print(menu);
				input = scan.nextLine();
				su = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("���ڸ� �Է��ϼ���.");
				continue;
			}
			if (su == 0) {
				break;
			} else if (su == 1) {	// �Է�
				
			} else if (su == 2) {	// ����
				
			} else if (su == 3) {	// ���� (���� �� �����ֱ�)
				
			} else if (su == 4) {	// ����
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("�޴��� Ȯ���ϰ� 0�� 4 ������ ���� �Է��ϼ���.");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
