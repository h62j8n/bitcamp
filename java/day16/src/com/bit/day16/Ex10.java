package com.bit.day16;

public class Ex10 {
	protected Object clone() throws CloneNotSupportedException {		// 4. clone()�޼ҵ� �������̵�
//		return this;														// me�� ���� ��ü
		return new Ex10();												// 5. me�ʹ� �ٸ� ���ο� ��ü�� �����Ͽ� clone() ����
	}
	public static void main(String[] args) {
		Object obj = new Object();
		
//		obj.clone();							// 1. �������� protected�� ���� ����� �� ����
		Ex10 me = new Ex10();					// 2. ���� ���� Ŭ������ Object�� ����ϹǷ� clone() ��� ����
		try {
			Object you = me.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();				// 3. �׷��� ������ ����.
		}
		
	}
}
