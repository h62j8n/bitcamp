package com.bit;
public class Ex07 {
	public static void func1(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i==1) {arr[i] = 100;}
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		// �迭�� ���� �� �ʱ�ȭ�ϴ� 3���� ���
		int[] arr1 = {1, 3, 5, 7, 9};				// 1) ����� ���ÿ� �ʱ�ȭ
/* 		
 * 		int[] arr1;
 * 		arr1 = {1, 3, 5, 7, 9};
 *  	Err. �迭���� Ÿ���� ��Ȯ���ؼ� ����� �� ����
 */
		
		int[] arr21 = new int[]{1, 3, 5, 7, 9};		// 2) ����� ���ÿ� �ʱ�ȭ
		int[] arr22;
		arr22 = new int[]{1, 3, 5, 7, 9};			// 4) ���� �� �ʱ�ȭ
		arr22 = new int[]{1, 3, 5};					// 5) ����, �ʱ�ȭ �� ���� ����
		
		int[] arr3 = new int[5];					// 3) ����. (�迭�� ��Ҵ� ��� �⺻��(0)���� �ڵ��ʱ�ȭ)
//		arr3[0] = 1;
//		arr3[1] = 3;
//		arr3[2] = 5;
//		arr3[3] = 7;
//		arr3[4] = 9;
		
		int[] arr5 = new int[arr1.length];		// ���� ����
		for (int i=0; i<arr5.length; i++) {			// func1 ����(������ arr1[]�� �� ��ȭ)�ϴ��� ������ ���� �ʴ´�.
			arr5[i] = arr1[i];
		}
		
		System.out.println(arr1);
		System.out.println(arr21);
		System.out.println(arr3);
		
		int[] arr4 = arr1;						// ���� ����
		
		System.out.println(arr1 == arr21);			// false. �翬������ �ٸ� ��ü
		System.out.println(arr1.equals(arr21));		// false. �Ǵٽ� ���� �𸣴� ��񱳿����ڿ� .equals()�� ����
		System.out.println(arr1 == arr4);			// true. arr1 ��ü�� �ּҰ��� arr4�� ���� > ������ ��ü (�迭�� ����)
		
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
		System.out.println();						// �ʱ�ȭ ���� arr1
		func1(arr1);								// == int[] arr4 = arr1;
		System.out.println();
		
		for (int i=0; i<arr1.length; i++) {			// func1�� ���࿡ ���� arr1�� �迭 ��Ұ� ������ �޴´�.
			System.out.print(arr1[i]+" ");
		}
	}
}
