package com.bit.day11;

public class Ex04 {
	public static void main(String[] args) {
		
		String target = "java";
		String result = null;
		
		result = target.replace('v', 'V');
		result = target.replace("v", "V");				// 동일한 결과 반환 (오버라이드)
		System.out.println(result);
		
		result = target.replace("va", "VA");
		System.out.println(result);

		result = target.replace("va", "");
		System.out.println(result);
		
		result = target.replace("av", "aWebv");
		System.out.println(result);
		
		System.out.println(target == result);			// result는 계속 새로운 객체를 생성해서 값을 가짐
														// result = new String(target.replace("av", "aWebv"));
		System.out.println(target);
		
		System.out.println(target.contains("V"));		// 해당 문자열을 포함하고 있는지
		System.out.println(target.startsWith("jav"));	// 해당 문자열로 시작하는지
		System.out.println(target.endsWith("a"));		// 해당 문자열로 끝나는지
		
		System.out.println(target.indexOf('j'));		// 특정 문자 또는 문자열의 순서
		System.out.println(target.indexOf('a'));		// 같은 문자가 여러개일 경우 가장 처음에 등장한 위치 반환
		System.out.println(target.indexOf('z'));		// 포함되지 않은 문자일 경우 -1 반환
		System.out.println(target.indexOf("av"));		// 인자가 문자열일 경우 해당 문자열이 처음 등장한 위치 반환
		System.out.println(target.lastIndexOf('j'));	// 특정 문자 또는 문자열의 순서 (뒤에서부터)
		System.out.println(target.lastIndexOf('a'));	// 같은 문자가 여러개일 경우 가장 마지막에 등장한 위치 반환
		System.out.println(target.indexOf("av"));		// 인자가 문자열일 경우 인자의 앞자리 수를 기준으로 카운트
		
		target = "JavaWebSpring";
		System.out.println(target.substring(2));		// n번째 위치 이후의 문자열 반환
		System.out.println(target.substring(4, 7));		// n1번째 위치 이후, n2번째 위치 이전까지의 문자열 반환
		// 4: 0,1,2,3,4 | 7: 1,2,3,4,5,6,7	n1 지정 후 n1은 빼고 순서 셈
		
		System.out.println(target.toLowerCase());		// 소문자로 일괄 반환
		System.out.println(target.toUpperCase());		// 대문자로 일괄 반환
		
		System.out.println(target);						// hashcode값이 아닌 .toString()값이 자동 반환 
		
		target = "			ab		cd	e	\n";
		System.out.println("\""+target+"\"");
		System.out.println("\""+target.trim()+"\"");	// 앞 뒤 공백, 엔터 제거
	}
}
