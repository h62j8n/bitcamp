package com.bit.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex16 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		String[] subject = {"kor", "eng", "math"};
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		List<Map<String, Integer>> data = new ArrayList<>();
		
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
				Map<String, Integer> stu = new HashMap<>();
				stu.put("num", ++num);
				
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu.put(subject[i], Integer.parseInt(input));
				}
				data.add(stu);
				
			} else if (su == 2) {	// ����
				System.out.println(bar);
				System.out.println("�й�\t|����\t|����\t|����");
				System.out.println(bar);
				
				for (int i=0; i<data.size(); i++) {
					Map<String, Integer> stu = data.get(i);
					
					System.out.print(stu.get("num"));
					System.out.print("\t|");
					System.out.print(stu.get("kor"));
					System.out.print("\t|");
					System.out.print(stu.get("eng"));
					System.out.print("\t|");
					System.out.println(stu.get("math"));
				}
				
			} else if (su == 3) {	// ����
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				
				// ���� �� �Է�
				Map<String, Integer> stu = new HashMap<>();
				stu.put("num", su);
				
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu.put(subject[i], Integer.parseInt(input));
				}
				
				// �Է� ���� ������ ����
				for (int i=0; i<data.size(); i++) {
					Map<String, Integer> temp = data.get(i);
					if (su == temp.get("num")) {
						data.set(i, stu);
					}
				}
				
			} else if (su == 4) {	// ����
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				
				for (int i=0; i<data.size(); i++) {
//					if (su == data.get(i).get("num")) {
					Map<String, Integer> temp = data.get(i);	// ������ �ڵ� (�ְ���)
					if (su == temp.get("num")) {
						data.remove(i);
					}
				}
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("�޴��� Ȯ���ϰ� 0�� 4 ������ ���� �Է��ϼ���.");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
