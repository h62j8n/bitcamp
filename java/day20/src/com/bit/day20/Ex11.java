package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex11 {
	public static void main(String[] args) {
		String path = "test04.txt";
		File file = new File(path);
		
		Reader fr = null;
		try {
			fr = new FileReader(file);
//			System.out.println((char)fr.read());	// ù����('��')��°� �� �� �ִ�.
//			System.out.println((char)fr.read());	// �ѱ��ڸ� ���� �ι� ����غ��� -1�� �����°� Ȯ���� �� �ִ�. (�ٸ� ��Ʈ�������� ������ �� ����)
			
			while (true) {
				int num = fr.read();
				if (num == -1) {break;}				// Ȯ�ε� -1������ �ݺ��� �����ϱ�
				char ch = (char)num;
				System.out.print(ch);
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
