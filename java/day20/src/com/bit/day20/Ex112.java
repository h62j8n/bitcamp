package com.bit.day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex112 {
	public static void main(String[] args) {
		String path = "test04.txt";
		File file = new File(path);
		
		Reader fr = null;
		BufferedReader br = null;
		char[] cbuf = new char[5];					// 길이가 5인 버퍼
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
//			String temp = br.readLine();			// .readLine() : 한줄씩 읽어들임 = 개행이 나오기 전까지를 버퍼에 담음
//			System.out.println(temp);
			while (true) {
				String temp = br.readLine();
				if (temp == null) {break;}
				System.out.println(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
