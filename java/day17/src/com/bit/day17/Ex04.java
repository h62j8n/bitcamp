package com.bit.day17;

import java.io.File;
import java.io.IOException;

public class Ex04 {
	public static void main(String[] args) {
		File file;
		
		file = new File("test05");
		if (file.exists()) {
			file.delete();
			System.out.println("���� ����");
		} else {
			System.out.println("�������� ����");
		}
	}
}
