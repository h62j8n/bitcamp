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
		
		Arrays.sort(arr1);											// 배열 정렬
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.binarySearch(arr1, 23));			// 해당 요소의 인덱스넘버 반환 (없을 경우 음수(없는 수)출력)
		System.out.println(Arrays.binarySearch(arr2, 23));			// .sort() 하지 않고 쓰면 값의 정확도가 떨어진다. (binary : 이진트리)
		
		System.out.println(Arrays.equals(arr1, arr2));				// 두 배열이 같은 요소를 가지고 있는지 검사
//		System.out.println(Arrays.deepEquals(arr1, arr2));
		
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);				// 배열 생성
		System.out.println(list1);
		
		
		for (int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		
		int[] arr3 = new int[5];
		Arrays.fill(arr3, 100);										// 배열을 n값으로 채움
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);				// 원본 배열보다 크거나 작은 길이의 배열도 가능
		System.out.println(arr4);									// 깊은 복사 (원본과 다른 객체)
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = Arrays.copyOfRange(arr1, 1, arr1.length-1);	// 깊은 복사 (지정된 범위를 복사)
		System.out.println(Arrays.toString(arr5));
		
	}
}
