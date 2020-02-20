package com.bit;
public class Lotto1 {
	public static void main(String[] args) {
		System.out.println("로또 번호 생성기 (v0.0.1)");

		int[] lotto = new int[6];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			for (int j=0; j<0+i; j++) {
				if (lotto[i] == lotto[j]) {			// 중복할 경우
					System.out.println("중복");
					i--;							// 다시 랜덤 수 생성
					break;
				}
			}
		}
		// 작은 수를 앞으로 보내는 정렬
		for (int i=0; i<lotto.length-1; i++) {		// 마지막 수까지 돌지 않는다
			for (int j=i+1; j<lotto.length; j++) {	// j = i 다음 수
				int temp = 0;
				if (lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		for (int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
	}
}
