package com.bit.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import com.bit.day20.Car;

public class Ex01 {
	public static void main(String[] args) {
		String path ="test03.bin";						// 20-Ex07���� run�ϰ� �� ���� ������ ����
		File file = new File(path);
		
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			
			Car car = (Car)obj;					// #5 obj�� CarŸ������ ����ȯ
			System.out.println("speed : "+car.speed+", color : "+car.color);
			car.func();
			System.out.println(obj);			// #1, #5 (#5�� ��� ��ü�� �ּ� ������)
			
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
