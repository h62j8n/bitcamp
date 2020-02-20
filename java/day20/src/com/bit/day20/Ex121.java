package com.bit.day20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Ex121 {
	public static void main(String[] args) {
//		String msg = "java로 문자파일 작성\r\n버퍼로작성";
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();
		
		File file = new File("test05.txt");
		Writer fw = null;
		
		char[] cbuf = msg.toCharArray();
		try {
			fw = new FileWriter(file);
//			fw.write(cbuf);					// #1
//			fw.write(new String(cbuf));		// #2 1과는 무슨 차이?
//			fw.write(msg);					// #2
			fw.write(cbuf, 0, cbuf.length);	// #3
			fw.flush();
			
			System.out.println("작성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
