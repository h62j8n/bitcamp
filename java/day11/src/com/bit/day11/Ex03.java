package com.bit.day11;

public class Ex03 {
	public static void main(String[] args) {
		String st1 = "java";
//		System.out.println(st1);
		
		st1 = new String("java");
//		System.out.println(st1);
		
		char[] ch1 = {'J', 'A', 'V', 'A'};
		st1 = new String(ch1);
//		System.out.println(st1);
		
		st1 = String.valueOf(ch1);
//		System.out.println(st1);
		
		byte[] by1 = {106, 97, 118, 97};
//		System.out.println(by1);
		
		st1 = String.valueOf(by1);
//		System.out.println(by1);
		
		// 추가, 삽입, 수정, 삭제
		String target1 = "java";
		String target2 = "web";
		String result = null;
		
		// 추가 
		result = target1+target2;										// + : .concat()보다 좀 더 많은 역할 수행
		result = target1.concat(target2);								// .concat()
		System.out.println(result);
		
		// 삽입
		char[] tar1 = target1.toCharArray();							// .toCharArray()
		char[] tar2 = target2.toCharArray();
		char[] ch2 = new char[tar1.length+tar2.length];
		int cnt = 0;
		for (int i=0; i<2; i++) {
			ch2[cnt] = tar1[i];
			cnt++;
		}
		for (int i=0; i<tar2.length; i++) {
			ch2[cnt] = tar2[i];
			cnt++;
		}
		for (int i=2; i<tar1.length; i++) {
			ch2[cnt] = tar1[i];
			cnt++;
		}
		result = String.valueOf(ch2);
		System.out.println(result);
		
		// 수정
		char[] tar3 = target1.toCharArray();
		tar3[2] = (char)(tar3[2] - ('a'-'A'));
		result = String.valueOf(tar3);
		System.out.println(result);
		
		// 삭제
		char[] tar4 = new char[tar3.length-1];
		cnt = 0;
		for (int i=0; i<tar3.length; i++) {
			if (i==tar3.length) {continue;}
			tar4[cnt++] = tar3[i];
		}
		result = String.valueOf(tar3);
		System.out.println(result);
	}
}
