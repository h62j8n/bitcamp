package com.bit.day11;
import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		// �л� ���� ���� ���α׷� (�迭)
		System.out.println("--------------------------------");
		System.out.println("�л� ���� ���� ���α׷� (v0.1.0)");
		System.out.println("--------------------------------");
		
		String[] data = {"|�й�\t|����\t|����\t|����\t|����\t|���|"};
		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.print("1: �Է� 2: ���� 3: ����\n>");
		input = scan.nextInt();
		
		int count = 0;
		while (input != 3) {
			if (input == 1) {
				count++;

				String[] d = new String[data.length+1];
				for (int i=0; i<data.length; i++) {
					d[i] = data[i];
				}
				
				System.out.print(count+"�� ����\n>");
				int kor = scan.nextInt();
				System.out.print(count+"�� ����\n>");
				int eng = scan.nextInt();
				System.out.print(count+"�� ����\n>");
				int math = scan.nextInt();
				
				Student s = new Student(count, kor, eng, math);
				d[d.length-1] = s.resultToString();
				data = d;
				
			} else if (input == 2) {
				for (int i=0; i<data.length; i++) {
					System.out.println(data[i]);
				}
			}
			System.out.print("1: �Է� 2: ���� 3: ����\n>");
			input = scan.nextInt();
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}
