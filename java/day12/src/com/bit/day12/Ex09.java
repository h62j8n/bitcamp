package com.bit.day12;

public class Ex09 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
//		System.out.println(arr[3]); ����
		try {
			show(arr);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("����ȸ��");
		}
	}
	public static void show(int[] arr) throws ArrayIndexOutOfBoundsException {
//		for(int i=0; i<arr.length+1; i++) {
//			System.out.println(arr[i]);
//		}
		
		
		ArrayIndexOutOfBoundsException ex;
		ex = new ArrayIndexOutOfBoundsException();			// ���ܰ� �߻����� �ʴ´�.
		throw ex;											// ������ ���� ȸ��
	}
}
