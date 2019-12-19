package com.bit.day22;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex05 {
	public static void main(String[] args) {
		File file = new File("index.html");
		
		String path = "https://www.naver.com";
		URL url = null;
		
		URLConnection conn = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			url = new URL(path);
			conn = url.openConnection();
			conn.connect();								// url에 접속
			is = conn.getInputStream();
			os = new FileOutputStream(file);
			while (true) {
				int num = is.read();
				if (num == -1) {break;}
//				System.out.write(num);
				os.write(num);
			}
			System.out.println("복사 완료");
			
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException e) {
			}
		}
	}
}
