package com.bit.day20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Ex122 {
	public static void main(String[] args) {
		String msg = "java�� �������� �ۼ�\r\n���۷��ۼ�";
		
		File file = new File("test05.txt");
		Writer fw = null;
		
		BufferedWriter bw = null;
		char[] cbuf = msg.toCharArray();
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(cbuf);					// #4
			bw.flush();
			
			System.out.println("�ۼ� �Ϸ�");
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
