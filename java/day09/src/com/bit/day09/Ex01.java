package com.bit.day09;

public class Ex01 {
	public static void main(String[] args) {

//		msg1 = new String();	// 값: "" (문자가 없는 문자열. null과 다르다)
		String msg1 = "abcd";
		String msg2 = new String("abcd");
		String msg3 = "abcd";
		String msg4 = new String(msg1);				// 메소드영역, new와 함께 실행되므로 새로운 주소값 생성

		System.out.print("msg1 == msg2\t\t: ");
		System.out.println(msg1 == msg2);			// false. 참조변수(객체와 객체)의 비교
		
		System.out.print("msg1 == msg3\t\t: ");
		System.out.println(msg1 == msg3);			// true. 클래스 영역. 동일 객체(동일한 주소값)
		// 프로그램 실행 시 초기화된 문자열값을 모두 주소값으로 넣어두는데 이때 같은 문자열을 같은 주소에 넣음
		
		System.out.print("msg1.equals(msg2)\t: ");
		System.out.println(msg1.equals(msg2));		// true. 문자열리터럴의 비교
		
		System.out.print("msg1 == msg4\t\t: ");
		System.out.println(msg1 == msg4);			// false. 메소드영역. 주소값 다름
		
		System.out.print("\"abcd\".equals(msg1)\t: ");
		System.out.println("abcd".equals(msg1));	// true. 동일한 문자열
		
		
		// .equals()와 등가비교 연산자(==)
		String msg5 = "ab"+"cd";
		String msg6 = "ab".concat("cd");
		
		System.out.print("msg5 == \"abcd\"\t\t: ");
		System.out.println(msg5 == "abcd");			// true. 참조변수의 리터럴에 덧셈연산은 원칙적으로 불가능 하지만 문자열은 예외적으로 가능
		
		System.out.print("msg6 == \"abcd\"\t\t: ");
		System.out.println(msg6 == "abcd");			// false. 새로운 객체 생성.
		
		// 주소 값 비교와 문자열 값 비교
		Ex01 me = new Ex01();
		Ex01 you = me;

		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.print(">");
		String msg7 = scan.nextLine();				// "java"
		
		System.out.print("me == you\t\t: ");
		System.out.println(me == you);				// true. 참조변수 me와 you는 같은 객체를 가리킨다.
		
		System.out.print("msg7 == \"java\"\t\t: ");
		System.out.println(msg7 == "java");			// false. msg7과 "java"의 주소값이 다르다.
		
		System.out.print("msg7.equals(\"java\")\t: ");
		System.out.println(msg7.equals("java"));	// true. 문자열 값 비교
	}
}
