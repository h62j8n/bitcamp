package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Ex142 {
	public static void main(String[] args) {
		String msg1 = "abcdefg";
		String msg2 = "12345";
		String msg3 = "한글로";
		
		File file = new File("test05.txt");
		OutputStream os = null;
		PrintStream ps = null;					// 바이트 스트림
		
		try {
			os = new FileOutputStream(file);
			ps = new PrintStream(os);
			
			ps.println(msg1);
			ps.println(msg2);
			ps.println(msg3);
			
			System.out.println("작성 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
