package com.bit.day21;

public class Ex05 extends Thread {
	public Ex05(String name) {					// �����ڸ� ���� �������� �̸��� ������ ���� �ִ�
//		super("������");
		super(name);
	}
	public static void main(String[] args) {
		
//		Ex05 ex = new Ex05();					// ThreadŬ������ ��ɾ ���� ����, �̰��� start()�� ���� �����尡 �Ǿ������.
//		String name = ex.getName();
		
		Thread mainThr = Thread.currentThread();
		String name = mainThr.getName();
		System.out.println(name+" ����");
		
		Ex05 me = new Ex05("me");
//		me.setName("me");
		Ex05 you = new Ex05("you");
//		you.setName("you");
		
		me.start();
		you.start();
		
		System.out.println(name+" ����");
	}
	public void run() {
		String name = getName();
		System.out.println(name+"������ ����");
		
		System.out.print("[ ");
		for (int i=0; i<5; i++) {
			System.out.print(name+i+" ");
		}
		System.out.println("]");
		System.out.println(name+"������ ����");
	}
}
