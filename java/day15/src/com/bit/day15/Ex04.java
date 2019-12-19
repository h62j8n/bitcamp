package com.bit.day15;

class Box04<T, V> {
	T num;
	V msg;
	
	public void setNum(T num) {		// ���ڸ� �޾� �ʵ� num�� ������ ��ȯ
		this.num = num;
	}
	public void setMsg(V msg) {		// ���ڸ� �޾� �ʵ� msg�� ������ ��ȯ
		this.msg = msg;
	}
	public T getNum() {				// �ʵ� num�� �� ��ȯ
		return num;
	}
	public V getMsg() {				// �ʵ� msg�� �� ��ȯ
		return msg;
	}
}

public class Ex04 {
	public static void main(String[] args) {
/*
 *		Box04 box = new Box04();				// ���׸��� ����� Ȯ���ϱ�
 *		box.setNum(1111);
 *		box.setMsg("ȯ���մϴ�");
 *		System.out.println(box.getNum());		// warn> Object com.bit.day15.Box04.getNum()
 *		System.out.println(box.getMsg());		//  : ���׸� ĳ���� ���� ����� ��� Object
 */
		
		Box04<Integer, String> box = new Box04<Integer, String>();	// ���׸� T,V�� Ÿ���� �����Ͽ� �ν��Ͻ� ����
		box.setNum(1111);
		box.setMsg("ȯ���մϴ�");
		System.out.println(box.getNum());		// OK> Integer com.bit.day15.Box04.getNum()
		System.out.println(box.getMsg());
	}
}
