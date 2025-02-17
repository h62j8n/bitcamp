package com.bit.day21;

public class Ex14 implements Runnable {
	String name;
	public Ex14(String name) {
		this.name = name;			// extends Thread 가 아니기 때문에 super()가 아니다. 
	}
	public static void main(String[] args) {
		
		ThreadGroup tg = new ThreadGroup("나");
		
		Ex14 me = new Ex14("첫번째");
		Ex14 you = new Ex14("두번째");
		
		Thread thr1 = new Thread(tg, me);
		Thread thr2 = new Thread(tg, you);
		
		thr1.start();
		thr2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		tg.stop();
		tg.interrupt();
		
	}
	public void run() {
		System.out.println(name+"스레드 시작");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"스레드 종료");
	}
}
