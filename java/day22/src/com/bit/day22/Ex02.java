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
			scan = new Scanner(is);					// InputStream을 사용해 
			System.out.println(scan.nextLine());	// .nextLine() : 개행 단위로 읽어들임
			System.out.println(scan.next());		// .next() : 띄어쓰기/탭/개행 단위
			System.out.println(scan.next());
			System.out.println(scan.nextInt()+1);	// .nextInt() : 정수형 값으로 읽어들임
			System.out.println(scan.nextInt());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
