package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex17 {
	public static void main(String[] args) {
		// �����������α׷� (v0.4.0)
		ArrayList<Object> data = new ArrayList<>();
		String path = "studentData.txt";
		File file = new File(path);
		
		String title = "�л������������α׷� (v0.4.0)";
		String bar = "--------------------------------";
		
		Scanner scan = new Scanner(System.in);
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String menu = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
		int input = -1;
		
		System.out.println(bar);
		System.out.println(title);
		System.out.println(bar);
		
		OutputStream os = null;
		ObjectOutputStream oos = null;
		InputStream is = null;
		ObjectInputStream ois = null;
		
		int scNum = 0;
		
		if (!file.exists()) {													// ����� �����Ͱ� ���� ��� �ؽ�Ʈ ���̺� ����
			data.add(table);
			dataSave(file, data, os, oos);
		} else {																// ����� �����Ͱ� ���� ��� ���� �ҷ��;��Ѵ�.
			data = dataLoad(file, data, is, ois);
			scNum = data.size()-1;
		}
		
		while (true) {
			int select = inputNumber(menu, scan, input);
			
			if (select == 0) {
				break;
			} else if (select == 1) {
				scNum++;
				
				System.out.println(scNum+"�й� ���� �Է�");
				int kor = inputNumber("����\n>", scan, input);
				int eng = inputNumber("����\n>", scan, input);
				int math = inputNumber("����\n>", scan, input);
				
				String result = "\n"+scNum+"\t|"+kor+"\t|"+eng+"\t|"+math;
				data.add(result);
				
				dataSave(file, data, os, oos);									// �Է��� ������ ���� �����
				
			} else if (select == 2) {
				data = dataLoad(file, data, is, ois);							// ���� �� ����� �����͸� data�迭�� ��´�.
				
				for (int i=0; i<data.size(); i++) {
					Object target = data.get(i);
					String targetStr = target.toString();
					
					if (targetStr.equals("delete")) continue;
					System.out.print(target);
				}
				System.out.println();
				
				System.out.println("data.size = " + data.size());
				
			} else if (select == 3) {
				data = dataLoad(file, data, is, ois);							// �����ϱ� ���� ����� �����͸� data�迭�� ���
				
				int edit = validNumber(select, data, scan, input);

				int kor = inputNumber("����\n>", scan, input);
				int eng = inputNumber("����\n>", scan, input);
				int math = inputNumber("����\n>", scan, input);
				String result = "\n"+edit+"\t|"+kor+"\t|"+eng+"\t|"+math;
				
				for (int i=0; i<data.size(); i++) {
					Object target = data.get(i);
					String targetStr = target.toString();
					if (targetStr.startsWith("\n"+edit)) {
						data.set(i, result);
					}
				}
				dataSave(file, data, os, oos);
				
			} else if (select == 4) {
				data = dataLoad(file, data, is, ois);							// �����ϱ� ���� ����� �����͸� data�迭�� ���
				
				int edit = validNumber(select, data, scan, input);
				
				for (int i=0; i<data.size(); i++) {
					Object target = data.get(i);
					String targetStr = target.toString();
					if (targetStr.startsWith("\n"+edit)) {
						data.set(i, "delete");
					}
				}
				dataSave(file, data, os, oos);
			}
		}
		System.out.println("�̿����ּż� �����մϴ�.");
	}
	
	public static int validNumber(int select, ArrayList<Object> data, Scanner scan, int input) {
		int edit = 0;
		String msg = null;
		if (select == 3) {
			msg = "������ �й��� �Է��ϼ���.\n>";
		} else if (select == 4) {
			msg = "������ �й��� �Է��ϼ���.\n>";
		}
		while (true) {
			edit = inputNumber(msg, scan, input);
			
			if (edit == 0 || edit > data.size()-1) {
				System.out.println("�ùٸ� �й��� �ƴմϴ�.");
			}
			else break;
		}
		return edit;
	}
		
	public static int inputNumber(String msg, Scanner scan, int input) {
		System.out.print(msg);
		input = scan.nextInt();
		return input;
	}
	
	public static void dataSave(File file, ArrayList<Object> data, OutputStream os, ObjectOutputStream oos) {
		try {
			os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(data);
			oos.flush();
			
			System.out.println("�ۼ� �Ϸ�");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
				if (os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<Object> dataLoad(File file, ArrayList<Object> data, InputStream is, ObjectInputStream ois) {
		ArrayList<Object> loadedData = null;
		try {
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			
			loadedData = (ArrayList<Object>) ois.readObject();					// ������ ������
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return loadedData;
	}
}
