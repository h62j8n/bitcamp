package com.bit.day21;

public class Ex12 extends Thread {
	static int sum;
	int first;
	int second;
	public static void main(String[] args) {
//		1+2+3+...+1000
		int sum = 0;
		for (int i=1; i<=1000; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		1+2+3+...+500
		Ex12 me = new Ex12();
		me.first = 1;
		me.second = 500;
		
//		501+502+503+...+1000
		Ex12 you = new Ex12();
		you.first = 501;
		you.second = 1000;
		
		me.start();
		you.start();
		
		try {
			me.join();										// #2 join()메소드로 메인메소드 수행 시점을 제어
			you.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum1+sum2 = "+Ex12.sum);		// #3 me와 you의 쓰레드가 끝난 후 수행됨
	}
	public void run() {
		for (int i=first; i<=second; i++) {
			sum+=i;
			try {
				Thread.sleep(1);							// #1 각 스레드가 균등하게 수행될 수 있도록 텀을 둠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
