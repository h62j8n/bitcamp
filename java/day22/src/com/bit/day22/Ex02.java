package com.bit.day22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		File file = new File("test01.txt");
		InputStream is = null;
		
		Scanner scan = null;
		
		// InputStream
		try {
			is = new FileInputStream(file);
			scan = new Scanner(is);					// InputStream�� ����� 
			System.out.println(scan.nextLine());	// .nextLine() : ���� ������ �о����
			System.out.println(scan.next());		// .next() : ����/��/���� ����
			System.out.println(scan.next());
			System.out.println(scan.nextInt()+1);	// .nextInt() : ������ ������ �о����
			System.out.println(scan.nextInt());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
