package com.bit.day12;

public class Ex10 {
	public static void main(String[] args) {
		int[] arr1 = {2, 3, 0, 6};
		for (int i=0; i<arr1.length+1; i++) {
			try {
				System.out.println(6/arr1[i]);
			} catch (RuntimeException e) {
				System.out.println("���� �ذ�");			// ������. �� ������ �θ�Ŭ������ RuntimeException �ϳ��� ����
			}
//			} catch (ArithmeticException e) {
//				System.out.println("0���� ����� ����");
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("�ε��� ��ȣ �ʰ�");
//			}
		}
	}
}