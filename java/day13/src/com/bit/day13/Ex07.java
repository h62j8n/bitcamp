package com.bit.day13;

class Outter07 {
	static int su1 = 1111;
	int su2 = 2222;

	public Outter07() {
		System.out.println("Outter");
	}
	public static void func01() {
		System.out.println("Outter static f1");
		System.out.println(Inner07.su3);
	}
	public void func03() {
		System.out.println("Outter staitc f2");
	}
	
	static class Inner07 {
		static int su3 = 3333;
		int su4  = 4444;
		public Inner07() {
			System.out.println("Inner");
		}
		static void func03() {
			System.out.println("Inner static f3");
		}
	}
}
public class Ex07 {
	public static void main(String[] args) {
		System.out.println(Outter07.Inner07.su3);
		Outter07.Inner07.func03();
		
		Outter07.Inner07 inn = new Outter07.Inner07();
		
	}
}
