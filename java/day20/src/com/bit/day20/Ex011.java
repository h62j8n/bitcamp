package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex011 {
	public static void main(String[] args) {
		
		
		String path = ".\\test01.txt";
		File file = new File(path);
		
		OutputStream os = null;
		byte[] buf = new byte[20];			// 버퍼
		try {
			os = new FileOutputStream(file);
			System.out.print("메세지 입력\n>");
			int num = System.in.read(buf);				// #3버퍼로 읽고 쓰기 (이 과정에서 Scanner 삭제)
			os.write(buf, 0, num);						// 이렇게 작성하지 않으면 20byte보다 적게 작성해도 20byte를 읽어온다.
			
			os.flush();							// 버퍼 보내기?
			System.out.println("작성 완료");
			
		} catch (FileNotFoundException e) {			// (파일이 없을 경우) os = new FileOutputStream(file);
			e.printStackTrace();
		} catch (IOException e) {					// (버퍼) os.write(buf);
			e.printStackTrace();
		} finally {								// 반드시 close()를 수행하도록(= 종료하도록) 약속
			try {
				if (os != null) {os.close();}	// 단 null일 때는 close()할 수 없으므로
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
