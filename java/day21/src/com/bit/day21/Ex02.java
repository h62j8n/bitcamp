package com.bit.day21;

public class Ex02 extends Thread {
	public static void main(String[] args) {
		Ex02 thr1 = new Ex02();
//		thr1.run();									// .run() : �ܼ��ϰ� run() �޼ҵ带 ȣ��
		thr1.start();								// .start() : ���� �޼ҵ带 �����ϴ� ���� run() �޼ҵ带 ���ÿ� �����Ŵ 
		
		for (int i=0; i<500; i++) {					// 1�� ������ �����߸�
			System.out.println("����1");
		}
//		for (int i=0; i<500; i++) {					// 2�� ������ �� �ִ�.
//				System.out.println("����2");
//		}
		
		System.out.println("���� ����");
	}
	public void run() {
		for (int i=0; i<500; i++) {					// 2�� ������ �佺�Ѵ�.
			System.out.println("����2");
		}
		System.out.println("������ ����");
	}
}
