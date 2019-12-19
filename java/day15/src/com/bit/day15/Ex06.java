package com.bit.day15;

class Box06<T> {
	T num;
	
	public void setNum(T num) {
		this.num = num;
	}
	public T getNum() {
		return num;
	}
}

public class Ex06 {
	public static void main(String[] args) {
//		Box06<Integer> box = new Box06<>();				// �⺻������ ���׸� ���

		Box06<? super Number> box1 = new Box06<>();		// #1: <"?" : ���׸��� ������ �ʾ�����, "super Number"> : ����Ŭ�����κ��� Number�� ��ӹ��� ���� �� �� �ִ�.
		box1.setNum(1111);
		box1.setNum(3.14);
//		box.setNum("aaa");								// #1>: Err. NumberŸ�Կ� ���� ���� ���� �����Ӱ� �Է� �����ϳ� StringŸ�� ���� �ȵ�

		Number num1 = (Number)box1.getNum();				// #1> ����� �� NumberŬ���� Ÿ������ ����ȯ�ؼ� ���
		
		Box06<? extends Number> box2 = new Box06<>();	// #2: ????? super�� �ݴ��� ���� (���� ����ϴ� ����)
//		box.setNum(1111);								// #2> Err. ���� �Է��� �� ���ϵ�ī�忡 ���� ���� ǥ��
		Number num = box2.getNum();						// #2> ����� �� ĳ���� ���� ��� ����
		
		Number num2 = ((Box06<? extends Number> )box2).getNum();	// ������ ������ ���� �̷� ��
	}
	public static void func(Box06<? extends Number> box2){}			// ���� ���� �̷��Ŵϱ�. �� �������� �����ϸ� �ȴ�.
}
