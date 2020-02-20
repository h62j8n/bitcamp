package com.bit.day21;

public class Ex122 extends Thread {
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
		Ex122 me = new Ex122();
		me.first = 1;
		me.second = 500;
		
//		501+502+503+...+1000
		Ex122 you = new Ex122();
		you.first = 501;
		you.second = 1000;
		
		me.start();
		you.start();
		
		try {
			me.join();
			you.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum1+sum2 = "+Ex122.sum);
	}
	
	// µ¿±âÈ­
	static Object key = new Object();
	
	public static void plus(int a, int b) {
		for (int i=a; i<=b; i++) {
			synchronized (key) {
				int num = sum+i;
				sum = num;
			}
		}
	}
	
	public void run() {
		for (int i=first; i<=second; i++) {
//			plus(i);
		}
	}
}
