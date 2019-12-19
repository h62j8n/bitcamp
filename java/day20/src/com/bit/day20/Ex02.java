package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String path = "test01.txt";
		File file = new File(path);

		InputStream is = null;
		byte[] buf = new byte[20];				// 크기 20인 버퍼
		try {
			is = new FileInputStream(file);
			
			while (true) {
				int num = is.read(buf);
				
				if (num == -1) break;							// 읽어들인게 없다면 break;
				
				byte[] result = Arrays.copyOf(buf, num);		// buf[] 배열을 num(길이)만큼 Arrays result배열에 복사
				System.out.print(new String(result));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {								// 사용이 끝난 후 반드시 종료
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
