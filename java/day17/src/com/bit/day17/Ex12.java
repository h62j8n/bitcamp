package com.bit.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex12 {
	public static void main(String[] args) {
//		String msg = "문자열로 작성하겠습니다 잘나올까요?";			// test01.bin 파일에 작성
//		String msg = abcdefghijklmnopqrstubwxyz;
		
		File file;
		file = new File("test01.bin");
		
		InputStream is;
//		byte[] buff = new byte[10];
		byte[] buff = new byte[20];
		String printMsg = "";
		try {
			is = new FileInputStream(file);
			while(true) {
				int su = is.read(buff);
				if (su == -1) {break;}
				
				printMsg += new String(buff);
				// a-z 다음에 쓰레기값 "ghijklmnopqrst"가 남음
			}
			System.out.println(printMsg);							// ghijklmnopqrst : 파일을 읽으며 반복문을 읽을 때 생긴 나머지 값이 buff에 남아있음
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
