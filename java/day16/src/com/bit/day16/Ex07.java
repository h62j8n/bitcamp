package com.bit.day16;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		// �����������α׷� (v0.4.0)
		
		String title = "�л������������α׷� (v0.4.0)";
		String bar = "--------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		StringBuffer data = new StringBuffer(table);
		int num = 0;
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
				
			} else if (input.equals("1")) {
				num++;
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				String value = "\n"+num+"\t|"+kor+"\t|"+eng+"\t|"+math;
				data.append(value);

			} else if (input.equals("2")) {
				System.out.println(data);
				
			} else if (input.equals("3")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int edit = Integer.parseInt(input);
				
				int start = data.indexOf("\n"+edit);
				int end = data.indexOf("\n"+(edit+1));
				if (end == -1) {
					end = data.length();
				}
				
				System.out.print("����\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				System.out.print("����\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				String value = "\n"+edit+"\t|"+kor+"\t|"+eng+"\t|"+math;
				
				data.replace(start, end, value);
				
			} else if (input.equals("4")) {
				System.out.print("������ �й�\n>");
				input = scan.nextLine();
				int del = Integer.parseInt(input);
				
				int start = data.indexOf("\n"+del);
				int end = data.indexOf("\n"+(del+1));
				if (end == -1) {
					end = data.length();
				}
				
				data.delete(start, end);
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
