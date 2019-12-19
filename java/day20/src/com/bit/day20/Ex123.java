package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Ex123 {
	public static void main(String[] args) {
		String msg1 = "java로 문자파일 작성";
		String msg2 = "버퍼로 작성";
		
		File file = new File("test05.txt");
		Writer fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			char[] cbuf = msg1.toCharArray();
			bw.write(cbuf);
//			bw.write("\r\n");
			bw.newLine();					// = bw.write("\r\n")  실행하는 운영체제에 맞는 개행기호를 자동으로 넣어줌
			cbuf = msg2.toCharArray();
			bw.write(cbuf);
			bw.flush();
			
			System.out.println("작성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
