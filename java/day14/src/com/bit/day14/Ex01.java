package com.bit.day14;

interface MyStack {								// #2. ���� ����� ������ �������̽�
	void add(int val);
	int pull();
}

interface MyQueue {								// #2. ť ����� ������ �������̽�
	void add(int val);
	int pop();
}

class MyArrayList implements MyStack, MyQueue {
	private int arr[];							// #1. (ĸ��ȭ-������ ����)
	// private : �ʵ��� ���� ���� ����(Ȯ��, ����)�ϴ� ���� ����
	// ��� �־��� �޼ҵ带 ���� ����� ��ɸ��� ����ϵ��� ����
	
	public MyArrayList() {		// ������
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
	public int pop() {			// Queue ����
		int su = arr.length-1;
		int result = arr[su];		// ������ ��Ҹ� ����
		int[] temp = arr;
		arr = new int[su];
		for (int i=0; i<arr.length; i++) {
			arr[i] = temp[i];		// 1���� ������-1���� ��� �迭
		}
		return result;
	}
	public int pull() {			// Stack ����
		int result = arr[0];		// ù��° ��Ҹ� ����
		int[] temp = arr;
		arr = new int[arr.length-1];
		for (int i=0; i<arr.length; i++) {
			arr[i] = temp[i+1];		// 2���� ���������� ��� �迭
		}
		return result;
	}
}

public class Ex01 {
	public static void main(String[] args) {
		MyQueue list = new MyArrayList();		// #2> �θ��������̽� Ÿ������ ť �Ǵ� ���� �߿� ���������� ����ϴ� ��ü
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
