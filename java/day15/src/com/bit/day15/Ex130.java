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
		int kor = inputScan("����\n>", scan);
		int eng = inputScan("����\n>", scan);
		int math = inputScan("����\n>", scan);
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
		// �л� �������� ���α׷� (v0.3.0)
		
		String title = "�л������������α׷� (v0.3.0)";
		String bar = "-------------------------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\t|�հ�\t|���\t|\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		Map<Integer, String>map = new TreeMap<Integer, String>();
		map.put(0, table);
		
		int num = 0;
		while (true) {
			int input = inputScan(menu, scan);
			
			if (input == 1) {
				System.out.println(num+"�й� ������ �Է�");
				String data = rowString(num, scan);
				map.put(++num, data);
				
			} else if (input == 2) {
				getList(map);
				
			} else if (input == 3) {
				int edit = inputScan("������ �й� �Է�\n>", scan);
				String data = rowString(edit, scan);
				map.replace(edit, data);
				
			} else if (input == 4) {
				int del = inputScan("������ �й� �Է�\n>", scan);
				map.remove(del);
				
			}
		}
	}
}
