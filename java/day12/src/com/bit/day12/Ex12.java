package com.bit.day12;
import java.util.Scanner;

public class Ex12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 1;
		int cnt = 0;
		while (true) {
			cnt++;
			if (cnt == 10) {
				cnt = 0;
				System.out.println("������ �ٲ�");
				scan = new Scanner(System.in);
			}
			try {
				System.out.print("����\n>");
				num = scan.nextInt();
				System.out.println("�Է��� �� : "+num);
			} catch (java.util.InputMismatchException e) {			// ����ó�� �ڵ尡 ���� ��� ���ѷ���
				System.out.println("���峪�� �ٲ�");
				scan = new Scanner(System.in);
			}
		}
		
	}
}
