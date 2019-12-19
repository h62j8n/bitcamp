package com.bit.day17;

import java.io.File;

public class Ex05 {
	public static void main(String[] args) {
		File file;
		file = new File("newName.bin");
		
		File file2;
		file2 = new File("newName2.bin");
		
		System.out.println(file.getName()+" 이름 변경 : "+file.renameTo(file2));
		file.renameTo(file2);
	}
}
