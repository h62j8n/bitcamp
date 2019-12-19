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
			is = new FileInputStream(file);			// 2. is�� file�� �д� FileInputStream ��ü
//			Scanner scan = new Scanner();			// 0. Scanner�� ���� �о���� InputStream�� �ʿ�
			Scanner scan = new Scanner(is);			// 1. is�� ���� �о����
			System.out.println(scan.nextLine());	// 3. is�� ���� ���� ���� scan�� ������
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
