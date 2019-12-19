package com.bit.day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class Car implements Comparable {
	int su;
	public Car(int su) {
		this.su = su;
	}
	public int compareTo(Object obj) {
		return su-((Car)obj).su;
	}
}

public class Ex11 {
	public static void main(String[] args) {
//		HashSet set = null;
//		set = new HashSet();
		TreeSet set = null;
		set = new TreeSet();
		
		Car car1 = new Car(1);
		Car car2 = new Car(2);
		Car car3 = new Car(3);
		Car car4 = new Car(4);
		
		set.add(car1);
		set.add(car2);
		set.add(car3);
		set.add(car4);
		set.add(22);
		set.add(31);
		set.add(444);
		set.add(500);
		set.add(22);
		
		System.out.println("size : "+set.size());	// ������ ��� �ߺ��� ���� 1���� ī��Ʈ
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());			// Ŀ������ ���� ����� ��ü���� ����Ű�� ����
		}
	}
}
