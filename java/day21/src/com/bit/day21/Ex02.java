package com.bit.day21;

public class Ex02 extends Thread {
	public static void main(String[] args) {
		Ex02 thr1 = new Ex02();
//		thr1.run();									// .run() : 단순하게 run() 메소드를 호출
		thr1.start();								// .start() : 메인 메소드를 수행하는 동안 run() 메소드를 동시에 진행시킴 
		
		for (int i=0; i<500; i++) {					// 1의 수행이 끝나야만
			System.out.println("실행1");
		}
//		for (int i=0; i<500; i++) {					// 2를 수행할 수 있다.
//				System.out.println("실행2");
//		}
		
		System.out.println("메인 종료");
	}
	public void run() {
		for (int i=0; i<500; i++) {					// 2의 수행을 토스한다.
			System.out.println("실행2");
		}
		System.out.println("쓰레드 종료");
	}
}
