package com.bit.day14;

import java.util.Deque;
import java.util.LinkedList;

public class Ex08 {
	public static void main(String[] args) {
		Deque que;
		que = new LinkedList();
		
		// Queue
//		que.offer("ù��°");
//		que.offer("�ι�°");
//		que.offer("����°");
//		que.offer("�׹�°");
//		que.offer("�ټ���°");
		
//		while (que.peek() != null) {
//			System.out.println(que.poll());
//		}

		
//		que.offerFirst("ù��°");					// �տ������� �߰�
//		que.offerFirst("�ι�°");
//		que.offerFirst("����°");
//		que.offerFirst("�׹�°");
//		que.offerFirst("�ټ���°");
//		
//		while (que.peekFirst() != null) {
//			System.out.println(que.pollFirst());
//		}
//		while (que.peekLast() != null) {
//			System.out.println(que.pollLast());
//		}
		
		que.offerLast("ù��°");					// �ڿ������� �߰�
		que.offerLast("�ι�°");
		que.offerLast("����°");
		que.offerLast("�׹�°");
		que.offerLast("�ټ���°");
		
//		while (que.peekLast() != null) {
//			System.out.println(que.pollLast());
//		}
//		while (que.peekFirst() != null) {
//			System.out.println(que.pollFirst());
//		}
	}
}
