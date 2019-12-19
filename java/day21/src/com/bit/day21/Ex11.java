package com.bit.day21;

public class Ex11 {
	static int num;
	
	public static void main(String[] args) {
		Thread thr1 = new Thread(new Runnable() {
			public void run() {
				String name = "첫번째";
				System.out.println(name+"시작");
				for (int i=0; i<10; i++) {
					while (num == 0) {Thread.yield();};			// num이 0인 동안 스레드 수행순서 양보하고 대기상태
					System.out.println(name+i);
				}
				System.out.println(name+"종료");
			}
		});
		Thread thr2 = new Thread(new Runnable() {
			public void run() {
				String name = "두번째";
				System.out.println(name+"시작");
				for (int i=0; i<10; i++) {
					if (i>5) {num = 1;}						// 5보다 클 때부터 num = 1;
					System.out.println(name+i);
				}
				System.out.println(name+"종료");
			}
		});
		
		thr1.start();
		thr2.start();
	}
}
