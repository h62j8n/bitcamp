package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.print("�޼��� �Է�\n>");
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();
		
		String path = ".\\test01.txt";
		File file = new File(path);
		
		OutputStream os = null;
		byte[] buf = msg.getBytes();			// ����
		try {
			os = new FileOutputStream(file);
			os.write(buf);
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
