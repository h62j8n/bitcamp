package com.bit.day11;

public class Ex05 {
	public static void main(String[] args) {
		String target1 = "java";
		String target2 = "java";								// 문자열의 길이가 다를 경우
		System.out.println(target1.compareTo(target2));				// 0: 비교 값이 일치
		target2 = "javaWebString";
		System.out.println(target1.compareTo(target2));				// 9: 문자열 길이의 차이 숫자 반환
		System.out.println(target2.compareTo(target1));				// (char 배열로 바꾸어 한 글자씩 비교)
		
		target2 = "javd";										// 길이가 같을 경우
		System.out.println(target1.compareTo(target2));				// 3: 'd'와 'a'의 정수값의 차 반환
		target2 = "jaVa";
		System.out.println(target1.compareTo(target2));				// 32: 'v'와 대문자 'V'의 정수값의 차 반환
	}
}
