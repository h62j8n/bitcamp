package com.bit.day11;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		// 학생 성적 관리 프로그램 (문자열)
		System.out.println("--------------------------------");
		System.out.println("학생 성적 관리 프로그램 (v0.1.0)");
		System.out.println("--------------------------------");
		
		String data = "|학번\t|국어\t|영어\t|수학\t|";

		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.print("1: 입력 2: 보기 0: 종료\n>");
		input = scan.nextInt();
		
		int count = 0;
		while (input != 0) {
			if (input == 1) {
				count++;
				System.out.print(count+"번 국어\n>");
				int kor = scan.nextInt();
				System.out.print(count+"번 영어\n>");
				int eng = scan.nextInt();
				System.out.print(count+"번 수학\n>");
				int math = scan.nextInt();
				
				data = data+"\n|"+count+"\t|"+String.valueOf(kor)+"\t|"+String.valueOf(eng)+"\t|"+String.valueOf(math)+"\t|";
			} else if (input == 2) {
				System.out.println(data);
			}
			System.out.print("1: 입력 2: 보기 3: 종료\n>");
			input = scan.nextInt();
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
