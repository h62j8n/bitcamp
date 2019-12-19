package com.bit.day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		String title = "�л������������α׷� (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		int su = -1;			// parseInt
		int cnt = 3;			// Error count
		int num = 19000;		// �й�
		
		ArrayList data = new ArrayList();
		
		while (true) {
			try {					// input�� Integer ������ ���� ���� ���
				System.out.print(menu);
				input = scan.nextLine();
				su = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				if (cnt == 0) {break;}	// ������ 3ȸ �̻� ���ߵ� ��� ���α׷� ����
				cnt--;
				System.out.println("���ڸ� �Է��ϼ���.");
				continue;			// �ٽ� ó������ ���ư��� �ݺ�
			}
			if (su == 0) {
				break;
				
			} else if (su == 1) {	// �Է�
				num++;
				data.add(num);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
			} else if (su == 2) {	// ����
				System.out.println(bar);
				System.out.println("�й�\t|����\t|����\t|����");
				System.out.println(bar);
				for (int i=0; i<data.size(); i+=4) {
					System.out.print(data.get(i));
					System.out.print("\t|");
					System.out.print(data.get(i+1));		// = (i++)
					System.out.print("\t|");
					System.out.print(data.get(i+2));		// = (i++)
					System.out.print("\t|");
					System.out.println(data.get(i+3));		// = (i)
				}
				
			} else if (su == 3) {	// ���� (���� �� �����ֱ�)
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				int idx = data.indexOf(su);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+1);
				data.add(idx+1, su);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+2);
				data.add(idx+2, su);
				
				System.out.print("����\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+3);
				data.add(idx+3, su);
				
			} else if (su == 4) {	// ����
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				int idx = data.indexOf(su);
				data.remove(idx+3);
				data.remove(idx+2);
				data.remove(idx+1);
				data.remove(idx);
				// �Ǵ� data.remove(idx) * 4
				
			} else {				// �޴� ���� ���� ���ڰ� �ƴ� ���
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("�޴��� Ȯ���ϰ� 0�� 4 ������ ���� �Է��ϼ���.");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
