package com.bit.day15;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ex15 {
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
		String[] subject = {"����", "����", "����"};
		
		Map<Integer, int[]> data = new TreeMap();
		
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
				int[] stu = new int[3];
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
				
				data.put(++num, stu);
				
			} else if (su == 2) {	// ����
				System.out.println(bar);
				System.out.println("�й�\t|����\t|����\t|����");
				System.out.println(bar);
				
				Set<Integer> nums = data.keySet();
				Iterator<Integer> ite = nums.iterator();
				while (ite.hasNext()) {
					int key = ite.next();
					System.out.print(key);
					int[] val = (int[]) data.get(key); // (int[]) �� �ʿ�����?
					System.out.print("\t|");
					System.out.print(val[0]);
					System.out.print("\t|");
					System.out.print(val[1]);
					System.out.print("\t|");
					System.out.println(val[2]);
				}
				
			} else if (su == 3) {	// ���� (���� �� �����ֱ�)
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);

				int[] stu = new int[3];
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
				data.put(su, stu);
				
			} else if (su == 4) {	// ����
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(su);
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("�޴��� Ȯ���ϰ� 0�� 4 ������ ���� �Է��ϼ���.");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
