package ch06;

public class Ex20 {
	public static int[] shuffle(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			int ran = (int)(Math.random()*8);			// array index 0~8
			int temp;
			temp = arr[i];
			arr[i] = arr[ran];
			arr[ran] = temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
//		 [4, 6, 8, 3, 2, 9, 7, 1, 5]
	}
}
