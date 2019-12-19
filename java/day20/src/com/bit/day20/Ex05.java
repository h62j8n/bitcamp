package com.bit.day20;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex05 {
	public static void main(String[] args) {
		String path = "test02.bin";
		File file = new File(path);
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		int num1 = 1234;
		double num2 = 3.14;
		char ch = 'A';
		boolean boo = true;
		String msg ="���ڿ�";
		
		try {
			os = new FileOutputStream(file);
			dos = new DataOutputStream(os);
			
			dos.write(65);
			dos.writeInt(num1+1);
			dos.writeDouble(num2);
			dos.writeChar(ch);
			dos.writeBoolean(boo);
			dos.writeUTF(msg);
			dos.flush();								// �о��
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();			// ������ �����Ƿ� ��ü ���������� ���������� �ݴ´�.
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
