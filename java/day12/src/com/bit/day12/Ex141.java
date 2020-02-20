package com.bit.day12;
import java.util.Scanner;

public class Ex141 {
	static String data = "";
	
	public static void main(String[] args) {
		// �л������������α׷� (v0.1.0)
		String title = "�л������������α׷� ver0.1.0";
		String bar = "----------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		String table = "�й�\t|����\t|����\t|����\t|�հ�\t|���\t\n----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String input = null;

		int numS = 0;
		while (true) {
			System.out.print("1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>");
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				numS++;
				data += mark(numS);
				
			} else if (input.equals("2")) {
				System.out.println(table+data);
				
			} else if (input.equals("3")) {
				System.out.print("������ �й� �Է�:\n>");
				input = scan.nextLine();
				int numE = Integer.parseInt(input);
				
				data = data.replace(edit(numE), mark(numE));
				
			} else if (input.equals("4")) {
				System.out.print("������ �й� �Է�:\n>");
				input = scan.nextLine();
				int numD = Integer.parseInt(input);
				
				data = data.replace(edit(numD), "");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
	public static String mark(int schoolNum) {
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		System.out.print(schoolNum+"�й� ����\n>");
		input = scan.nextLine();
		int kor = Integer.parseInt(input);
		
		System.out.print(schoolNum+"�й� ����\n>");
		input = scan.nextLine();
		int math = Integer.parseInt(input);
		
		System.out.print(schoolNum+"�й� ����\n>");
		input = scan.nextLine();
		int eng = Integer.parseInt(input);
		
		int sum = kor+eng+math;
		double avg = sum*100/3/100.0;
		
		return "\n"+schoolNum+"\t|"+kor+"\t|"+math+"\t|"+eng+"\t|"+sum+"\t|"+avg+"\t";
	}
	public static String edit(int schoolNum) {
		return data.substring(data.indexOf("\n"+schoolNum), data.indexOf("\n"+(schoolNum+1)));
	}
}
