package com.bit.day11;

public class Ex08 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		try {
			int su = arr[3];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ȸ��");
		}
		 System.out.println("END"); // ����
	}
}