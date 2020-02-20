package com.bit;
public class Ex07 {
	public static void func1(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i==1) {arr[i] = 100;}
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		// 배열을 선언 및 초기화하는 3가지 방식
		int[] arr1 = {1, 3, 5, 7, 9};				// 1) 선언과 동시에 초기화
/* 		
 * 		int[] arr1;
 * 		arr1 = {1, 3, 5, 7, 9};
 *  	Err. 배열값의 타입이 불확실해서 사용할 수 없음
 */
		
		int[] arr21 = new int[]{1, 3, 5, 7, 9};		// 2) 선언과 동시에 초기화
		int[] arr22;
		arr22 = new int[]{1, 3, 5, 7, 9};			// 4) 선언 후 초기화
		arr22 = new int[]{1, 3, 5};					// 5) 선언, 초기화 후 길이 변경
		
		int[] arr3 = new int[5];					// 3) 선언. (배열의 요소는 모두 기본값(0)으로 자동초기화)
//		arr3[0] = 1;
//		arr3[1] = 3;
//		arr3[2] = 5;
//		arr3[3] = 7;
//		arr3[4] = 9;
		
		int[] arr5 = new int[arr1.length];		// 깊은 복사
		for (int i=0; i<arr5.length; i++) {			// func1 수행(복사한 arr1[]의 값 변화)하더라도 영향을 받지 않는다.
			arr5[i] = arr1[i];
		}
		
		System.out.println(arr1);
		System.out.println(arr21);
		System.out.println(arr3);
		
		int[] arr4 = arr1;						// 얕은 복사
		
		System.out.println(arr1 == arr21);			// false. 당연하지만 다른 객체
		System.out.println(arr1.equals(arr21));		// false. 또다시 나만 모르는 등가비교연산자와 .equals()의 차이
		System.out.println(arr1 == arr4);			// true. arr1 객체의 주소값을 arr4에 대입 > 동일한 객체 (배열의 복사)
		
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
		System.out.println();						// 초기화 후의 arr1
		func1(arr1);								// == int[] arr4 = arr1;
		System.out.println();
		
		for (int i=0; i<arr1.length; i++) {			// func1을 수행에 의해 arr1의 배열 요소가 영향을 받는다.
			System.out.print(arr1[i]+" ");
		}
	}
}
