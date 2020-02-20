package com.bit.day15;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ex15 {
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
		String[] subject = {"국어", "영어", "수학"};
		
		Map<Integer, int[]> data = new TreeMap();
		
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
				int[] stu = new int[3];
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
				
				data.put(++num, stu);
				
			} else if (su == 2) {	// 보기
				System.out.println(bar);
				System.out.println("학번\t|국어\t|영어\t|수학");
				System.out.println(bar);
				
				Set<Integer> nums = data.keySet();
				Iterator<Integer> ite = nums.iterator();
				while (ite.hasNext()) {
					int key = ite.next();
					System.out.print(key);
					int[] val = (int[]) data.get(key); // (int[]) 왜 필요하지?
					System.out.print("\t|");
					System.out.print(val[0]);
					System.out.print("\t|");
					System.out.print(val[1]);
					System.out.print("\t|");
					System.out.println(val[2]);
				}
				
			} else if (su == 3) {	// 수정 (삭제 후 끼워넣기)
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);

				int[] stu = new int[3];
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu[i] = Integer.parseInt(input);
				}
				data.put(su, stu);
				
			} else if (su == 4) {	// 삭제
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				data.remove(su);
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("메뉴를 확인하고 0과 4 사이의 값을 입력하세요.");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
