package com.bit;
public class Ex03 {
	public static void main(String[] args) {
		Double num1;
		num1 = new Double(3);
		System.out.println(num1);				// 3.0 : 오토캐스팅
		
		Double num2 = 0.0/2;
		System.out.println(num2);
		Double num3 = 2.0/0;					// Infinity : underflow
		System.out.println(num3);
		Double num4 = 0.0/0;
		System.out.println(num4);
		
		System.out.println(num3.isInfinite());
		System.out.println(num4.isNaN());
	}
}
