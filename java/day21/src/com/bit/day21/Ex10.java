package com.bit.day21;

public class Ex10 extends Thread {
	public static void main(String[] args) {
		
		System.out.println("main start");
		
		Ex10 me = new Ex10();
		me.start();
		try {
			me.join(3000);						// me의 스레드에 3초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main end");			// 프로그램 실행 후 3초 뒤에 종료된다.
	}
	public void run() {
		String name = getName();
		System.out.println(name+"시작");
		
		System.out.print("[ ");
		for (int i=0; i<10; i++) {
			System.out.print(name+i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("]");
		
		System.out.println(name+"종료");
	}
}
