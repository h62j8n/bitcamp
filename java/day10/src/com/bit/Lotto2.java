package com.bit;
public class Lotto2 {
	public static void main(String[] args) {
		System.out.println("로또 번호 생성기 (v0.0.1)");

		int[] lotto = new int[45];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		for (int i=0; i<lotto.length; i++) {	// 45번 섞음 (6회 이상만 섞으면 됨)
			int temp = 0;
			int ran = (int)(Math.random()*45);	// +1 하지 않는 이유 : ran값은 lotto[]의 인덱스 값으로 사용되므로 45가 나오면 안됨.
			temp = lotto[ran];
			lotto[i] = temp;
		}
		
		for (int i=0; i<6; i++) {
			System.out.print(lotto[i]+" ");
		}
	}
}
