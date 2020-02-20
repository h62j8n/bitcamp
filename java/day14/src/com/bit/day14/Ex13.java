package com.bit.day14;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex13 {
	public static int inputScan(String msg, Scanner scan) {
		System.out.print(msg);
		int input = scan.nextInt();
		return input;
	}
	public static String rowString(int num, Scanner scan) {
		int kor = inputScan("����\n>", scan);
		int eng = inputScan("����\n>", scan);
		int math = inputScan("����\n>", scan);
		int sum = kor+eng+math;
		double avg = sum*100/3/100.0;
		
		return "\n"+num+"\t|"+kor+"\t|"+eng+"\t|"+math+"\t|"+sum+"\t|"+avg+"\t|";
	}
	public static int checkList(int num, ArrayList list) {
		int result = 0;
		for (int i=0; i<list.size(); i++) {
			String target = (String)list.get(i);
			if (target.contains("\n"+num)) {
				result = i;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// �л� �������� ���α׷� (v0.2.0)
		
		String title = "�л������������α׷� (v0.1.1)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\t|�հ�\t|���\t|\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		ArrayList list = new ArrayList();
		list.add(table);
		
		int num = 0;
		while (true) {
			int input = inputScan(menu, scan);
			
			if (input == 1) {
				num++;
				System.out.println(num+"�й� ������ �Է�");
				String data = rowString(num, scan);
				list.add(data);
				
			} else if (input == 2) {
				for (int i=0; i<list.size(); i++) {
					System.out.print(list.get(i));
				}
				System.out.println();
			} else if (input == 3) {
				int edit = inputScan("������ �й� �Է�\n>", scan);
				int target = checkList(edit, list);
				String data = rowString(edit, scan);

				list.set(target, data);
				
			} else if (input == 4) {
				int del = inputScan("������ �й� �Է�\n>", scan);
				int target = checkList(del, list);
				
				list.remove(list.get(target));
			}
		}
	}
}
