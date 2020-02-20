package ch06;

public class Ex23 {
	public static int max(int[] arr) {
		int result = 0;
		try {
			for (int i=0; i<arr.length-1; i++) {
				boolean changed = false;
				int temp = 0;
				for (int j=0; j<(arr.length-1)-i; j++)	// -i : �ѹ� �� ���� ������ ���� ���� ū ��. �� i�� ���� ���� �ڿ��� i��° ������ ������ �Ϸ��.
					if (arr[j] > arr[j+1]) {			// ���� ���� ��Һ��� ũ�ٸ� �ڸ� �ٲٱ�
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						changed = true;					// �ڸ��ٲ� ǥ��
					}
				if (!changed) {break;}
			}
			result = arr[arr.length-1];					// ���Ŀ� ���� ������ ��Ұ� ���� ū ��
		} catch (NullPointerException/* | ArrayIndexOutOfBoundsException*/ e) {	// E | E  : �� ���� ���ܸ� �Ѳ����� ó��
			result = -99999;
		} catch (ArrayIndexOutOfBoundsException e) {
			result = -99999;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪 : "+max(data));
		System.out.println("�ִ밪 : "+max(null));
		System.out.println("�ִ밪 : "+max(new int[0]));	// ũ�Ⱑ 0�� �迭
	}
}
