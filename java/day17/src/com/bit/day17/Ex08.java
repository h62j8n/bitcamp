package com.bit.day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex08 {
	public static void main(String[] args) {
		File file;
		file = new File("test01.bin");
		
		OutputStream os;		// 1 byte
		byte[] b = "�ѱ�".getBytes();
		try {
			os = new FileOutputStream(file);
//			os.write(65);		// char 'a'

			os.write('a');
			os.write('b');
			os.write('c');
			os.write('d');
			os.write('e');
			os.write('f');
//			os.write('��');			// '\' : (1 byte ���� trim)
			for (int i=0; i<b.length; i++) {
				os.write(b[i]);		// '?'
			}
			os.close();
			System.out.println("�ۼ� �Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
