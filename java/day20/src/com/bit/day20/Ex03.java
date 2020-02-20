package com.bit.day20;

import java.io.IOException;
import java.io.InputStream;

public class Ex03 {
	public static void main(String[] args) {
		InputStream inn = System.in;
		int num = -1;				// 읽을 것이 있다면 나올 수 없는 임의의 수
		
		try {
			while (true) {
				num = inn.read();
				if (num == -1) break;
				System.out.println(num);			// 13, 10 : window 환경에서의 엔터값(\r\n)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
