package com.bit.day13;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.1.1)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		int[][] data = {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		int num = 0;
		String[] inputMsg = {"����\n>","����\n>","����\n>"};
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				data[num++][0] = num+1;					// �й� ���� ä����
				
				for (int i=0; i<3; i++) {				// ������ �Է¹���
					System.out.print(inputMsg[i]);
					input = scan.nextLine();
					int su = Integer.parseInt(input);
					data[num][1+i] = su;
				}
				num++;
				
			} else if (input.equals("2")) {
				System.out.println(table);
				for (int i=0; i<data.length; i++) {
					int[] stu = data[i];
					for (int j=0; j<data[i].length; j++) {
						if (j != 0) {System.out.print("\t|");}
						System.out.print(stu[j]);
					}
					System.out.println();
				}
				
			} else if (input.equals("3")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int edit = Integer.parseInt(input);
				int[] stu = data[edit-1];
				stu[0] = edit;
				for (int i=1; i<stu.length; i++) {
					System.out.print(inputMsg[i-1]);
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
			} else if (input.equals("4")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int del = Integer.parseInt(input)-1;			// �迭 �ε���
				int[] stu = data[del];							// ������ �迭 ����
				for (int i=0; i<stu.length; i++) {				// ������ �迭 �ʱ�ȭ
					stu[i] = 0;
				}
			} else {
				
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
