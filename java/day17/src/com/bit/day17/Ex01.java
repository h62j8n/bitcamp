package com.bit.day17;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		java.io.File file1 = null;
//		file1 = new File("test01.bin");						// 생성자 내부에 파일명 기재
//		file1 = new File("C:\\java\\day17\\.\\test01.bin");		// 파일의 절대경로로도 객체 생성 가능
		file1 = new File("C:\\java");
		
		System.out.println("존재 : "+file1.exists());		// 파일의 존재 여부
		System.out.println("디렉토리 : "+file1.isDirectory());
		System.out.println("파일 : "+file1.isFile());
		System.out.println("경로 : "+file1.getPath());
		System.out.println("절대경로 : "+file1.getAbsoluteFile());
		try {
			System.out.println("절대경로 : "+file1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("이름 : "+file1.getName());
		System.out.println("상위경로 : "+file1.getParent());
		System.out.println("r읽기권한 : "+file1.canRead());
		System.out.println("w쓰기권한 : "+file1.canWrite());
		System.out.println("x실행권한 : "+file1.canExecute());
		
		System.out.println("파일 크기 : "+file1.length());
		System.out.println("수정한 날짜 : "+file1.lastModified());
		System.out.println(new Date(file1.lastModified()));
		
		String[] msg = file1.list();
		System.out.println(Arrays.toString(msg));
	}
}
