package com.bit.day15;

class Ball {						// BallŬ����
	String color = "������";			// �ʵ�
	
	public void play() {				// �޼ҵ�
		System.out.print("������.");
	}
	public void func1() {}
	public void func2() {}
}

class BaseBall extends Ball {		// BaseBallŬ���� (BallŬ���� ���)
	String color = "���";				// �ʵ�
	
	public void play() {				// �޼ҵ� �������̵� (.play()�޼ҵ��� ��� ����)
		System.out.println("������.");
	}
}

class Bowling extends Ball {
	public void play() {				// �޼ҵ� �������̵� (.play()�޼ҵ��� ��� ����)
		System.out.print("���� ����");
		super.play();
	}
}

class Box {/*
//	BaseBall ball;					// #a1 BaseBall �ʵ� ����
//	Object ball;					// > #a3 ��� ���� ���� �� �ִ� �ʵ� ����
	Ball ball;						// >> #a5 ������ (�θ�Ŭ������ Ŭ������ü ����)
	
	public void set(BaseBall ball) {	// ���� ��� �޼ҵ�
		this.ball = ball;
	}
	public BaseBall get() {				// ���� ������ �޼ҵ�
		return this.ball;
	}
*/}

public class Ex02 {/*
	public static void main(String[] args) {
		BaseBall ball1 = new BaseBall();	// #1 �߱��� ��ü ����
		Bowling ball3 = new Bowling();		// #5 ������ ��ü ����
		
		Box box = new Box();				// #2 �ڽ� ��ü ����
		
		box.set(ball1);						// #3 �߱��� ��ü�� Box Ŭ������ ����
		
//		BaseBall ball2 = box.get();				// #a2 Box Ŭ�������� �߱��� ��ü�� ������ ���. > �������� ������ �� ���� ����
//		BaseBall ball2 = (BaseBall)box.get();	// > #a4 Box�� ������Ʈ �ʵ带 �������� ���� ����ȯ�� �ʼ���.
		Ball ball2 = box.get();					// > #a6 �θ�Ŭ���� Ÿ���� ��ü�� �����ϰ� ���
		ball2.play();
		
	}
*/}
