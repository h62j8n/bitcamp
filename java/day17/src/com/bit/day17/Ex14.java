package com.bit.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex14 {
	public static void main(String[] args) {
		String msg = "�̷��� �ۼ��� �� �ֽ��ϴ�1234abcd";
		msg = "�̷���\n�ۼ��� ��\n�ֽ��ϴ�\n1234\r\nabcd";
		File file;
		file = new File("test01.bin");
		
		OutputStream os;
		InputStream is;
		byte[] buff = msg.getBytes();			// #1. �ۼ��� ���ڿ��� ���� ���� byte�� �޴´�.
		byte[] b = msg.getBytes();
		try {
			os = new FileOutputStream(file);
			is = new FileInputStream(file);
			os.write(buff);						// #1> ���ڿ� ���̸�ŭ file��ü���� �ۼ��Ѵ�.
			
			os.flush();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
