package com.bit.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex11 {
	public static void main(String[] args) {
		File img;
		img = new File("images\\snow.jpg");
		System.out.println(img.exists());
		System.out.println(img.length());
		
		File copy;
		copy = new File("copy\\copySnow.jpg");
		
		InputStream is;
		OutputStream os;
		
		byte[] buff = new byte[9];
		
		try {
			if (copy.createNewFile()) {
				is = new FileInputStream(img);
				os = new FileOutputStream(copy);
				
				while(true) {
					int su = is.read(buff);				// 읽은 것을 buff에 저장 == 반복문 1번당 9번 저장
					if (su == -1) {break;}				// 더이상 읽을게 없으면 break
					os.write(buff);						// is.read() (반복문 1번당 9byte)가 저장된 buff를 읽어들임
				}
			
				os.close();
				is.close();
				System.out.println("복사 완료");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
