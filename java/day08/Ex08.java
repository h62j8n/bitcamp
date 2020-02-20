package com.bit;
class Ex08 {
  public static void main(String[] args) {
	int cnt1 = 0;
	int cnt2 = 0;
	for (int i=1; i<21; i++) { // 배열 길이(짝수 갯수)를 찾는 for문
		if (i%2 == 0) {
			cnt1++;
		}
		if (i%3 == 0) { // 배열 길이(3의 배수 갯수)를 찾는 for문
			cnt2++;
		}
	}
	System.out.println("\n---------------------------------------------------");

	int[] q1 = new int[cnt1]; // 배열 생성
	for (int i=0; i<cnt1; i++) { // 배열에 짝수 값 넣기
		int num = i+i+2;
		q1[i] = num;
		System.out.print(q1[i]+" ");

	}
	System.out.println("\n---------------------------------------------------");

	int[] q2 = new int[cnt2];
	for (int i=0; i<cnt2; i++) {
		int num = 0;
		for (int j=i; j<i+3; j++) {
			num+=j;
		}
		q2[i] = num;
		System.out.print(q2[i]+" ");
	}
	System.out.println("\n---------------------------------------------------");

	int q3Length = 'Z'-'A'+1;
	char q3[] = new char[q3Length];

	for (int i=0; i<q3Length; i++) {
		q3[i] = (char)(i+'A');	// (int)i + (char)'A' 명시적 형변환
		System.out.print(q3[i]+" ");
	}
	System.out.println("\n---------------------------------------------------");

/*	String star = "";
	String[][] q4 = new String[4][4];
*/
	System.out.println("\n---------------------------------------------------");

	absolute(-7);
	System.out.println("---------------------------------------------------");
	sort(7, 3, 5);
  }

  public static void absolute(int value) {
	if (value < 0) {
		value *= -1;
	}
	System.out.println(value);
  }
  public static void sort(int a, int b, int c) {
	int[] q7 = {a, b, c};
	for (int i=0; i<q7.length-1; i++) {
		int temp;
		if (q7[i] > q7[i+1]) {
			temp = q7[i];
			q7[i] = q7[i+1];
			q7[i+1] = temp;
		}
	}
	for (int i=0; i<q7.length; i++) {
		System.out.print(q7[i]+" ");
	}
  }
}