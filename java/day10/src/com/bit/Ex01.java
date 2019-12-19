package com.bit;

public class Ex01 {
	public static void main(String[] args) {
		java.lang.Integer num1;
		
		num1 = new Integer("100");
		System.out.println(num1);			// "100"이라는 문자열로 넣었지만 Integer 값으로 받음
		
		num1 = new Integer(100);			// ?? 패키지명 생략가능
		Integer num2 = new Integer("200");
		// # 오토래핑 / 박싱
		Integer num3 = 100;					// 변수타입(Integer)과 리터럴타입(int) 불일치(원칙상 불가능) > auto wrapping(boxing)
		
		// # 언래핑 / 언박싱
		System.out.println(num1+1);			// (Integer)100 + (int)1 > Unwrapping : (int)100 + (int)1 
		System.out.println(num1+num2);		// (Integer)100 + (Integer)200 > Unwrapping : (int)100+(int)200
		int b = num2+num3;
		
		// API Integer fields
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		
		// API Integer method
		Integer num4 = new Integer("100");
		byte b1 = num4.byteValue();			// ??(num4-뭐라고 표현)의 byte형 값 출력
		System.out.println(num4+" : "+b1);
		
		System.out.println(num1 == num4);	// value값/레퍼런스값 비교. unwrapping 했다고 해서 값이 같은 것은 아님
		System.out.println(num1.equals(num4));
		
		String msg = "1234";
		Integer num5 = Integer.valueOf(msg);// valueOf(String s) : 숫자만 나열된 문자열을 Integer값으로 반환 
		System.out.println(num5);
		System.out.println(num5.intValue());// Integer의 값을 int형 값으로 반환
		
		int num6 = Integer.max(2, 3);		// 파라미터의 값 중 더 큰 값을 반환
		System.out.println(num6);
		
		int num7 = Integer.parseInt(msg);	// ?? int로 반환
		int num8 = Integer.valueOf(msg);	// ?? 언래핑 후에 int로 반환 (jdk 버전 호환성이 낮음)
		
		int num9 = Integer.reverse(num7);	// 비트값을 거꾸로 반환 몰라도 될 듯
		
		int num10 = 16;						// 진법 변환 메소드
		System.out.println(num10+"의 2진수 : "+Integer.toBinaryString(num10));
		System.out.println(num10+"의 8진수 : "+Integer.toOctalString(num10));
		System.out.println(num10+"의 16진수 : "+Integer.toHexString(num10));
		
		int num11 = Integer.compare(1, 1);	// static
		System.out.println(num11);
		int num12 = num4.compareTo(99);		// non-static
		System.out.println(num12);
		
	}
}
