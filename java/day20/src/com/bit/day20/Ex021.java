package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex021 {
	public static void main(String[] args) {
		String path = "test01.txt";
		File file = new File(path);

		InputStream is = null;
		byte[] buf = new byte[20];				// ũ�� 20�� ����
		try {
			is = new FileInputStream(file);
			
			while (true) {
//no buf				int num = is.read();
				int num = is.read(buf);
				
				if (num == -1) break;							// �о���ΰ� ���ٸ� break;
				
				byte[] result = Arrays.copyOf(buf, num);		// buf[] �迭�� num(����)��ŭ Arrays result�迭�� ����
//no buf				System.out.write(num);
//				System.out.write(buf);							// �����Ⱚ �߻� (������ �о��µ�, ������ �о��� �� 20���� ���̰� ª�Ƽ� ��������� �ʰ� ���� ��)
				System.out.write(buf, 0, num);					// �����Ⱚ�� ������ �ʴ´�. �ѱ�ó���� ���ÿ� ��
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
