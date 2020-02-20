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

class Record {
	int scNum;
	int kor;
	int eng;
	int math;
	boolean delete = false;
	
	public void setScNum(int scNum) {
		this.scNum = scNum;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public void inputScore(Scanner scan, int input) {
		this.setKor(inputNumber("����\n>", scan, input));
		this.setEng(inputNumber("����\n>", scan, input));
		this.setMath(inputNumber("����\n>", scan, input));
	}
	
	public static int inputNumber(String msg, Scanner scan, int input) {
		System.out.print(msg);
		input = scan.nextInt();
		return input;
	}
}

public class Ex171 extends Record {
	static String menuList = "1: �Է� 2: ���� 3: ���� 4: ���� 0: ����\n>";
	static String[] subject = {"����\n>", "����\n>", "����\n>"};
	final static String path = "studentData.txt";
	
	public static void main(String[] args) {
		
		ArrayList<Object> data = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int input = -1;
		
		File file = new File(path);
		
		if (file.exists()) {
			data = dataLoad(file);
		}
		
		System.out.println(data.size());
		
		int scNum = 0;
		while (true) {
			input = inputNumber(menuList, scan, input);
			
			if (input == 1) {
				scNum++;
				System.out.println(scNum+"�й��� ������ �Է��մϴ�.");
				
				Object r = new Record();
				((Record) r).setScNum(scNum);
				((Record) r).inputScore(scan, input);
				
				data.add(r);
				
			} else if (input == 2) {
				data = dataLoad(file);
				/*if (sizeCheck(data))*/ printRecord(data);
				
			} else if (input == 3 || input == 4) {
				/*if (sizeCheck(data))*/ dataEdit(data, scan, input);
				dataSave(file, data);
				
			} else if (input == 0) {
				break;
			}
		}
		
		System.out.println("�̿����ּż� �����մϴ�.");
	}
	
	public static void dataSave(File file, ArrayList<Object> data) {
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		
		try {
			os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(data);
			oos.flush();
			
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		finally {
			try {
				if (oos != null) oos.close();
				if (os != null) os.close();
				System.out.println("������ ���� �Ϸ�");
			}
			catch (IOException e) {}
		}
	}
	
	public static ArrayList<Object> dataLoad(File file) {
		FileInputStream is = null;
		ObjectInputStream ois = null;
		
		ArrayList<Object>loadedData = null;
		
		try {
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			
			loadedData = (ArrayList<Object>) ois.readObject();
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		catch (ClassNotFoundException e) {}
		finally {
			try {
				if (ois != null) ois.close();
				if (is != null) is.close();
				System.out.println("������ �ҷ����� �Ϸ�");
			}
			catch (IOException e) {}
		}
		
		return loadedData;
	}
	
	public static boolean sizeCheck(ArrayList<Object> data) {
		boolean result = true;
		
		int dataSize = 0;
		for (Object r : data) {
			if (!((Record)r).isDelete()) dataSize++;
		}
		
		if (dataSize == 0) {
			System.out.println("�����Ͱ� �����ϴ�. �����͸� �Է����ּ���.");
			result = false;
		}
		
		return result;
	}
	
	public static void dataEdit(ArrayList<Object> data, Scanner scan, int input) {
		Record edit = new Record();
		
		String msg = null;
		if (input == 3) {
			msg = "����";
		} else if (input == 4) {
			msg = "����";
		}
		
		boolean check = false;
		while (check) {
			edit.setScNum(inputNumber(msg+"�� �й��� �Է����ּ���.\n>", scan, input));
			
			for (Object r : data) {
				Record target = (Record) r;
				if ((target.scNum == edit.scNum) && !target.isDelete()) {
					check = true;
					edit = target;
					
					break;
				} else {
					System.out.println("�Է��� �߸��Ǿ����ϴ�.");
				}
			}
		}
		
		if (input == 3) {
			edit.inputScore(scan, input);
			System.out.println("�����Ǿ����ϴ�.");
			
		} else if (input == 4) {
			edit.setDelete(true);
			System.out.println("�����Ǿ����ϴ�.");
		}
	}
	
	public static void printRecord(ArrayList<Object> data) {
		String bar = "--------------------------------";
		String table = bar+"\n�й�\t|����\t|����\t|����\n"+bar;
		String tBar = "\t";
		
		System.out.println(table);
		for (Object r : data) {
			Record target = (Record) r;
			if (!target.isDelete()) {
				System.out.println(target.scNum + tBar + target.kor + tBar + target.eng + tBar + target.math + tBar + target.delete);
			}
		}
	}
}