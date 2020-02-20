package com.bit.day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		int su = -1;			// parseInt
		int cnt = 3;			// Error count
		int num = 19000;		// 학번
		
		ArrayList data = new ArrayList();
		
		while (true) {
			try {					// input을 Integer 값으로 받지 못할 경우
				System.out.print(menu);
				input = scan.nextLine();
				su = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				if (cnt == 0) {break;}	// 오류가 3회 이상 적발될 경우 프로그램 종료
				cnt--;
				System.out.println("숫자를 입력하세요.");
				continue;			// 다시 처음으로 돌아가서 반복
			}
			if (su == 0) {
				break;
				
			} else if (su == 1) {	// 입력
				num++;
				data.add(num);
				
				System.out.print("국어\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
				System.out.print("영어\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
				System.out.print("수학\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.add(su);
				
			} else if (su == 2) {	// 보기
				System.out.println(bar);
				System.out.println("학번\t|국어\t|영어\t|수학");
				System.out.println(bar);
				for (int i=0; i<data.size(); i+=4) {
					System.out.print(data.get(i));
					System.out.print("\t|");
					System.out.print(data.get(i+1));		// = (i++)
					System.out.print("\t|");
					System.out.print(data.get(i+2));		// = (i++)
					System.out.print("\t|");
					System.out.println(data.get(i+3));		// = (i)
				}
				
			} else if (su == 3) {	// 수정 (삭제 후 끼워넣기)
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				int idx = data.indexOf(su);
				
				System.out.print("국어\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+1);
				data.add(idx+1, su);
				
				System.out.print("영어\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+2);
				data.add(idx+2, su);
				
				System.out.print("수학\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(idx+3);
				data.add(idx+3, su);
				
			} else if (su == 4) {	// 삭제
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				int idx = data.indexOf(su);
				data.remove(idx+3);
				data.remove(idx+2);
				data.remove(idx+1);
				data.remove(idx);
				// 또는 data.remove(idx) * 4
				
			} else {				// 메뉴 범위 내의 숫자가 아닐 경우
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("메뉴를 확인하고 0과 4 사이의 값을 입력하세요.");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
