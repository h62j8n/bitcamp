package com.bit.day14;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07 {
	public static void main(String[] args) {
		Queue que = null;
		que = new LinkedList();
		
//		que.get(1);					// null�̶� ��� �Ұ�
		
		que.add("ù��°");
		que.offer("�ι�°");				// .offer() : .add()�� ������ �޼ҵ�
		que.offer("����°");
		que.offer("�׹�°");
		que.offer("�ټ���°");
		
		
		System.out.println(que.peek());		// .peek() : (������ ������ ��) ù ��° �� ���
		
		System.out.println(que.poll());		// ���� ������� ��ȯ, �� ����
		
		while (que.peek() != null) {		// ���� ����
			System.out.println(que.poll());
		}
	}
}
