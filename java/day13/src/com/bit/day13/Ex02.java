package com.bit.day13;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		String data = "";
		String title = "학생성적관리프로그램 (v0.1.0)";
		String bar = "----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
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
				
				data += "\n"+num+"\t|"+kor+"\t|"+math+"\t|"+eng;
				
			} else if (input.equals("2")) {
				System.out.print(table);
				System.out.println(data);
			} else if (input.equals("3")) {
				String[] rows = data.split("\n");
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				int delIdx = Integer.parseInt(input);
				
				data = "";
				for (int i=0; i<rows.length; i++) {
					if (delIdx == i) {
						System.out.println(input+"학번 데이터 수정");
						System.out.print("국어\n>");
						input = scan.nextLine();
						int kor = Integer.parseInt(input);
						
						System.out.print("영어\n>");
						input = scan.nextLine();
						int eng = Integer.parseInt(input);
						
						System.out.print("수학\n>");
						input = scan.nextLine();
						int math = Integer.parseInt(input);
						
						data += "\n"+delIdx+"\t|"+kor+"\t|"+math+"\t|"+eng;
					} else {
						data += "\n"+rows[i];
					}
				}
				data = data.replace("\n\n", "\n");
				
			} else if (input.equals("4")) {
				String[] rows = data.split("\n");			// 배열의 길이는 입력한 값의 +1
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				int idx = -1;								// 인덱스에 없는 값을 넣어둔다.
				for (int i=0; i<rows.length; i++) {
					if (rows[i].startsWith(input+"\t|")) {	// split 후에는 \n 삭제
						idx = i;
					}
				}
				
				data = "";
				for (int i=1; i<rows.length; i++) {			// i=1 : 0번은 빈값 "".
					if (idx == i) {continue;}				// 없는 학번 입력했을 시의 예외처리까지 됨
					data += "\n"+rows[i];
				}
				data = data.replace("\n\n", "\n");
				System.out.println(rows.length);
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
