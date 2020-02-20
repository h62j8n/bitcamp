package com.bit.day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		
		ArrayList<int[]> data = new ArrayList<>();			// ���׸�<Integer>
		
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
				int[] stu = new int[4];
				stu[0] = ++num;
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[1] = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[2] = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[3] = Integer.parseInt(input);
				
				data.add(stu);
				
			} else if (su == 2) {	// ����
				System.out.println(bar);
				System.out.println("�й�\t|����\t|����\t|����");
				System.out.println(bar);
				for (int i=0; i<data.size(); i++) {
					int[] stu = data.get(i);
					System.out.println(stu[0]+"\t|"+stu[1]+"\t|"+stu[2]+"\t|"+stu[3]);
				}
				
			} else if (su == 3) {	// ���� (���� �� �����ֱ�)
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int temp = Integer.parseInt(input);
				int idx = -1;
				for (int i=0; i<data.size(); i++) {
					if (data.get(i)[0] == temp) {idx = i;}
				}
				data.remove(idx);
				
				int[] stu = new int[4];
				stu[0] = temp;
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[1] = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[2] = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				stu[3] = Integer.parseInt(input);
				
				data.add(idx, stu);
				
			} else if (su == 4) {	// ����
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int temp = Integer.parseInt(input);
				int idx = -1;								// �迭 �ε����� �������� �ʴ� ������ ��
				for (int i=0; i<data.size(); i++) {
					if (data.get(i)[0] == temp) {idx = i;}	// �Է� ���� ������ �й� ã�Ƽ� ����
				}
				data.remove(idx);
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("�޴��� Ȯ���ϰ� 0�� 4 ������ ���� �Է��ϼ���.");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
