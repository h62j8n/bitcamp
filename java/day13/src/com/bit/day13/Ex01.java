package com.bit.day13;

import java.util.Scanner;

public class Ex01 {
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
				data += rowString(num, scan);
				
			} else if (input.equals("2")) {
				System.out.print(table);
				System.out.println(data);
				
			} else if (input.equals("3")) {
				data = myReplace("������ �й�\n>", data, scan);
				
			} else if (input.equals("4")) {
				data = myReplace("������ �й�\n>", data, "", scan);
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
	public static String myReplace(String msg, String data, Scanner scan) {
		int enter = inputScan("msg", scan)+1;		// n�й� ������ ������ ����
		
		String input = "\n"+(enter-1)+"\t|";								// ������ ù ����
		int start = data.indexOf(input); 
		int end = data.indexOf("\n", start+1);					// ������ ������ ����
		String target = null;
		try {
			target = data.substring(start, end);
		} catch (StringIndexOutOfBoundsException e) {
			target = data.substring(start);
		}
		String replacement = rowString(enter-1, scan);
		return data.replace(target, replacement);
	}
	public static String myReplace(String msg, String data, String replacement, Scanner scan) {
		int enter = inputScan("msg", scan)+1;					// n�й� ������ ������ ����
		
		String input = "\n"+(enter-1)+"\t|";					// ������ ù ����
		int start = data.indexOf(input); 
		int end = data.indexOf("\n", start+1);					// ������ ������ ����
		String target = null;
		try {
			target = data.substring(start, end);
		} catch (StringIndexOutOfBoundsException e) {
			target = data.substring(start);
		}
		return data.replace(target, replacement);
	}
	public static String rowString(int num, Scanner scan) {
		int kor = inputScan("����\n>", scan);
		int eng = inputScan("����\n>", scan);
		int math = inputScan("����\n>", scan);
		
		return "\n"+num+"\t|"+kor+"\t|"+math+"\t|"+eng;
	}
	public static int inputScan(int start, int end, String msg, Scanner scan) {		// �Է� �޼ҵ�
		int num = -1;
		while (true) {
			System.out.print(msg);
			String input = scan.nextLine();
			num = Integer.parseInt(input);
			if (num >= start && num <= end) {break;};
		}
		return num;
	}
	public static int inputScan(String msg, Scanner scan) {	// ���� �Է� ��. �й� �Է½ÿ��� "1"�� ���� "����" �� ���� ��� �Ű������� �ִ´�.
		return inputScan(0,100,msg,scan);
	}
}
