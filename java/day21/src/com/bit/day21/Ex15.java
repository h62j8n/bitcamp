package com.bit.day21;

public class Ex15 extends Thread {
	public static void main(String[] args) {
		Ex15 me = new Ex15();
		
//		me.start();
		try {
			Thread.sleep(1000);
//			me.suspend();
			Thread.sleep(1000);
//			me.resume();
			Thread.sleep(1000);
			me.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public void run() {
		while (true) {
			System.out.println("½ÇÇà");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
