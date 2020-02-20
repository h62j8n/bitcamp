package com.bit.day14;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex13 {
	public static int inputScan(String msg, Scanner scan) {
		System.out.print(msg);
		int input = scan.nextInt();
		return input;
	}
	public static String rowString(int num, Scanner scan) {
		int kor = inputScan("국어\n>", scan);
		int eng = inputScan("영어\n>", scan);
		int math = inputScan("수학\n>", scan);
		int sum = kor+eng+math;
		double avg = sum*100/3/100.0;
		
		return "\n"+num+"\t|"+kor+"\t|"+eng+"\t|"+math+"\t|"+sum+"\t|"+avg+"\t|";
	}
	public static int checkList(int num, ArrayList list) {
		int result = 0;
		for (int i=0; i<list.size(); i++) {
			String target = (String)list.get(i);
			if (target.contains("\n"+num)) {
				result = i;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// 학생 성적관리 프로그램 (v0.2.0)
		
		String title = "학생성적관리프로그램 (v0.1.1)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\t|합계\t|평균\t|\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		ArrayList list = new ArrayList();
		list.add(table);
		
		int num = 0;
		while (true) {
			int input = inputScan(menu, scan);
			
			if (input == 1) {
				num++;
				System.out.println(num+"학번 데이터 입력");
				String data = rowString(num, scan);
				list.add(data);
				
			} else if (input == 2) {
				for (int i=0; i<list.size(); i++) {
					System.out.print(list.get(i));
				}
				System.out.println();
			} else if (input == 3) {
				int edit = inputScan("수정할 학번 입력\n>", scan);
				int target = checkList(edit, list);
				String data = rowString(edit, scan);

				list.set(target, data);
				
			} else if (input == 4) {
				int del = inputScan("삭제할 학번 입력\n>", scan);
				int target = checkList(del, list);
				
				list.remove(list.get(target));
			}
		}
	}
}
