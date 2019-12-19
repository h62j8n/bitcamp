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
		String msg = "이렇게 작성할 수 있습니다1234abcd";
		msg = "이렇게\n작성할 수\n있습니다\n1234\r\nabcd";
		File file;
		file = new File("test01.bin");
		
		OutputStream os;
		InputStream is;
		byte[] buff = msg.getBytes();			// #1. 작성할 문자열의 길이 값을 byte로 받는다.
		byte[] b = msg.getBytes();
		try {
			os = new FileOutputStream(file);
			is = new FileInputStream(file);
			os.write(buff);						// #1> 문자열 길이만큼 file객체에게 작성한다.
			
			os.flush();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
