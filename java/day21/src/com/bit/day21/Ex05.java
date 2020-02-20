package com.bit.day21;

public class Ex05 extends Thread {
	public Ex05(String name) {					// 생성자를 통해 스레드의 이름을 지정할 수도 있다
//		super("스레드");
		super(name);
	}
	public static void main(String[] args) {
		
//		Ex05 ex = new Ex05();					// Thread클래스의 명령어를 쓰는 순간, 이것은 start()가 없는 스레드가 되어버린다.
//		String name = ex.getName();
		
		Thread mainThr = Thread.currentThread();
		String name = mainThr.getName();
		System.out.println(name+" 시작");
		
		Ex05 me = new Ex05("me");
//		me.setName("me");
		Ex05 you = new Ex05("you");
//		you.setName("you");
		
		me.start();
		you.start();
		
		System.out.println(name+" 종료");
	}
	public void run() {
		String name = getName();
		System.out.println(name+"쓰레드 시작");
		
		System.out.print("[ ");
		for (int i=0; i<5; i++) {
			System.out.print(name+i+" ");
		}
		System.out.println("]");
		System.out.println(name+"쓰레드 종료");
	}
}
