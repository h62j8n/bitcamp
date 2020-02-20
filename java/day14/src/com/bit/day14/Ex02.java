package com.bit.day14;

class Node {
	int val;
	Node next;
}

class MyLinked {
	Node start;
	int cnt;
	
	public int size() {			// add()메소드를 실행할때마다 cnt++. cnt의 값이 곧 배열의 길이
		return cnt;
	}
	
	/*		1: start = node;					// 이 구조를 만들고자 함.
	 *		2: start.next = node;
	 *		3: start.next.next = node;
	 *		4: start.next.next.next = node;
	 */
	public void add(int val) {
		cnt++;

		if (cnt == 1) {			// 시작 시 node의 값을 start에 저장
			Node node = new Node();
			node.val = val;
			start = node;
		} else {
			Node node = new Node();
			node.val = val;
			Node temp = start;
			while (true) {
				if (temp.next == null) {break;}		// #1. 다음 값이 없으면 탈출하고
				temp = temp.next;					// #2. 다음 값이 있으면 그 다음 값을 확인
			}
			temp.next = node;						// #3. null값을 가진 객체에게 node를 저장
		}
	}
	
	// 0: start.val
	// 1: start.next.val
	// 3: start.next.next.val
	public int get(int idx) {
		Node temp = start;							// temp변수가 start의 val값을 시작으로
		for (int i=0; i<idx; i++) {
			temp = temp.next;							// val값을 확인하며 다음 값, 다음 값으로 거쳐가는 과정
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
