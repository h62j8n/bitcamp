package com.bit.day20;

//class Car {										// #5 Exception : java.io.NotSerializableException
public class Car implements java.io.Serializable {			// ���к��ϰ� ��ü�� ��� ������ ���� ����
	long serialVersionUID = 123456L;// !! day20 Car.java�� ����Ҽ���
	// �ۼ����� ������ �ڵ����� �ۼ��ȴ�. ( > �����ɶ����� ������ �ٲ�)
	// ������ ��ġ�ؾ� ������ �� �ִ�.
	// �ʵ尪���� ����� (�޼ҵ�� ���� ���)
	public int speed;
	transient public String color;								// transient : �� �ʵ带 io�� ���� �������� ���ϰ� ���ܽ�Ŵ
	public Car() {
		speed = 100;
		color = "Black";
	}
	public void func() {
		System.out.println("�޸���");
	}
	public void func2() {
		System.out.println("test");
	}
}