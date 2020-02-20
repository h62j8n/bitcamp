package com.bit.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class Ex07 {
	public static void main(String[] args) {
//		String obj = new String("java Object");	// #1
		
//		Vector obj = new Vector();				// #2
//		obj.add(1234);			// int형 리터럴의 오토캐스팅
//		obj.add(1234);
//		obj.add(false);
//		obj.add("출력");
//		obj.add('A');
		
		ArrayList obj = new ArrayList();		// #3
		obj.add("\n1\t|100\t|100\t|100");
		obj.add("\n2\t|20\t|20\t|20");
		obj.add("\n3\t|30\t|30\t|30");
		
//		Vector obj2 = new Vector();				// #4
//		obj2.add(1234);
//		obj2.add(1234);
//		obj2.add(false);
//		obj2.add("출력");
//		obj2.add('A');
//		ArrayList obj = new ArrayList();
//		obj.add(4321);
//		obj.add("잘 들어감");
//		obj.add("!@#$%");
//		obj.add(obj2);
		
//		Car obj = new Car();					// #5 내가 작성한 클래스타입의 객체 작성하기
												// day20 com.bit.day20 Car.java
		
		String path = "test03.bin";
		File file = new File(path);
		
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		try {
			os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(obj);
			
			System.out.println("작성 완료");
			
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
}
