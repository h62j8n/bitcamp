package com.bit.day16;

import java.util.Arrays;
import java.util.List;

public class Ex17 {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 6, 23, 7, 5};
		int[] arr2 = {1, 3, 6, 23, 7, 5};
		System.out.println(arr1);
		System.out.println(arr1.toString());
		System.out.println(Arrays.toString(arr1));
		
		Arrays.sort(arr1);											// �迭 ����
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.binarySearch(arr1, 23));			// �ش� ����� �ε����ѹ� ��ȯ (���� ��� ����(���� ��)���)
		System.out.println(Arrays.binarySearch(arr2, 23));			// .sort() ���� �ʰ� ���� ���� ��Ȯ���� ��������. (binary : ����Ʈ��)
		
		System.out.println(Arrays.equals(arr1, arr2));				// �� �迭�� ���� ��Ҹ� ������ �ִ��� �˻�
//		System.out.println(Arrays.deepEquals(arr1, arr2));
		
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);				// �迭 ����
		System.out.println(list1);
		
		
		for (int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		int[] arr3 = new int[5];
		Arrays.fill(arr3, 100);										// �迭�� n������ ä��
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);				// ���� �迭���� ũ�ų� ���� ������ �迭�� ����
		System.out.println(arr4);									// ���� ���� (������ �ٸ� ��ü)
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = Arrays.copyOfRange(arr1, 1, arr1.length-1);	// ���� ���� (������ ������ ����)
		System.out.println(Arrays.toString(arr5));
		
	}
}
