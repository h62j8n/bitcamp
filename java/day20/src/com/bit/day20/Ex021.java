package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ex021 {
	public static void main(String[] args) {
		String path = "test01.txt";
		File file = new File(path);

		InputStream is = null;
		byte[] buf = new byte[20];				// 크기 20인 버퍼
		try {
			is = new FileInputStream(file);
			
			while (true) {
//no buf				int num = is.read();
				int num = is.read(buf);
				
				if (num == -1) break;							// 읽어들인게 없다면 break;
				
				byte[] result = Arrays.copyOf(buf, num);		// buf[] 배열을 num(길이)만큼 Arrays result배열에 복사
//no buf				System.out.write(num);
//				System.out.write(buf);							// 쓰레기값 발생 (이전에 읽었는데, 마지막 읽었을 때 20보다 길이가 짧아서 덮어씌워지지 않고 남은 값)
				System.out.write(buf, 0, num);					// 쓰레기값을 만들지 않는다. 한글처리도 동시에 됨
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
