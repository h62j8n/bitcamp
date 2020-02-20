package com.bit.day13;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.1.1)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		int[][] data = {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		int num = 0;
		String[] inputMsg = {"국어\n>","영어\n>","수학\n>"};
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				data[num++][0] = num+1;					// 학번 먼저 채워둠
				
				for (int i=0; i<3; i++) {				// 데이터 입력받음
					System.out.print(inputMsg[i]);
					input = scan.nextLine();
					int su = Integer.parseInt(input);
					data[num][1+i] = su;
				}
				num++;
				
			} else if (input.equals("2")) {
				System.out.println(table);
				for (int i=0; i<data.length; i++) {
					int[] stu = data[i];
					for (int j=0; j<data[i].length; j++) {
						if (j != 0) {System.out.print("\t|");}
						System.out.print(stu[j]);
					}
					System.out.println();
				}
				
			} else if (input.equals("3")) {
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				int edit = Integer.parseInt(input);
				int[] stu = data[edit-1];
				stu[0] = edit;
				for (int i=1; i<stu.length; i++) {
					System.out.print(inputMsg[i-1]);
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
			} else if (input.equals("4")) {
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				int del = Integer.parseInt(input)-1;			// 배열 인덱스
				int[] stu = data[del];							// 삭제할 배열 생성
				for (int i=0; i<stu.length; i++) {				// 삭제할 배열 초기화
					stu[i] = 0;
				}
			} else {
				
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
