package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ex141 {
	public static void main(String[] args) {
		String msg1 = "abcdefg";
		String msg2 = "12345";
		String msg3 = "한글로";
		
		File file = new File("test05.txt");
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			os = new FileOutputStream(file);
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			pw =  new PrintWriter(bw);
			
			pw.println(msg1);
			pw.println(msg2);
			pw.println(msg3);
			
			System.out.println("작성 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) pw.close();
				if (bw != null) bw.close();
				if (osw != null) osw.close();
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
