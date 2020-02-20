package com.bit.day09;

public class Ex04 {
	public static void main(String[] args) {
		final int SIZE = 6;									// �ʿ��� ���� : 6��
		final int LENGTH = 45;								// ������ ���� : 1~45 (�� 45��)
		int[] arr = new int[LENGTH];
		for (int i=1; i<LENGTH+1; i++) {					// 1���� 45���� ���� �迭 ����
			arr[i-1] = i;
		}
		// Ȯ��
		System.out.print("�ʱ�ȭ �� : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for (int i=0; i<SIZE; i++) {						// �迭�� 1���� 6��°������ ����
			int temp = (int)(Math.random()*45);				// ?��° �迭 ���� ��ȯ
			arr[i] = arr[temp];
		}
		// Ȯ��
		System.out.print("���� �� : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		for (int i=0; i<SIZE-1; i++) {						// ��/��ȯ�ϴ� 2�� �� ��Ʈ for��
			boolean changed = false;	// ��ȯ ����ġ. ���� if���� ���� ���� �� false�� ���ʱ�ȭ
			int temp = 0;
			for (int j=0; j<(SIZE-1)-i; j++) {	// �񱳴�� : �񱳴������ ���� ��
				if (arr[j] > arr[j+1]) {					// ����(��, ��ȯ) if��
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					changed = true;		// ��ȯ true. �� if�� �ȿ� �ִٸ� ��ȯ�� (����ġ�� ƼŰŸī)
				}
			}
			if (!changed) {break;}		// i�� �� ���� �ʾƵ� ���� if���� ���� �� ����ġ true�� ���� for�� ����
		}
		
		// Ȯ��
		System.out.print("���� �� : ");
		for (int i=0; i<SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
