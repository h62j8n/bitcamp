package com.bit.day21;

//class Ex041 extends Thread {						// #1. �ܺ�Ŭ����
//	public void run() {
//		for (int i=0; i<100; i++) {
//			System.out.println("thread"+i);
//		}
//	}
//}
//public class Ex04 {
//	public static void main(String[] args) {
//		Ex041 me = new Ex041();
//		Ex041 you = new Ex041();
//		
//		me.start();
//		you.start();
//	}
//}

//public class Ex04 {
//	static class Ex041 extends Thread {				// #2. ����Ŭ����
//		public void run() {
//			for (int i=0; i<100; i++) {
//				System.out.println("thread"+i);
//			}
//		}
//	}
//	public static void main(String[] args) {
//		Ex041 me = new Ex041();
//		Ex041 you = new Ex041();
//		
//		me.start();
//		you.start();
//	}
//}

//public class Ex04 {
//	public static void main(String[] args) {
//		class Ex041 extends Thread {				// #3. ���θ޼ҵ� ������ ����Ŭ����
//			public void run() {
//				for (int i=0; i<100; i++) {
//					System.out.println("thread"+i);
//				}
//			}
//		}
//		Ex041 me = new Ex041();
//		Ex041 you = new Ex041();
//		
//		me.start();
//		you.start();
//	}
//}

public class Ex04 {
	public static void main(String[] args) {
		Thread me = new Thread() {					// #4. �͸�Ŭ����
			public void run() {
				for (int i=0; i<100; i++) {
					System.out.println("me thread"+i);
				}
			}
		};
		Thread you = new Thread() {
			public void run() {
				for (int i=0; i<100; i++) {
					System.out.println("you thread"+i);
				}
			}
		};
		
		me.start();
		you.start();
	}
}
