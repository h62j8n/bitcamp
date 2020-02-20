package com.bit.day15;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Ex10 {
	public static void main(String[] args) {
		Vector vec = new Vector();
		vec.add(333);
		vec.add(2);
		vec.add(44);
		vec.add(11);
		vec.add(55555);
		
		Enumeration eles = vec.elements();
		while (eles.hasMoreElements()) {
			System.out.println(eles.nextElement());
		}
		
		System.out.println("-----");
		
		class Ex00 implements Comparator<Integer> {
			public int compare(Integer o1, Integer o2) {
				return o1-o2;			// 오름차순 정렬
//				return o2-o1;			// 내림차순 정렬
			}
		};
		
		vec.sort(new Ex00());
		
		eles = vec.elements();
		while (eles.hasMoreElements()) {
			System.out.println(eles.nextElement());
		}
		
		System.out.println("-----");
		
		List list = vec.subList(1, 3);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
