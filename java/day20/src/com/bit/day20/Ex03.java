package com.bit.day20;

import java.io.IOException;
import java.io.InputStream;

public class Ex03 {
	public static void main(String[] args) {
		InputStream inn = System.in;
		int num = -1;				// ���� ���� �ִٸ� ���� �� ���� ������ ��
		
		try {
			while (true) {
				num = inn.read();
				if (num == -1) break;
				System.out.println(num);			// 13, 10 : window ȯ�濡���� ���Ͱ�(\r\n)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
