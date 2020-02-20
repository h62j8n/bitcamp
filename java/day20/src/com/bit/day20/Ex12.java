package com.bit.day20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex12 {
	public static void main(String[] args) {
		String msg = "java�� �������� �ۼ�";
		
		File file = new File("test05.txt");
		Writer fw = null;
		
		try {
			fw = new FileWriter(file);
			for (int i=0; i<msg.length(); i++) {
				fw.write(msg.charAt(i));
			}
			
			System.out.println("�ۼ� �Ϸ�");
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
