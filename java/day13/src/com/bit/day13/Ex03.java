package com.bit.day13;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.1.1)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\t|\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		System.out.print("총 인원\n>");
		input = scan.nextLine();
		int tot = Integer.parseInt(input);
		int[][] data = new int[tot][4];
		int num = 0;
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1") && num+1 <= tot) {
				num++;
				System.out.println(num+"학번 데이터 입력");
				System.out.print("국어\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				
				System.out.print("영어\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				
				System.out.print("수학\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				int[] student = {num,kor,eng,math};
				data[num-1] = student;					// 학번은 1부터, 배열은 0부터
				
			} else if (input.equals("1")) {
				System.out.println("더이상 입력할 학생이 없습니다.");
			} else if (input.equals("2")) {
				System.out.println(table);
				for (int i=0; i<data.length; i++) {
					for (int j=0; j<data[i].length; j++) {
						System.out.print(data[i][j]+"\t|");
					}
					System.out.println();
				}
				
			} else if (input.equals("3")) {
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				int edit = Integer.parseInt(input);
				
				System.out.print("국어\n>");
				input = scan.nextLine();
				int kor = Integer.parseInt(input);
				
				System.out.print("영어\n>");
				input = scan.nextLine();
				int eng = Integer.parseInt(input);
				
				System.out.print("수학\n>");
				input = scan.nextLine();
				int math = Integer.parseInt(input);
				
				int[] student = {edit,kor,eng,math};
				data[edit-1] = student;
				
			} else if (input.equals("4")) {
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				int del = Integer.parseInt(input);
//				int idx = -1;
//				for (int i=0; i<data.length; i++) {
//					if (del == data[i][0]) {idx = i;}		// 배열 요소인 학번의 인덱스넘버 0
//				}
//				data[idx] = new int[4];						// 기존과 같은 길이의 새로운 배열로 초기화
				data[del-1] = new int[4];					// 삭제할 학번 번호와 인덱스를 이용하여 간단하게 작성
				
			} else {
				
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
