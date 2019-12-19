package com.bit.day21;

public class Ex06 implements Runnable {
	public static void main(String[] args) {
		Ex06 work = new Ex06();
		
		Thread thr1 = new Thread(work);				// 나라는 객체를 통해 쓰레드 수행
		Thread thr2 = new Thread(work, "두번째");	// 생성자를 통해 이름을 부여하는 2번째 방법
		
		thr1.start();
		thr2.start();
	}

	public void run() {
		Thread thr = Thread.currentThread();
		String name = thr.getName();
		System.out.println(name+"쓰레드 시작");
		System.out.print("[ ");
		for (int i=0; i<5; i++) {
			System.out.print(name+i+" ");
		}
		System.out.println("]");
		System.out.println(name+"쓰레드 종료");
	}
}
