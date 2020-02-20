package com.bit.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex11 {
	public static void main(String[] args) {
		File img;
		img = new File("images\\snow.jpg");
		System.out.println(img.exists());
		System.out.println(img.length());
		
		File copy;
		copy = new File("copy\\copySnow.jpg");
		
		InputStream is;
		OutputStream os;
		
		byte[] buff = new byte[9];
		
		try {
			if (copy.createNewFile()) {
				is = new FileInputStream(img);
				os = new FileOutputStream(copy);
				
				while(true) {
					int su = is.read(buff);				// ���� ���� buff�� ���� == �ݺ��� 1���� 9�� ����
					if (su == -1) {break;}				// ���̻� ������ ������ break
					os.write(buff);						// is.read() (�ݺ��� 1���� 9byte)�� ����� buff�� �о����
				}
			
				os.close();
				is.close();
				System.out.println("���� �Ϸ�");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
