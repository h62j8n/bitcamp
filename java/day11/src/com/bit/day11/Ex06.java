package com.bit.day11;

public class Ex06 {
	public static void main(String[] args) {
		String target = "java    DB web Spring android";
		String[] data = target.split(" ");						// 인자 값을 기준으로 문자열을 잘라 배열로 반환
		
		System.out.println(data.length);
		
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
