package ch06;

public class Ex23 {
	public static int max(int[] arr) {
		int result = 0;
		try {
			for (int i=0; i<arr.length-1; i++) {
				boolean changed = false;
				int temp = 0;
				for (int j=0; j<(arr.length-1)-i; j++)	// -i : 한번 다 돌면 마지막 수는 가장 큰 수. 즉 i번 도는 동안 뒤에서 i번째 수까진 정렬이 완료됨.
					if (arr[j] > arr[j+1]) {			// 값이 다음 요소보다 크다면 자리 바꾸기
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						changed = true;					// 자리바꿈 표시
					}
				if (!changed) {break;}
			}
			result = arr[arr.length-1];					// 정렬에 의해 마지막 요소가 가장 큰 값
		} catch (NullPointerException/* | ArrayIndexOutOfBoundsException*/ e) {	// E | E  : 두 개의 예외를 한꺼번에 처리
			result = -99999;
		} catch (ArrayIndexOutOfBoundsException e) {
			result = -99999;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값 : "+max(data));
		System.out.println("최대값 : "+max(null));
		System.out.println("최대값 : "+max(new int[0]));	// 크기가 0인 배열
	}
}
