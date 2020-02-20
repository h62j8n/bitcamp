package com.bit.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex16 {
	public static void main(String[] args) {
		String title = "학생성적관리프로그램 (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		int su = -1;
		int cnt = 3;
		int num = 19000;
		String[] subject = {"kor", "eng", "math"};
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		List<Map<String, Integer>> data = new ArrayList<>();
		
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
				Map<String, Integer> stu = new HashMap<>();
				stu.put("num", ++num);
				
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu.put(subject[i], Integer.parseInt(input));
				}
				data.add(stu);
				
			} else if (su == 2) {	// 보기
				System.out.println(bar);
				System.out.println("학번\t|국어\t|영어\t|수학");
				System.out.println(bar);
				
				for (int i=0; i<data.size(); i++) {
					Map<String, Integer> stu = data.get(i);
					
					System.out.print(stu.get("num"));
					System.out.print("\t|");
					System.out.print(stu.get("kor"));
					System.out.print("\t|");
					System.out.print(stu.get("eng"));
					System.out.print("\t|");
					System.out.println(stu.get("math"));
				}
				
			} else if (su == 3) {	// 수정
				System.out.print("수정할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				
				// 수정 값 입력
				Map<String, Integer> stu = new HashMap<>();
				stu.put("num", su);
				
				for (int i=0; i<subject.length; i++) {
					System.out.print(subject[i]+"\n>");
					input = scan.nextLine();
					stu.put(subject[i], Integer.parseInt(input));
				}
				
				// 입력 받은 값으로 변경
				for (int i=0; i<data.size(); i++) {
					Map<String, Integer> temp = data.get(i);
					if (su == temp.get("num")) {
						data.set(i, stu);
					}
				}
				
			} else if (su == 4) {	// 삭제
				System.out.print("삭제할 학번\n>");
				input = scan.nextLine();
				su = Integer.parseInt(input);
				
				for (int i=0; i<data.size(); i++) {
//					if (su == data.get(i).get("num")) {
					Map<String, Integer> temp = data.get(i);	// 직관성 코드 (주관적)
					if (su == temp.get("num")) {
						data.remove(i);
					}
				}
				
			} else {
				if (cnt == 0) {break;}
				cnt--;
				System.out.println("메뉴를 확인하고 0과 4 사이의 값을 입력하세요.");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
}
