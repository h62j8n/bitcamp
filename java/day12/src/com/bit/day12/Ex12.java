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
				System.out.println("질려서 바꿈");
				scan = new Scanner(System.in);
			}
			try {
				System.out.print("숫자\n>");
				num = scan.nextInt();
				System.out.println("입력한 수 : "+num);
			} catch (java.util.InputMismatchException e) {			// 예외처리 코드가 없을 경우 무한루프
				System.out.println("고장나서 바꿈");
				scan = new Scanner(System.in);
			}
		}
		
	}
}
