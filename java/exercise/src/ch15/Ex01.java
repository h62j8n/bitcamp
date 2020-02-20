package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex01 {
	// Ŀ�ǵ�������� ���� ���ϸ�� ���ڸ� �Է¹޾Ƽ�, �Է¹��� ������ ������ ó������ �Է¹��� ���ڸ�ŭ�� ������ ����ϴ� ���α׷��� �ۼ��϶�
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = null;
		String[] target = null;
		
		System.out.print("���ڿ� ���ϸ��� �Է��ϼ���.\n>");
		input = scan.nextLine();
		target = input.split(" ");
		
		int lineNumber = 0;
		String thisPath = "K:\\Bitcamp\\Java\\exercise\\src\\ch15\\";
		String fileName = "Ex01.java";
		
		try {
			lineNumber = Integer.parseInt(target[0]);
			fileName = target[1];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(input+"��(��) ���丮 �Ǵ� �������� �ʴ� �����Դϴ�.");
		}
		
		File file = new File(thisPath+fileName);
		if (!file.exists()) {
			System.out.println(input+"��(��) ���丮 �Ǵ� �������� �ʴ� �����Դϴ�.");
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
