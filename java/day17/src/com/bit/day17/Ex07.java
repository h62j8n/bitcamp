package com.bit.day17;

import java.io.File;
import java.io.IOException;

public class Ex07 {
	public static void main(String[] args) {
		File path = new File(".\\temp");
		File file;
		
		try {
			file = File.createTempFile("bit", ".txt", path);
			System.out.println(file.exists());
			System.out.println(file.getCanonicalPath());
			System.out.println(file.getName()+" 파일 생성");

			// 사용 후 처리 (임의의 디렉토리와 임시 파일 삭제)
			if (!path.delete()) {
				String[] sts = path.list();
				for (int i=0; i<sts.length; i++) {
					File temp = new File(path.getPath()+"\\"+sts[i]);
					temp.delete();
					System.out.println(temp.getName()+" 파일 삭제");
				}
				path.delete();
			}
			path.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
