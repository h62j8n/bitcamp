package com.bit.day14;

import java.util.Enumeration;
import java.util.Vector;

public class Ex10 {
	public static void main(String[] args) {
		Vector vec;
		vec = new Vector();
		
		vec.addElement("1��°");
		vec.addElement("2��°");
		vec.addElement("3��°");
		vec.addElement("4��°");
		vec.addElement("5��°");
		
		System.out.println(vec.elementAt(0));
		System.out.println(vec.elementAt(1));
		System.out.println(vec.elementAt(2));
		System.out.println(vec.elementAt(3));
		System.out.println(vec.elementAt(4));
		System.out.println("-----");
		System.out.println(vec.firstElement());
		System.out.println(vec.lastElement());
		System.out.println("-----");
		
		vec.addElement("6��°");
		Enumeration eles = vec.elements();
		while (eles.hasMoreElements()) {
			System.out.println(eles.nextElement());
		}
		
		eles = vec.elements();
		while (eles.hasMoreElements()) {
			System.out.println(eles.nextElement());
		}
		
	}
}
