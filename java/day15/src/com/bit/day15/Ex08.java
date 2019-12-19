package com.bit.day15;

class MyArray {
	int[] arr;
	int cnt;
	
	public MyArray() {
//		arr = new int[]{};						// #1. ��ȿ������ �迭�� ���� �߰�
		arr = new int[5];						// #2. ���� ���� �迭�� ���� �߰�
	}
/*
	public void add(int num) {					// #1.
		int[] temp = arr;
		arr = new int[arr.length+1];
		for (int i=0; i<temp.length; i++) {
			arr[i] = temp[i];
		}
		arr[arr.length-1] = num;
	}
*/
	public void add(int num) {					// #2.
		if (arr.length <= cnt) {				// (������ ���̸� �ʰ��� ��� #1)
			int[] temp = arr;
			arr = new int[arr.length+10];
			for (int i=0; i<temp.length; i++) {
				arr[i] = temp[i];
			}
		}
		arr[cnt] = num;
		cnt++;
	}
	public int size() {return cnt;}				// #2.
	public int get(int idx) throws Exception {	// #2. (������ ���̺��� Ŭ ��� ���� ������)
		if (idx >= cnt) {
			throw new Exception("index out");
		}
		return arr[idx];
	}
}

public class Ex08 {
	public static void main(String[] args) throws Exception {
		MyArray list = new MyArray();
		list.add(11);
		list.add(2);
		list.add(3333);
		list.add(44);
		list.add(5);
		list.add(11);
		list.add(2);
		list.add(3333);
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
