package com.bit.day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		
		ArrayList<int[]> data = new ArrayList<>();			// 제네릭<Integer>
		
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
				int[] stu = new int[4];
				stu[0] = ++num;
				System.out.print("국어\n>");
				input = scan.nextLine();
				stu[1] = Integer.parseInt(input);
				System.out.print("영어\n>");
				input = scan.nextLine();
				stu[2] = Integer.parseInt(input);
				System.out.print("수학\n>");
				input = scan.nextLine();
				stu[3] = Integer.parseInt(input);
				
				data.add(stu);
				
			} else if (su == 2) {	// 보기
				System.out.println(bar);
				System.out.println("학번\t|국어\t|영어\t|수학");
				System.out.println(bar);
				for (int i=0; i<data.size(); i++) {
					int[] stu = data.get(i);
					System.out.println(stu[0]+"\t|"+stu[1]+"\t|"+stu[2]+"\t|"+stu[3]);
				}
				
			} else if (su == 3) {	// 수정 (삭제 후 끼워넣기)
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				int temp = Integer.parseInt(input);
				int idx = -1;
				for (int i=0; i<data.size(); i++) {
					if (data.get(i)[0] == temp) {idx = i;}
				}
				data.remove(idx);
				
				int[] stu = new int[4];
				stu[0] = temp;
				System.out.print("국어\n>");
				input = scan.nextLine();
				stu[1] = Integer.parseInt(input);
				System.out.print("영어\n>");
				input = scan.nextLine();
				stu[2] = Integer.parseInt(input);
				System.out.print("수학\n>");
				input = scan.nextLine();
				stu[3] = Integer.parseInt(input);
				
				data.add(idx, stu);
				
			} else if (su == 4) {	// 삭제
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				int temp = Integer.parseInt(input);
				int idx = -1;								// 배열 인덱스에 존재하지 않는 임의의 수
				for (int i=0; i<data.size(); i++) {
					if (data.get(i)[0] == temp) {idx = i;}	// 입력 값과 동일한 학번 찾아서 저장
				}
				data.remove(idx);
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("메뉴를 확인하고 0과 4 사이의 값을 입력하세요.");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
