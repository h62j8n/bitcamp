package com.bit.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex13 {
	public static void main(String[] args) {
		File file;
		file = new File("test01.bin");
		
		InputStream is;
		byte[] buff = new byte[20];
		String printMsg = "";
		
		try {
			is = new FileInputStream(file);
			
			while(true) {
				int su = is.read(buff);
				if (su == -1) {break;}
				printMsg += new String(buff, 0, su);
				// String(byte[] bytes, int offset, int length)
				// 버퍼배열을 사용하며 발생하는 쓰레기값 처리
			}
			System.out.println(printMsg);
			is.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
