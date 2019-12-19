package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Ex143 {
	public static void main(String[] args) {
		InputStream inn = System.in;
		PrintStream oout = System.out;
		
		String msg1 = "abcdefg";
		String msg2 = "12345";
		String msg3 = "한글로";
		
		File file = new File("test05.txt");
		OutputStream os = null;
		PrintStream ps = null;
		
		try {
			os = new FileOutputStream(file);
			ps = new PrintStream(os);
			
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
