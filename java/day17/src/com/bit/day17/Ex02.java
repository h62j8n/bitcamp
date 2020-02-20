package com.bit.day17;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String path = null;
		
		System.out.print("디렉토리 입력\n>");
		path = scan.nextLine();
		
		File root = new File(path);
		
		if (root.exists()) {
			String[] rootList = root.list();
			for (int i=0; i<rootList.length; i++) {
				String fileName = rootList[i];
				File file = new File(path+"\\"+fileName);
				
				String fileInfo = "";
				
				Date date = new Date(file.lastModified());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a hh:mm");
				String modifiedDate = sdf.format(date);
				
				fileInfo += modifiedDate+"\t";
				
				boolean d = file.isDirectory();
				String dir = "<DIR>";
				long size = file.length();
				if (d == true) {
					fileInfo += dir+"\t\t";
				} else {
					fileInfo += "\t"+size+"\t";
				}
				
				fileInfo += fileName+"\n";
				
				System.out.print(fileInfo);
			}
		} else {
			System.out.println("잘못된 경로");
		}
	}
}
