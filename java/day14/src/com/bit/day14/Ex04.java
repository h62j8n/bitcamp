package com.bit.day14;

import java.util.LinkedList;

public class Ex04 {
	public static void main(String[] args) {
		LinkedList list;
		list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
