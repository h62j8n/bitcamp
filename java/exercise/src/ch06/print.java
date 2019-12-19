package ch06;

public class print {
	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for (int i=0; i<arr.length-1; i++) {
			boolean changed = false;
			int temp = 0;
			for (int j=0; j<(arr.length-1)-i; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					changed = true;
				}
			}
			if (!changed) {break;}
		}
	}
}
