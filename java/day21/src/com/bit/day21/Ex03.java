package com.bit.day21;

public class Ex03 implements Runnable {				// #1-1. Runnable�� �����Ͽ� ������ ����
	public static void main(String[] args) {
		
		Ex03 me = new Ex03();
		
		Thread thr1 = new Thread(me);				// #1-3. Runnable�� �����ϴ� Ex03(run�޼ҵ尡 �����Ǿ��ִ�)�� ��ü me�� ���� ������ ����
		Thread thr2 = new Thread(new Runnable(){
			public void run() {						// #2. Runnable�� �����ϴ� �͸�Ŭ������ ����Ͽ� ������ ����
				for (int i=0; i<100; i++) {
					System.out.println("you thread"+i);
				}
			}
		});
		
		thr1.start();
		thr2.start();
	}

	public void run() {								// #1-2. Runnable �������̽��� �����ϱ� ���� �ʼ� �������̵�
		for (int i=0; i<100; i++) {
			System.out.println("me thread"+i);
		}
	}
}
