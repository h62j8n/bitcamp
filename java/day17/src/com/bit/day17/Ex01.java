package com.bit.day17;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		java.io.File file1 = null;
//		file1 = new File("test01.bin");						// ������ ���ο� ���ϸ� ����
//		file1 = new File("C:\\java\\day17\\.\\test01.bin");		// ������ �����ηε� ��ü ���� ����
		file1 = new File("C:\\java");
		
		System.out.println("���� : "+file1.exists());		// ������ ���� ����
		System.out.println("���丮 : "+file1.isDirectory());
		System.out.println("���� : "+file1.isFile());
		System.out.println("��� : "+file1.getPath());
		System.out.println("������ : "+file1.getAbsoluteFile());
		try {
			System.out.println("������ : "+file1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("�̸� : "+file1.getName());
		System.out.println("������� : "+file1.getParent());
		System.out.println("r�б���� : "+file1.canRead());
		System.out.println("w������� : "+file1.canWrite());
		System.out.println("x������� : "+file1.canExecute());
		
		System.out.println("���� ũ�� : "+file1.length());
		System.out.println("������ ��¥ : "+file1.lastModified());
		System.out.println(new Date(file1.lastModified()));
		
		String[] msg = file1.list();
		System.out.println(Arrays.toString(msg));
	}
}
