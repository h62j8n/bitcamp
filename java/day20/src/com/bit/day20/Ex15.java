package com.bit.day20;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex15 {
	public static void main(String[] args) {
		File file = new File("test05.txt");
		
		InputStream is = null;
//		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		
		byte[] buf = new byte[32];
		try {
			is = new FileInputStream(file);
//			bais = new ByteArrayInputStream(buf);
			baos = new ByteArrayOutputStream();
			
			while (true) {
				int num = is.read(buf);
				if (num == -1) {break;}
				baos.write(buf, 0, num);
			}
			
			byte[] bys = baos.toByteArray();
			System.out.println(new String(bys));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
