package com.bit;
public class Ex05 {
	public static void main(String[] args) {
		Character ch1;
		ch1 = new Character('A');
		
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);			// 별 의미가 없다.
		
		System.out.println(Character.isDefined('a'));		// ?? 'A'와 'a'
		
		char target = '@';									// 대문자,소문자,특수문자,숫자 등 다양하게 써보고 비교하기
		
		System.out.println(Character.isDefined(target));	// 유니코드인지
		
		System.out.println(Character.isAlphabetic(target));	// 문자인지
		System.out.println(Character.isLetter(target));
		
		System.out.println(Character.isDigit(target));		// 숫자인지
		
		System.out.println(Character.isUpperCase(target));	// 대문자인지
		
		System.out.println(Character.isLowerCase(target));	// 소문자인지
		
		System.out.println(Character.isSpace(target));	// (구)공백인지
		System.out.println(Character.isWhitespace(target));	// 공백인지
	}
}
