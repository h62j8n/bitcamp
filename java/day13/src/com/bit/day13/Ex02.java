package com.bit.day13;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		String data = "";
		String title = "�л������������α׷� (v0.1.0)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		int num = 0;
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				num++;
				System.out.println(num+"�й� ������ �Է�");
				System.out.print("����\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				data += "\n"+num+"\t|"+kor+"\t|"+math+"\t|"+eng;
				
			} else if (input.equals("2")) {
				System.out.print(table);
				System.out.println(data);
			} else if (input.equals("3")) {
				String[] rows = data.split("\n");
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int delIdx = Integer.parseInt(input);
				
				data = "";
				for (int i=0; i<rows.length; i++) {
					if (delIdx == i) {
						System.out.println(input+"�й� ������ ����");
						System.out.print("����\n>");
						input = scan.nextLine();
						int kor = Integer.parseInt(input);
						
						System.out.print("����\n>");
						input = scan.nextLine();
						int eng = Integer.parseInt(input);
						
						System.out.print("����\n>");
						input = scan.nextLine();
						int math = Integer.parseInt(input);
						
						data += "\n"+delIdx+"\t|"+kor+"\t|"+math+"\t|"+eng;
					} else {
						data += "\n"+rows[i];
					}
				}
				data = data.replace("\n\n", "\n");
				
			} else if (input.equals("4")) {
				String[] rows = data.split("\n");			// �迭�� ���̴� �Է��� ���� +1
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int idx = -1;								// �ε����� ���� ���� �־�д�.
				for (int i=0; i<rows.length; i++) {
					if (rows[i].startsWith(input+"\t|")) {	// split �Ŀ��� \n ����
						idx = i;
					}
				}
				
				data = "";
				for (int i=1; i<rows.length; i++) {			// i=1 : 0���� �� "".
					if (idx == i) {continue;}				// ���� �й� �Է����� ���� ����ó������ ��
					data += "\n"+rows[i];
				}
				data = data.replace("\n\n", "\n");
				System.out.println(rows.length);
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
