package com.bit.day20;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex10 {
	public static void main(String[] args) {
		String path = "test04.txt";
		File file = new File(path);
		
		InputStream is = null;
		BufferedInputStream bis = null;
		
		byte[] buf = new byte[5];
		try {
			is = new FileInputStream(file);
			bis = new BufferedInputStream(is);
			
			while (true) {
				int num = bis.read(buf);
				if (num == -1) {break;}
				System.out.write(buf, 0, num);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
