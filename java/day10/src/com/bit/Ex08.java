package com.bit;
public class Ex08 {
	public static void main(String[] args) {
		String[] arr1 = null;
		arr1 = new String[] {"java", "web", "framework"};	// 배열 요소가 주소값을 갖는 배열 (요소가 참조변수 String타입)
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");	// java web framework
		}
		System.out.println();
		
		arr1 = new String[3];
//		arr1[0] = "java";
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");	// 요소에 String타입 기본값 null이 자동초기화 되어있다.
		}
		System.out.println();
		
		int[] num1 = new int[]{1, 2, 3};
		int[] num2 = new int[]{};
		int[] num3 = new int[]{7, 8};
		int[][] arr2 = new int[][]{num1, num2, num3};	// 배열 요소로 배열을 갖는 배열

		arr2 = new int[][] {
				new int[]{1, 2, 3},
				new int[]{4, 5, 6},
				new int[]{7, 8, 9}
		};
		for (int i=0; i<arr2.length; i++) {
//			System.out.print(arr2[i]+ " ");	// {1, 2, 3}의 주소값, {4, 5, 6}의 주소값, {7, 8, 9}의 주소값
			for (int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		int[][] arr3 = null;
		arr3 = new int[3][];				// O : = new int[][]{null, null, null}; 배열이 참조형이므로 기본값 null.
											// X : = new int[][]{{}, {}, {}};
	}
}
