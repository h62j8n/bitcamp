package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		File file = new File("test01.txt");
		InputStream is = null;
		
		try {
			is = new FileInputStream(file);			// 2. is는 file을 읽는 FileInputStream 객체
//			Scanner scan = new Scanner();			// 0. Scanner는 값을 읽어들일 InputStream이 필요
			Scanner scan = new Scanner(is);			// 1. is를 통해 읽어들임
			System.out.println(scan.nextLine());	// 3. is를 통해 읽은 값을 scan로 내보냄
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
