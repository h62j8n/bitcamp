package com.bit.day16;

import java.util.Random;

public class Ex16 {
	public static void main(String[] args) {
		Random ran = new Random();
		System.out.println(ran);						// 주소값
		
		System.out.println(ran.nextInt());				// Int 범위 내의 랜덤한 정수리터럴
		System.out.println(ran.nextDouble());			// Double 범위 내의 랜덤한 실수리터럴 (Math.Random()과 유사)
		
		System.out.println(ran.nextInt(3));				// (0 <= ran && ran <= 매개변수-1) 범위
	}
}
