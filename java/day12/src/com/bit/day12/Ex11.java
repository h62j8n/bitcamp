package com.bit.day12;

class BitException extends Exception {
	public BitException() {
//		super("0으로 나눌 수 없음");					// 생성자 오버라이딩 테스트를 위해 주석달고 확인
	}
	public BitException(String msg) {
		super(msg);
	}
}

public class Ex11 {
	public static void main(String[] args) {
//		try {
//			int su = 2/0;
//		} catch (ArithmeticException e) {
//			System.out.println(e);
//			System.out.println(e.toString());
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		try {
			int result = div(4,0);
			System.out.println(result);
		} catch (BitException e) {
			System.out.println("0으로 나눔");
		}
	}
	
//	public static int div(int a, int b) throws ArithmeticException {	// 일반적인 메소드 수행
//		if (b==0) {
//			ArithmeticException err;
//			err = new ArithmeticException();
//			throw err;													// 그 안에서 예외상황이 발생할 경우에만 throw
//		}
//		return a/b;
//	}
	public static int div(int a, int b) throws BitException {			// 사용자 정의 클래스로 예외 처리
		if (b==0) {
			BitException err;
			err = new BitException("예외클래스 생성자 오버라이드");
			throw err;
		}
		return a/b;
	}
}
