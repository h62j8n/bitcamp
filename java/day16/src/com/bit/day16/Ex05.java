package com.bit.day16;

public class Ex05 {
	public static void main(String[] args) {
		int[] source = {1,3,5,7,8,9,13,23,45,67,89,90};
		int[] target = new int[source.length];
		
//		for (int i=0; i<target.length; i++) {	// �迭�� ���� ����
//			target[i] = source[i];
//		}
		System.arraycopy(source, 0, target, 0, target.length);
		source[3] = 6;							// ���� �迭�� ��Ұ� ����Ǿ ������ �迭�� ����
		
		int[] target2 = new int[5];
		System.arraycopy(source, 2, target2, 1, 4);
		
		for (int i=0; i<target2.length; i++) {
			System.out.println(target2[i]);
		}
	}
}
