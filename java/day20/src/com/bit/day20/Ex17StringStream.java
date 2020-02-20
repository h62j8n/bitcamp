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
		// �����������α׷� (v0.4.0)
		String path = "studentData.txt";
		File file = new File(path);
		
		String title = "�л������������α׷� (v0.4.0)";
		String bar = "--------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
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
				
				System.out.println(scNum+"�й� ���� �Է�");
				int kor = input("����\n>", scan, input);
				int eng = input("����\n>", scan, input);
				int math = input("����\n>", scan, input);
				
				String result = "\n"+scNum+"\t|"+kor+"\t|"+eng+"\t|"+math;
				data.add(result);
				
				dataSave(file, data, fw, bw);
				
			} else if (select == 2) {
				data.add(bar);
				dataLoad(file, data, fr, br);
				
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
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
			
			System.out.println("�ۼ� �Ϸ�");
			
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
