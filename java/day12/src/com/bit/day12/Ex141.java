package com.bit.day12;
import java.util.Scanner;

public class Ex141 {
	static String data = "";
	
	public static void main(String[] args) {
		// 학생성적관리프로그램 (v0.1.0)
		String title = "학생성적관리프로그램 ver0.1.0";
		String bar = "----------------------------------------------";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		String table = "학번\t|국어\t|영어\t|수학\t|합계\t|평균\t\n----------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String input = null;

		int numS = 0;
		while (true) {
			System.out.print("1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>");
			input = scan.nextLine();
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				numS++;
				data += mark(numS);
				
			} else if (input.equals("2")) {
				System.out.println(table+data);
				
			} else if (input.equals("3")) {
				System.out.print("수정할 학번 입력:\n>");
				input = scan.nextLine();
				int numE = Integer.parseInt(input);
				
				data = data.replace(edit(numE), mark(numE));
				
			} else if (input.equals("4")) {
				System.out.print("삭제할 학번 입력:\n>");
				input = scan.nextLine();
				int numD = Integer.parseInt(input);
				
				data = data.replace(edit(numD), "");
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
	public static String mark(int schoolNum) {
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		System.out.print(schoolNum+"학번 국어\n>");
		input = scan.nextLine();
		int kor = Integer.parseInt(input);
		
		System.out.print(schoolNum+"학번 영어\n>");
		input = scan.nextLine();
		int math = Integer.parseInt(input);
		
		System.out.print(schoolNum+"학번 수학\n>");
		input = scan.nextLine();
		int eng = Integer.parseInt(input);
		
		int sum = kor+eng+math;
		double avg = sum*100/3/100.0;
		
		return "\n"+schoolNum+"\t|"+kor+"\t|"+math+"\t|"+eng+"\t|"+sum+"\t|"+avg+"\t";
	}
	public static String edit(int schoolNum) {
		return data.substring(data.indexOf("\n"+schoolNum), data.indexOf("\n"+(schoolNum+1)));
	}
}
