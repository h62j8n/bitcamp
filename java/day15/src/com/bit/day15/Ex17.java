package com.bit.day15;

import java.util.Scanner;

public class Ex17 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		String[] subject = {"국어", "영어", "수학"};
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
//		ArrayList data = new ArrayList();
		
		while (true) {
			try {
				System.out.print(menu);
				input = scan.nextLine();
				su = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("숫자를 입력하세요.");
				continue;
			}
			if (su == 0) {
				break;
			} else if (su == 1) {	// 입력
				
			} else if (su == 2) {	// 보기
				
			} else if (su == 3) {	// 수정 (삭제 후 끼워넣기)
				
			} else if (su == 4) {	// 삭제
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("메뉴를 확인하고 0과 4 사이의 값을 입력하세요.");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
