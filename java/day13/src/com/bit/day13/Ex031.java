package com.bit.day13;

import java.util.Scanner;

public class Ex031 {
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
		
		int[][] data = {};
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
				
				int[] student = {num,kor,eng,math};
				
				int[][] students = data;				// ������ �迭 ����
				data = new int[data.length+1][4];		// ���� �迭 �ʱ�ȭ
				for (int i=0; i<students.length; i++) {	// �迭 ����
					data[i] = students[i];
				}
				data[data.length-1] = student;			// ������ �迭�� ���ο� �� �߰�
				
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
				int idx = Integer.parseInt(input)-1;		// -1 : �ε��� �ѹ�
				int[][] students = data;					// �迭 ���
				data = new int[data.length-1][];			// 1�� �����ҰŴϱ� 1�� ª�� �� �迭�� ��ü
				
				for (int i=0; i<idx; i++) {					// �迭 ���� (�ε��� �ѹ� ����)
//					if (i == idx) {}					// ����: �ε��� �迭�� ����
					data[i] = students[i];
				}
				for (int i=idx; i<data.length; i++) {		// �迭 ���� (�ε��� �ѹ� ����)
					data[i] = students[i];					// �ε����ѹ��� ���翡�� ������
				}
				
			} else {
				
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
