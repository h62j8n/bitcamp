package com.bit.day17;

import java.io.File;
import java.io.IOException;

public class Ex03 {
	public static void main(String[] args) {
		File file;
		
		file = new File("test03.bin");
		if (!file.exists()) {
			try {
				System.out.println("���� ���� : "+file.createNewFile());
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�̹� ������");
		}
		
		file = new File("test04");
		if (!file.exists()) {
			file.mkdir();
			System.out.println("���丮 ����");
		} else {
			System.out.println("�̹� ������");
		}
		
		file = new File("test05\\test11.bin");
		if (!file.exists()) {
			file.mkdirs();
			System.out.println("���丮�� ���� ����");
		} else {
			System.out.println("�̹� ������");
		}
		
	}
}
