package com.bit;
public class Lotto1 {
	public static void main(String[] args) {
		System.out.println("�ζ� ��ȣ ������ (v0.0.1)");

		int[] lotto = new int[6];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			for (int j=0; j<0+i; j++) {
				if (lotto[i] == lotto[j]) {			// �ߺ��� ���
					System.out.println("�ߺ�");
					i--;							// �ٽ� ���� �� ����
					break;
				}
			}
		}
		// ���� ���� ������ ������ ����
		for (int i=0; i<lotto.length-1; i++) {		// ������ ������ ���� �ʴ´�
			for (int j=i+1; j<lotto.length; j++) {	// j = i ���� ��
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
