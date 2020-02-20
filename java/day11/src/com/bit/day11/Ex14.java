package com.bit.day11;
import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		// 학생 성적 관리 프로그램 (배열)
		System.out.println("--------------------------------");
		System.out.println("학생 성적 관리 프로그램 (v0.1.0)");
		System.out.println("--------------------------------");
		
		String[] data = {"|학번\t|국어\t|영어\t|수학\t|총점\t|평균|"};
		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.print("1: 입력 2: 보기 3: 종료\n>");
		input = scan.nextInt();
		
		int count = 0;
		while (input != 3) {
			if (input == 1) {
				count++;

				String[] d = new String[data.length+1];
				for (int i=0; i<data.length; i++) {
					d[i] = data[i];
				}
				
				System.out.print(count+"번 국어\n>");
				int kor = scan.nextInt();
				System.out.print(count+"번 영어\n>");
				int eng = scan.nextInt();
				System.out.print(count+"번 수학\n>");
				int math = scan.nextInt();
				
				Student s = new Student(count, kor, eng, math);
				d[d.length-1] = s.resultToString();
				data = d;
				
			} else if (input == 2) {
				for (int i=0; i<data.length; i++) {
					System.out.println(data[i]);
				}
			}
			System.out.print("1: 입력 2: 보기 3: 종료\n>");
			input = scan.nextInt();
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
