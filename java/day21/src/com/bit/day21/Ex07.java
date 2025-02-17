package com.bit.day21;

public class Ex07 implements Runnable {
	public static void main(String[] args) {
		Ex07 me = new Ex07();
		
		Thread thr1 = new Thread(me, "첫번째");
		Thread thr2 = new Thread(me, "두번째");
		Thread thr3 = new Thread(me, "세번째");
		
		thr1.setPriority(Thread.MIN_PRIORITY);
		thr3.setPriority(Thread.MAX_PRIORITY);
		thr1.start();
		thr2.start();
		thr3.start();
	}
	
	public void run() {
		Thread thr = Thread.currentThread();
		String name = thr.getName();
		System.out.println(name+"시작 (우선순위:"+thr.getPriority()+")");
		
		System.out.print("[ ");
		for (int i=0; i<5; i++) {
			System.out.print(name+i+" ");
		}
		System.out.println("]");
		
		System.out.println(name+"종료");
	}
}
