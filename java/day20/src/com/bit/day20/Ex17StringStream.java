package com.bit.day20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex17StringStream {
	public static void main(String[] args) {
		// 성적관리프로그램 (v0.4.0)
		String path = "studentData.txt";
		File file = new File(path);
		
		String title = "학생성적관리프로그램 (v0.4.0)";
		String bar = "--------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n학번\t|국어\t|영어\t|수학\n"+bar;
		String menu = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
		String input = null;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		ArrayList<String> data = new ArrayList<>();
		
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		dataSave(file, data, fw, bw);
		
		int scNum = 0;
		while (true) {
			int select = input(menu, scan, input);
			
			if (select == 0) {
				break;
			} else if (select == 1) {
				scNum++;
				
				System.out.println(scNum+"학번 점수 입력");
				int kor = input("국어\n>", scan, input);
				int eng = input("영어\n>", scan, input);
				int math = input("수학\n>", scan, input);
				
				String result = "\n"+scNum+"\t|"+kor+"\t|"+eng+"\t|"+math;
				data.add(result);
				
				dataSave(file, data, fw, bw);
				
			} else if (select == 2) {
				data.add(bar);
				dataLoad(file, data, fr, br);
				
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
	}
	public static int input(String msg, Scanner scan, String input) {
		System.out.print(msg);
		input = scan.nextLine();
		int num = Integer.parseInt(input);
		return num;
	}
	public static String dataArrange(ArrayList data) {
		String str = Arrays.deepToString(data.toArray());
		String arrange = str
				.replace("[", "")
				.replace("]", "")
				.replace(",", "");
		
		return arrange;
	}
	public static void dataSave(File file, ArrayList data, FileWriter fw, BufferedWriter bw) {
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write(dataArrange(data));
			bw.flush();
			
			System.out.println("작성 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void dataLoad(File file, ArrayList data, FileReader fr, BufferedReader br) {
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while (true) {
				String temp = br.readLine();
				if (temp == null) {break;}
				System.out.println(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
