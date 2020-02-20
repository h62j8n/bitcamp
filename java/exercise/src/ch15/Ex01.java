package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex01 {
	// 커맨드라인으로 부터 파일명과 숫자를 입력받아서, 입력받은 파일의 내용의 처음부터 입력받은 숫자만큼의 라인을 출력하는 프로그램을 작성하라
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = null;
		String[] target = null;
		
		System.out.print("숫자와 파일명을 입력하세요.\n>");
		input = scan.nextLine();
		target = input.split(" ");
		
		int lineNumber = 0;
		String thisPath = "K:\\Bitcamp\\Java\\exercise\\src\\ch15\\";
		String fileName = "Ex01.java";
		
		try {
			lineNumber = Integer.parseInt(target[0]);
			fileName = target[1];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(input+"은(는) 디렉토리 또는 존재하지 않는 파일입니다.");
		}
		
		File file = new File(thisPath+fileName);
		if (!file.exists()) {
			System.out.println(input+"은(는) 디렉토리 또는 존재하지 않는 파일입니다.");
		}
		
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
//			while (lineNumber == 0) {
				String temp = br.readLine();
				System.out.println(temp);
				
//				lineNumber--;
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
