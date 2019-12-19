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
			
//			Vector vec = (Vector)obj;			// #2 Object obj�� VectorŸ������ ����ȯ
//			Enumeration eles = vec.elements();	// (�ۼ��ߴ� �ڷᱸ���� ��ȯ�Ͽ� �о���̴� ��. �ۼ��ߴ� ��Ĵ�� ����� �� �ִ�.)
//			while (eles.hasMoreElements()) {
//				System.out.println(eles.nextElement());
//			}
			
			ArrayList list = (ArrayList)obj;	// #3 obj�� ArrayListŸ������ ����ȯ
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
			
//			ArrayList list = (ArrayList)obj;	// #4 ArrayListŸ�� �ƿ�ǲ��, �� �ȿ� �ִ� VectorŸ�� �ƿ�ǲ ���
//			System.out.println(list.get(0));
//			System.out.println(list.get(1));
//			System.out.println(list.get(2));
//			Vector vec2 = (Vector)list.get(3);
//			Enumeration enu = vec2.elements();
//			while (enu.hasMoreElements()) {
//				System.out.println(enu.nextElement());
//			}
			
//			Car car = (Car)obj;					// #5 obj�� CarŸ������ ����ȯ
//			System.out.println("speed : "+car.speed+", color : "+car.color);
//			car.func();
//			System.out.println(obj);			// #1, #5 (#5�� ��� ��ü�� �ּ� ������)
			
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
