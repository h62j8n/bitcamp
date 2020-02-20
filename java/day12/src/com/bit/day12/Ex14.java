package com.bit.day12;
import java.util.Scanner;

public class Ex14 {
	
	public static void main(String[] args) {
		// �л������������α׷� (v0.1.0)
		String title = "�л������������α׷� ver0.1.0";
		String bar = "----------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		String table = "�й�\t|����\t|����\t|����\t|�հ�\t|���\n----------------------------------------------";
		String data = "";
		
//		                                        ||                              ||
//		data = "1\t|88\t|97\t|100\t|285\t|95.0\t\n2\t|42\t|30\t|86\t|158\t|52.66\n3\t|100\t|98\t|76\t|274\t|91.33";
		
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
				
				String result = mark(numS);
				data += result;
				
			} else if (input.equals("2")) {
				System.out.println(table+data);
				
			} else if (input.equals("3")) {
				System.out.print("������ �й� �Է�:\n>");
				input = scan.nextLine();
				int numE = Integer.parseInt(input);
				
				int start = data.indexOf("\n"+numE);
				int end = 0;
				if (numE == numS) {
					end = data.length();
				} else {
					end = data.indexOf("\n"+numE+1);
				}
				String target = data.substring(start, end);
				String result = mark(numE);
				data = data.replace(target, result);
				
			} else if (input.equals("4")) {
				System.out.print("������ �й� �Է�:\n>");
				input = scan.nextLine();
				int numD = Integer.parseInt(input);
				
				int start = data.indexOf("\n"+numD);
				int end = 0;
				if (numD == numS) {
					end = data.length();
				} else {
					end = data.indexOf("\n"+numD+1);
				}
				System.out.println("start:"+start+", end:"+end+"data.length():"+data.length());
				String target = data.substring(start, end);
				data = data.replace(target, "");
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
	public static String mark(int scNum) {
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		System.out.print(scNum+"�й� ����\n>");
		input = scan.nextLine();
		int kor = Integer.parseInt(input);
		
		System.out.print(scNum+"�й� ����\n>");
		input = scan.nextLine();
		int math = Integer.parseInt(input);
		
		System.out.print(scNum+"�й� ����\n>");
		input = scan.nextLine();
		int eng = Integer.parseInt(input);
		
		int sum = kor+eng+math;
		double avg = sum*100/3/100.0;
		
		return "\n"+scNum+"\t|"+kor+"\t|"+math+"\t|"+eng+"\t|"+sum+"\t|"+avg;
	}
}
