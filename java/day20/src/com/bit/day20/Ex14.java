package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ex14 {
	public static void main(String[] args) {
		String msg1 = "abcdefg";
		String msg2 = "12345";
		String msg3 = "한글로";
		
		File file = new File("test05.txt");
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = new FileOutputStream(file);
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write(msg1);
			bw.newLine();
			bw.write(msg2);
			bw.newLine();
			bw.write(msg3);
			
			System.out.println("작성 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (osw != null) osw.close();
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
