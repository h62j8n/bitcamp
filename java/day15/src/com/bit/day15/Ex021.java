package com.bit.day15;
// ������ ��, ������Ʈ ���¿��� ���׸����� ����
// Ball, BaseBall, Bowling Ŭ���� ���� ��������.

class Box1<T> {
	T ball;
	
	public void set(T ball) {
		this.ball = ball;
	}
	public T get() {
		return this.ball;
	}
}

public class Ex021 {
	public static void main(String[] args) {
		BaseBall ball1 = new BaseBall();
		Bowling ball3 = new Bowling();
		
		Box1<BaseBall> box = new Box1<BaseBall>();		// #a. �߱��� ���
//		box.set(ball3);									// #a1> Err. �������� ���� �� ����
		box.set(ball1);
		
		BaseBall ball2 = box.get();						// #a2> �߱��� ������ (���׸����� ���� �߱����� ���� �� �����Ƿ� ����ȯ ���� ����) 
		ball2.play();
		
// �� ������ ��� ���� ���� �� �ְ� �� �����.
	}
}
