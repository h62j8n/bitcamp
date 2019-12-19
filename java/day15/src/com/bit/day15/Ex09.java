package com.bit.day15;

import java.util.Vector;

public class Ex09 {
	public static void main(String[] args) {
//		Vector vec1 = new Vector();
//		Vector vec1 = new Vector(5);
		Vector vec1 = new Vector(3, 3);						// (n, n) : 처음 저장공간 수, 요소 추가 시 증가량
		System.out.println("(0) : "+vec1.capacity());
		
		for (int i=0; i<10; i++) {
			vec1.add(i);
		}
		vec1.trimToSize();
		System.out.println("(10) : "+vec1.capacity());
		
/*		
		vec1.add(11);
		System.out.println("(11) : "+vec1.capacity());
		
		for (int i=0; i<10; i++) {
			vec1.add(i);
		}
		System.out.println("(21) : "+vec1.capacity());		// 현재 저장공간의 2배씩 늘림
*/
		
//		Vector vec2 = vec1;									// 벡터 배열의 얕은 복사
//		vec1.add(1111);										// 원본 배열의 변경에 복사한 배열이 영향을 받음
		Vector vec2 = new Vector(vec1);						// 벡터 배열의 깊은 복사
//		vec2.add(1234);
		vec2.addAll(vec1);
		for (int i=0; i<vec1.size(); i++) {
			System.out.print(vec1.elementAt(i)+" ");
		}
		System.out.println("\n-----");
		for (int i=0; i<vec2.size(); i++) {
			System.out.print(vec2.elementAt(i)+" ");
		}
	}
}
