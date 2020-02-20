package com.bit.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class Ex08 {
	public static void main(String[] args) {
		String path ="test03.bin";
		File file = new File(path);
		
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			
//			Vector vec = (Vector)obj;			// #2 Object obj를 Vector타입으로 형변환
//			Enumeration eles = vec.elements();	// (작성했던 자료구조로 변환하여 읽어들이는 것. 작성했던 방식대로 사용할 수 있다.)
//			while (eles.hasMoreElements()) {
//				System.out.println(eles.nextElement());
//			}
			
			ArrayList list = (ArrayList)obj;	// #3 obj를 ArrayList타입으로 형변환
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
			
//			ArrayList list = (ArrayList)obj;	// #4 ArrayList타입 아웃풋과, 그 안에 있는 Vector타입 아웃풋 출력
//			System.out.println(list.get(0));
//			System.out.println(list.get(1));
//			System.out.println(list.get(2));
//			Vector vec2 = (Vector)list.get(3);
//			Enumeration enu = vec2.elements();
//			while (enu.hasMoreElements()) {
//				System.out.println(enu.nextElement());
//			}
			
//			Car car = (Car)obj;					// #5 obj를 Car타입으로 형변환
//			System.out.println("speed : "+car.speed+", color : "+car.color);
//			car.func();
//			System.out.println(obj);			// #1, #5 (#5의 경우 객체의 주소 보낸다)
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {		// Object obj = ois.readObject();
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
				if (is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
