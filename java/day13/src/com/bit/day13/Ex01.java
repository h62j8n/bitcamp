package com.bit.day13;

import java.util.Scanner;

public class Ex01 {
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
				data += rowString(num, scan);
				
			} else if (input.equals("2")) {
				System.out.print(table);
				System.out.println(data);
				
			} else if (input.equals("3")) {
				data = myReplace("수정할 학번\n>", data, scan);
				
			} else if (input.equals("4")) {
				data = myReplace("삭제할 학번\n>", data, "", scan);
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
	public static String myReplace(String msg, String data, Scanner scan) {
		int enter = inputScan("msg", scan)+1;		// n학번 다음에 나오는 엔터
		
		String input = "\n"+(enter-1)+"\t|";								// 삭제할 첫 글자
		int start = data.indexOf(input); 
		int end = data.indexOf("\n", start+1);					// 삭제할 마지막 글자
		String target = null;
		try {
			target = data.substring(start, end);
		} catch (StringIndexOutOfBoundsException e) {
			target = data.substring(start);
		}
		String replacement = rowString(enter-1, scan);
		return data.replace(target, replacement);
	}
	public static String myReplace(String msg, String data, String replacement, Scanner scan) {
		int enter = inputScan("msg", scan)+1;					// n학번 다음에 나오는 엔터
		
		String input = "\n"+(enter-1)+"\t|";					// 삭제할 첫 글자
		int start = data.indexOf(input); 
		int end = data.indexOf("\n", start+1);					// 삭제할 마지막 글자
		String target = null;
		try {
			target = data.substring(start, end);
		} catch (StringIndexOutOfBoundsException e) {
			target = data.substring(start);
		}
		return data.replace(target, replacement);
	}
	public static String rowString(int num, Scanner scan) {
		int kor = inputScan("국어\n>", scan);
		int eng = inputScan("영어\n>", scan);
		int math = inputScan("수학\n>", scan);
		
		return "\n"+num+"\t|"+kor+"\t|"+math+"\t|"+eng;
	}
	public static int inputScan(int start, int end, String msg, Scanner scan) {		// 입력 메소드
		int num = -1;
		while (true) {
			System.out.print(msg);
			String input = scan.nextLine();
			num = Integer.parseInt(input);
			if (num >= start && num <= end) {break;};
		}
		return num;
	}
	public static int inputScan(String msg, Scanner scan) {	// 점수 입력 시. 학번 입력시에는 "1"번 부터 "정원" 수 까지 라는 매개변수를 넣는다.
		return inputScan(0,100,msg,scan);
	}
}
