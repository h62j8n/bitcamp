package com.bit;

class Ex06 {
  public static void main(String[] args) {

/* 내가 바라던 변수와 값... 하지만 있을 수 없어
	int a0 = 1;
	int a1 = 3;
	int a2 = 5;
	int a3 = 7;
	int a4 = 9;
	for (int i=0; i<5; i++) {
		ai = 1+2*i;
	}
*/

/* 배열은 가능하다. */
	int[] a = new int[5];			// 배열의 선언
	for (int i=0; i<a.length; i++) {	// 배열의 값 초기화
		a[i] = 1+2*i;
	}

	int[] b = new int[]{2, 4, 6, 8, 10};	// 배열의 선언과 초기화1

	int[] c = {10, 20, 30, 40, 50};		// 배열의 선언과 초기화2
  }
}