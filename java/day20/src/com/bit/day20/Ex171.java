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
		this.setKor(inputNumber("국어\n>", scan, input));
		this.setEng(inputNumber("영어\n>", scan, input));
		this.setMath(inputNumber("수학\n>", scan, input));
	}
	
	public static int inputNumber(String msg, Scanner scan, int input) {
		System.out.print(msg);
		input = scan.nextInt();
		return input;
	}
}

public class Ex171 extends Record {
	static String menuList = "1: 입력 2: 보기 3: 수정 4: 삭제 0: 종료\n>";
	static String[] subject = {"국어\n>", "영어\n>", "수학\n>"};
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
				System.out.println(scNum+"학번의 성적을 입력합니다.");
				
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
		
		System.out.println("이용해주셔서 감사합니다.");
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
				System.out.println("데이터 저장 완료");
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
				System.out.println("데이터 불러오기 완료");
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
			System.out.println("데이터가 없습니다. 데이터를 입력해주세요.");
			result = false;
		}
		
		return result;
	}
	
	public static void dataEdit(ArrayList<Object> data, Scanner scan, int input) {
		Record edit = new Record();
		
		String msg = null;
		if (input == 3) {
			msg = "수정";
		} else if (input == 4) {
			msg = "삭제";
		}
		
		boolean check = false;
		while (check) {
			edit.setScNum(inputNumber(msg+"할 학번을 입력해주세요.\n>", scan, input));
			
			for (Object r : data) {
				Record target = (Record) r;
				if ((target.scNum == edit.scNum) && !target.isDelete()) {
					check = true;
					edit = target;
					
					break;
				} else {
					System.out.println("입력이 잘못되었습니다.");
				}
			}
		}
		
		if (input == 3) {
			edit.inputScore(scan, input);
			System.out.println("수정되었습니다.");
			
		} else if (input == 4) {
			edit.setDelete(true);
			System.out.println("삭제되었습니다.");
		}
	}
	
	public static void printRecord(ArrayList<Object> data) {
		String bar = "--------------------------------";
		String table = bar+"\n학번\t|국어\t|영어\t|수학\n"+bar;
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