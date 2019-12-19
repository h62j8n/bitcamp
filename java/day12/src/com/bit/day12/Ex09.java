package com.bit.day12;

public class Ex09 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
//		System.out.println(arr[3]); 예외
		try {
			show(arr);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외회피");
		}
	}
	public static void show(int[] arr) throws ArrayIndexOutOfBoundsException {
//		for(int i=0; i<arr.length+1; i++) {
//			System.out.println(arr[i]);
//		}
		
		
		ArrayIndexOutOfBoundsException ex;
		ex = new ArrayIndexOutOfBoundsException();			// 예외가 발생하지 않는다.
		throw ex;											// 던지면 예외 회피
	}
}
