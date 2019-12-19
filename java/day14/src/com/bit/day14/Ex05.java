package com.bit.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List list = null;
//		list = new ArrayList();
		list = new LinkedList();
		
		long start = System.currentTimeMillis();
		for (int i=0; i<9999999; i++) {
			list.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("ÀÔ·Â ³¡ : "+(end-start));
	}
}
