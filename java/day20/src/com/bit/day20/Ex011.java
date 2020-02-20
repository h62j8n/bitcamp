package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex011 {
	public static void main(String[] args) {
		
		
		String path = ".\\test01.txt";
		File file = new File(path);
		
		OutputStream os = null;
		byte[] buf = new byte[20];			// ����
		try {
			os = new FileOutputStream(file);
			System.out.print("�޼��� �Է�\n>");
			int num = System.in.read(buf);				// #3���۷� �а� ���� (�� �������� Scanner ����)
			os.write(buf, 0, num);						// �̷��� �ۼ����� ������ 20byte���� ���� �ۼ��ص� 20byte�� �о�´�.
			
			os.flush();							// ���� ������?
			System.out.println("�ۼ� �Ϸ�");
			
		} catch (FileNotFoundException e) {			// (������ ���� ���) os = new FileOutputStream(file);
			e.printStackTrace();
		} catch (IOException e) {					// (����) os.write(buf);
			e.printStackTrace();
		} finally {								// �ݵ�� close()�� �����ϵ���(= �����ϵ���) ���
			try {
				if (os != null) {os.close();}	// �� null�� ���� close()�� �� �����Ƿ�
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
