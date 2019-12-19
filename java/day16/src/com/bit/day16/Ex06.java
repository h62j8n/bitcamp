package com.bit.day16;

public class Ex06 {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("java");
		char[] chs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		sb1.append(chs, 2, 4);
		System.out.println(sb1);

		StringBuilder sb2 = new StringBuilder("java");
		String str = "ABCDEFG";
		sb2.append(str, 2, 6);
		System.out.println(sb2);

		StringBuilder sb3 = new StringBuilder("java");
		sb3.getChars(1, 3, chs, 2);
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " ");
		}
		System.out.println();
		
		StringBuilder sb4 = new StringBuilder("java");
		sb4.insert(2, 10);
		sb4.insert(3, "AB");
		System.out.println(sb4);
		
		StringBuilder sb5 = new StringBuilder("java");
		sb5.replace(1, 3, "JV");
		System.out.println(sb5);
		
	}
}
