package com.bit.day14;

import java.util.Deque;
import java.util.LinkedList;

public class Ex08 {
	public static void main(String[] args) {
		Deque que;
		que = new LinkedList();
		
		// Queue
//		que.offer("첫번째");
//		que.offer("두번째");
//		que.offer("세번째");
//		que.offer("네번째");
//		que.offer("다섯번째");
		
//		while (que.peek() != null) {
//			System.out.println(que.poll());
//		}

		
//		que.offerFirst("첫번째");					// 앞에서부터 추가
//		que.offerFirst("두번째");
//		que.offerFirst("세번째");
//		que.offerFirst("네번째");
//		que.offerFirst("다섯번째");
//		
//		while (que.peekFirst() != null) {
//			System.out.println(que.pollFirst());
//		}
//		while (que.peekLast() != null) {
//			System.out.println(que.pollLast());
//		}
		
		que.offerLast("첫번째");					// 뒤에서부터 추가
		que.offerLast("두번째");
		que.offerLast("세번째");
		que.offerLast("네번째");
		que.offerLast("다섯번째");
		
//		while (que.peekLast() != null) {
//			System.out.println(que.pollLast());
//		}
//		while (que.peekFirst() != null) {
//			System.out.println(que.pollFirst());
//		}
	}
}
