package com.bit.day15;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ex130 {
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
		
		return kor+"\t|"+eng+"\t|"+math+"\t|"+sum+"\t|"+avg+"\t|";
	}
	public static void getList(Map<Integer, String> map) {
		Set<Integer> keys = map.keySet();
		ArrayList<Integer> list = new ArrayList<>(keys);
		for (int i=0; i<list.size(); i++) {
			Integer key = list.get(i);
			if (i!=0) {
				System.out.print("\n"+key+"\t|");
			}
			System.out.print(map.get(key));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// 학생 성적관리 프로그램 (v0.3.0)
		
		String title = "학생성적관리프로그램 (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\t|합계\t|평균\t|\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Map<Integer, String>map = new TreeMap<Integer, String>();
		map.put(0, table);
		
		int num = 0;
		while (true) {
			int input = inputScan(menu, scan);
			
			if (input == 1) {
				System.out.println(num+"학번 데이터 입력");
				String data = rowString(num, scan);
				map.put(++num, data);
				
			} else if (input == 2) {
				getList(map);
				
			} else if (input == 3) {
				int edit = inputScan("수정할 학번 입력\n>", scan);
				String data = rowString(edit, scan);
				map.replace(edit, data);
				
			} else if (input == 4) {
				int del = inputScan("삭제할 학번 입력\n>", scan);
				map.remove(del);
				
			}
		}
	}
}
