package com.bit.day21;

public class Ex03 implements Runnable {				// #1-1. Runnable을 구현하여 쓰레드 수행
	public static void main(String[] args) {
		
		Ex03 me = new Ex03();
		
		Thread thr1 = new Thread(me);				// #1-3. Runnable을 구현하는 Ex03(run메소드가 구현되어있다)의 객체 me에 대해 쓰레드 수행
		Thread thr2 = new Thread(new Runnable(){
			public void run() {						// #2. Runnable을 구현하는 익명클래스를 사용하여 쓰레드 수행
				for (int i=0; i<100; i++) {
					System.out.println("you thread"+i);
				}
			}
		});
		
		thr1.start();
		thr2.start();
	}

	public void run() {								// #1-2. Runnable 인터페이스를 구현하기 위한 필수 오버라이드
		for (int i=0; i<100; i++) {
			System.out.println("me thread"+i);
		}
	}
}
