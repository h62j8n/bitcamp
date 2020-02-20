package com.bit;
public class Ex09 {
	public static void main(String[] args) {
		int[] arr = {9, 7, 5, 1, 3};
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-1-i; j++) {	// 배열 끝부터 i의 갯수만큼 큰 수가 쌓인다.
				boolean changed = false;
				int temp = 0;
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					changed = true;
				}
				if (!changed) {
					break;
				}
			}
		}
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
