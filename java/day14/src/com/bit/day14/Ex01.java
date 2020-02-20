package com.bit.day14;

interface MyStack {								// #2. 스택 기능을 제공할 인터페이스
	void add(int val);
	int pull();
}

interface MyQueue {								// #2. 큐 기능을 제공할 인터페이스
	void add(int val);
	int pop();
}

class MyArrayList implements MyStack, MyQueue {
	private int arr[];							// #1. (캡슐화-정보의 은닉)
	// private : 필드의 값에 직접 접근(확인, 수정)하는 것을 막고
	// 대신 주어진 메소드를 통해 허용한 기능만을 사용하도록 유도
	
	public MyArrayList() {		// 생성자
		arr = new int[] {};
	}
	
	public void add(int val) {
		int[] temp = arr;
		arr = new int[arr.length+1];
		for (int i=0; i<temp.length; i++) {
			arr[i] = temp[i];
		}
		arr[arr.length-1] = val;
	}
	public int size() {
		return arr.length;
	}
	public int get(int idx) {
		return arr[idx];
	}
	public int pop() {			// Queue 구조
		int su = arr.length-1;
		int result = arr[su];		// 마지막 요소를 빼냄
		int[] temp = arr;
		arr = new int[su];
		for (int i=0; i<arr.length; i++) {
			arr[i] = temp[i];		// 1부터 마지막-1까지 담는 배열
		}
		return result;
	}
	public int pull() {			// Stack 구조
		int result = arr[0];		// 첫번째 요소를 빼냄
		int[] temp = arr;
		arr = new int[arr.length-1];
		for (int i=0; i<arr.length; i++) {
			arr[i] = temp[i+1];		// 2부터 마지막까지 담는 배열
		}
		return result;
	}
}

public class Ex01 {
	public static void main(String[] args) {
		MyQueue list = new MyArrayList();		// #2> 부모인터페이스 타입의해 큐 또는 스택 중에 선택적으로 사용하는 객체
		list.add(13);
		list.add(21);
		list.add(32);
		list.add(40);
		list.add(5);
		
//		list.arr[0] = 1;						// #1> The field MyArrayList.arr is not visible
		
//		while (list.size() != 0) {
//			System.out.print(list.pull()+" ");
			System.out.print(list.pop()+" ");
//		}
	}
}
