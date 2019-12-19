package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String path = "test01.txt";
		File file = new File(path);

		InputStream is = null;
		byte[] buf = new byte[20];				// ũ�� 20�� ����
		try {
			is = new FileInputStream(file);
			
			while (true) {
				int num = is.read(buf);
				
				if (num == -1) break;							// �о���ΰ� ���ٸ� break;
				
				byte[] result = Arrays.copyOf(buf, num);		// buf[] �迭�� num(����)��ŭ Arrays result�迭�� ����
				System.out.print(new String(result));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {								// ����� ���� �� �ݵ�� ����
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
