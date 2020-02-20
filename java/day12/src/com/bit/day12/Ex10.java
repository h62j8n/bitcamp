package com.bit.day12;

public class Ex10 {
	public static void main(String[] args) {
		int[] arr1 = {2, 3, 0, 6};
		for (int i=0; i<arr1.length+1; i++) {
			try {
				System.out.println(6/arr1[i]);
			} catch (RuntimeException e) {
				System.out.println("에러 해결");			// 다형성. 두 예외의 부모클래스인 RuntimeException 하나로 제어
			}
//			} catch (ArithmeticException e) {
//				System.out.println("0으로 나누어서 오류");
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("인덱스 번호 초과");
//			}
		}
	}
}