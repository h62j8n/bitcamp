package com.bit.day13;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.1.1)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\t|\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		System.out.print("�� �ο�\n>");
		input = scan.nextLine();
		int tot = Integer.parseInt(input);
		int[][] data = new int[tot][4];
		int num = 0;
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1") && num+1 <= tot) {
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
				
				int[] student = {num,kor,eng,math};
				data[num-1] = student;					// �й��� 1����, �迭�� 0����
				
			} else if (input.equals("1")) {
				System.out.println("���̻� �Է��� �л��� �����ϴ�.");
			} else if (input.equals("2")) {
				System.out.println(table);
				for (int i=0; i<data.length; i++) {
					for (int j=0; j<data[i].length; j++) {
						System.out.print(data[i][j]+"\t|");
					}
					System.out.println();
				}
				
			} else if (input.equals("3")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int edit = Integer.parseInt(input);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				int[] student = {edit,kor,eng,math};
				data[edit-1] = student;
				
			} else if (input.equals("4")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int del = Integer.parseInt(input);
//				int idx = -1;
//				for (int i=0; i<data.length; i++) {
//					if (del == data[i][0]) {idx = i;}		// �迭 ����� �й��� �ε����ѹ� 0
//				}
//				data[idx] = new int[4];						// ������ ���� ������ ���ο� �迭�� �ʱ�ȭ
				data[del-1] = new int[4];					// ������ �й� ��ȣ�� �ε����� �̿��Ͽ� �����ϰ� �ۼ�
				
			} else {
				
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
