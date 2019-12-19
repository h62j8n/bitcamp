package com.bit.day09;

public class Ex04 {
	public static void main(String[] args) {
		final int SIZE = 6;									// 필요한 숫자 : 6개
		final int LENGTH = 45;								// 숫자의 범위 : 1~45 (총 45개)
		int[] arr = new int[LENGTH];
		for (int i=1; i<LENGTH+1; i++) {					// 1부터 45까지 숫자 배열 생성
			arr[i-1] = i;
		}
		// 확인
		System.out.print("초기화 값 : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for (int i=0; i<SIZE; i++) {						// 배열의 1부터 6번째까지의 값을
			int temp = (int)(Math.random()*45);				// ?번째 배열 값과 교환
			arr[i] = arr[temp];
		}
		// 확인
		System.out.print("셔플 값 : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for (int i=0; i<SIZE-1; i++) {						// 비교/교환하는 2개 한 세트 for문
			boolean changed = false;	// 교환 스위치. 정렬 if문에 들어가기 전에 늘 false로 재초기화
			int temp = 0;
			for (int j=0; j<(SIZE-1)-i; j++) {	// 비교대상 : 비교당사자의 다음 값
				if (arr[j] > arr[j+1]) {					// 정렬(비교, 교환) if문
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					changed = true;		// 교환 true. 이 if문 안에 있다면 교환됨 (스위치와 티키타카)
				}
			}
			if (!changed) {break;}		// i가 다 돌지 않아도 정렬 if문이 끝난 후 스위치 true와 만나 for문 종료
		}
		
		// 확인
		System.out.print("정렬 값 : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
