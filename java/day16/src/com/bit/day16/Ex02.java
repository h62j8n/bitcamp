package com.bit.day16;

public class Ex02 {
	public static void main(String[] args) {
		StringBuffer buf1 = new StringBuffer();
		System.out.println(buf1.capacity());		// default : 16
		
		for (int i=0; i<16; i++) {
			buf1.append('a');
			System.out.print(buf1.length()+" : ");
			System.out.println(buf1.capacity());
		}
		
		// 저장용량 초과 시
		buf1.append('a');
		System.out.print(buf1.length()+" : ");
		System.out.println(buf1.capacity());		// default : 16 초과 시점에 보유한 문자열 길이(17)의 두배로 저장공간 확장
		buf1.trimToSize();							// .trimToSize() : 저장용량을 초과한 문자열 길이만큼만 확장
		System.out.print(buf1.length()+" : ");
		System.out.println(buf1.capacity());
		
		StringBuffer buf2 = new StringBuffer(5);	// StringBuffer 객체 생성 시 기본 저장공간을 5로 지정할 수 있다.
		System.out.println(buf2.capacity());
//		String str = new String(5);					// Err : String클래스는 저장공간이 없다. ?

		String str = "javaweb";
		char[] chs = str.toCharArray();
		
		StringBuilder build1 = new StringBuilder("문자열");	// StringBuffer(CharSequence seq)
		StringBuffer buf3 = new StringBuffer(build1);		// : 생성자로 조상클래스를 받을 수 있기 때문에 서로 값을 넘겨받을 수 있다.
		
		System.out.println(buf3.capacity());				// 객체 생성 시 문자열을 담았을 경우 저장공간은 해당 문자열의 길이+16
	}
}
