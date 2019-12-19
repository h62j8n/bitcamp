package com.bit.day14;

class Node {
	int val;
	Node next;
}

class MyLinked {
	Node start;
	int cnt;
	
	public int size() {			// add()�޼ҵ带 �����Ҷ����� cnt++. cnt�� ���� �� �迭�� ����
		return cnt;
	}
	
	/*		1: start = node;					// �� ������ ������� ��.
	 *		2: start.next = node;
	 *		3: start.next.next = node;
	 *		4: start.next.next.next = node;
	 */
	public void add(int val) {
		cnt++;

		if (cnt == 1) {			// ���� �� node�� ���� start�� ����
			Node node = new Node();
			node.val = val;
			start = node;
		} else {
			Node node = new Node();
			node.val = val;
			Node temp = start;
			while (true) {
				if (temp.next == null) {break;}		// #1. ���� ���� ������ Ż���ϰ�
				temp = temp.next;					// #2. ���� ���� ������ �� ���� ���� Ȯ��
			}
			temp.next = node;						// #3. null���� ���� ��ü���� node�� ����
		}
	}
	
	// 0: start.val
	// 1: start.next.val
	// 3: start.next.next.val
	public int get(int idx) {
		Node temp = start;							// temp������ start�� val���� ��������
		for (int i=0; i<idx; i++) {
			temp = temp.next;							// val���� Ȯ���ϸ� ���� ��, ���� ������ ���İ��� ����
		}
		return temp.val;
	}
}
public class Ex02 {
	public static void main(String[] args) {
		MyLinked list = new MyLinked();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
