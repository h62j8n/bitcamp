package com.bit.day22;

public class Ex01 extends Thread {
	public static void main(String[] args) {
		System.out.println("메인 시작");
		Ex01 me = new Ex01();
		
		me.setDaemon(true);				// 메인이 종료될 때 함께 종료됨
		me.start();
		
		try {							// 메인스레드에 sleep
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인 종료");
	}
	public void run() {
		while (true) {
			System.out.println("스레드 활동 중");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
