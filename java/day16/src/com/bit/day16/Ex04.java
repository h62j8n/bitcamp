package com.bit.day16;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ex04 {
	static Ex04 me;							// 1. �ʵ� (��ü)
	
	public static void func01() {
		System.out.println("my func01");
	}
	public static void main(String[] args) {
		Ex04.me.func01();					// 1> ȣ�� : Ŭ������.����������.�޼ҵ��();
		
		PrintStream var1 = System.out;		// 2. out : �ʵ�
		var1.println("���");				// 2> ȣ�� : Ŭ������System.�ʵ��out.�޼ҵ��println(����"���");
		
		InputStream var2 = System.in;		// 3. in : �ʵ�
		Scanner scan = new Scanner(var2);	// 3> ȣ��
		
		long sec = System.currentTimeMillis();
		System.out.println(Long.MAX_VALUE);			// longŸ���� �ִ� �� ��ȯ
		System.out.println(sec);					// ���� �ð��� �и�������� ǥ���� �� �ִ� �ִ� ������ ��������ִ�.
//		�ִ������ �̸���(2038��), �����÷ο�� ���� �ּҰ����� �Ѿ��. (���� : Y2K ���)
		
		Map<String, String> env = System.getenv();	// �� Ÿ������ �޴� �޼ҵ�
		Set<String> keys = env.keySet();
		Iterator<String> ite = keys.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println(key+" = "+env.get(key));
		}
		
	}
}
