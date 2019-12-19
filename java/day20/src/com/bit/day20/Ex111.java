package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex111 {
	public static void main(String[] args) {
		String path = "test04.txt";
		File file = new File(path);
		
		Reader fr = null;
		char[] cbuf = new char[5];					// ���̰� 5�� ����
		
		try {
			fr = new FileReader(file);
			
			while (true) {
				int num = fr.read(cbuf);
				if (num == -1) {break;}				// Ȯ�ε� -1������ �ݺ��� �����ϱ�
				char ch = (char)num;
				System.out.print(new String(cbuf, 0, num));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
