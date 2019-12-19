package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex11 {
	public static void main(String[] args) {
		String path = "test04.txt";
		File file = new File(path);
		
		Reader fr = null;
		try {
			fr = new FileReader(file);
//			System.out.println((char)fr.read());	// 첫글자('가')라는걸 알 수 있다.
//			System.out.println((char)fr.read());	// 한글자만 쓰고 두번 출력해보면 -1이 나오는걸 확인할 수 있다. (다른 스트림에서도 적용할 수 있음)
			
			while (true) {
				int num = fr.read();
				if (num == -1) {break;}				// 확인된 -1값으로 반복문 중지하기
				char ch = (char)num;
				System.out.print(ch);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
