package com.bit.day14;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07 {
	public static void main(String[] args) {
		Queue que = null;
		que = new LinkedList();
		
//		que.get(1);					// null이라 사용 불가
		
		que.add("첫번째");
		que.offer("두번째");				// .offer() : .add()와 동일한 메소드
		que.offer("세번째");
		que.offer("네번째");
		que.offer("다섯번째");
		
		
		System.out.println(que.peek());		// .peek() : (위에서 내려다 봄) 첫 번째 값 출력
		
		System.out.println(que.poll());		// 넣은 순서대로 반환, 값 제거
		
		while (que.peek() != null) {		// 동적 구현
			System.out.println(que.poll());
		}
	}
}
