package com.bit;
public class Lotto2 {
	public static void main(String[] args) {
		System.out.println("�ζ� ��ȣ ������ (v0.0.1)");

		int[] lotto = new int[45];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		for (int i=0; i<lotto.length; i++) {	// 45�� ���� (6ȸ �̻� ������ ��)
			int temp = 0;
			int ran = (int)(Math.random()*45);	// +1 ���� �ʴ� ���� : ran���� lotto[]�� �ε��� ������ ���ǹǷ� 45�� ������ �ȵ�.
			temp = lotto[ran];
			lotto[i] = temp;
		}
		
		for (int i=0; i<6; i++) {
			System.out.print(lotto[i]+" ");
		}
	}
}
