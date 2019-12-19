package com.bit.day13;

import java.util.Scanner;

public class Ex031 {
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
		
		int[][] data = {};
		int num = 0;
		while (true) {
			System.out.print(menu);
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
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
				
				int[][] students = data;				// 복사할 배열 생성
				data = new int[data.length+1][4];		// 기존 배열 초기화
				for (int i=0; i<students.length; i++) {	// 배열 복사
					data[i] = students[i];
				}
				data[data.length-1] = student;			// 복사한 배열에 새로운 값 추가
				
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
				int idx = Integer.parseInt(input)-1;		// -1 : 인덱스 넘버
				int[][] students = data;					// 배열 백업
				data = new int[data.length-1][];			// 1개 삭제할거니까 1개 짧은 새 배열로 교체
				
				for (int i=0; i<idx; i++) {					// 배열 복사 (인덱스 넘버 이전)
//					if (i == idx) {}					// 수정: 인덱스 배열만 변경
					data[i] = students[i];
				}
				for (int i=idx; i<data.length; i++) {		// 배열 복사 (인덱스 넘버 이후)
					data[i] = students[i];					// 인덱스넘버는 복사에서 제외함
				}
				
			} else {
				
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
