package com.bit.day11;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		// �л� ���� ���� ���α׷� (���ڿ�)
		System.out.println("--------------------------------");
		System.out.println("�л� ���� ���� ���α׷� (v0.1.0)");
		System.out.println("--------------------------------");
		
		String data = "|�й�\t|����\t|����\t|����\t|";

		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.print("1: �Է� 2: ���� 0: ����\n>");
		input = scan.nextInt();
		
		int count = 0;
		while (input != 0) {
			if (input == 1) {
				count++;
				System.out.print(count+"�� ����\n>");
				int kor = scan.nextInt();
				System.out.print(count+"�� ����\n>");
				int eng = scan.nextInt();
				System.out.print(count+"�� ����\n>");
				int math = scan.nextInt();
				
				data = data+"\n|"+count+"\t|"+String.valueOf(kor)+"\t|"+String.valueOf(eng)+"\t|"+String.valueOf(math)+"\t|";
			} else if (input == 2) {
				System.out.println(data);
			}
			System.out.print("1: �Է� 2: ���� 3: ����\n>");
			input = scan.nextInt();
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
