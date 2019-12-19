package com.bit.day21;

public class Ex14 implements Runnable {
	String name;
	public Ex14(String name) {
		this.name = name;			// extends Thread �� �ƴϱ� ������ super()�� �ƴϴ�. 
	}
	public static void main(String[] args) {
		
		ThreadGroup tg = new ThreadGroup("��");
		
		Ex14 me = new Ex14("ù��°");
		Ex14 you = new Ex14("�ι�°");
		
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
		System.out.println(name+"������ ����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"������ ����");
	}
}
