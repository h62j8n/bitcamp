package com.bit;
public class Ex08 {
	public static void main(String[] args) {
		String[] arr1 = null;
		arr1 = new String[] {"java", "web", "framework"};	// �迭 ��Ұ� �ּҰ��� ���� �迭 (��Ұ� �������� StringŸ��)
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");	// java web framework
		}
		System.out.println();
		
		arr1 = new String[3];
//		arr1[0] = "java";
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");	// ��ҿ� StringŸ�� �⺻�� null�� �ڵ��ʱ�ȭ �Ǿ��ִ�.
		}
		System.out.println();
		
		int[] num1 = new int[]{1, 2, 3};
		int[] num2 = new int[]{};
		int[] num3 = new int[]{7, 8};
		int[][] arr2 = new int[][]{num1, num2, num3};	// �迭 ��ҷ� �迭�� ���� �迭

		arr2 = new int[][] {
				new int[]{1, 2, 3},
				new int[]{4, 5, 6},
				new int[]{7, 8, 9}
		};
		for (int i=0; i<arr2.length; i++) {
//			System.out.print(arr2[i]+ " ");	// {1, 2, 3}�� �ּҰ�, {4, 5, 6}�� �ּҰ�, {7, 8, 9}�� �ּҰ�
			for (int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		int[][] arr3 = null;
		arr3 = new int[3][];				// O : = new int[][]{null, null, null}; �迭�� �������̹Ƿ� �⺻�� null.
											// X : = new int[][]{{}, {}, {}};
	}
}
