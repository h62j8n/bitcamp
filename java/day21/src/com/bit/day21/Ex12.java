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
			me.join();										// #2 join()�޼ҵ�� ���θ޼ҵ� ���� ������ ����
			you.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum1+sum2 = "+Ex12.sum);		// #3 me�� you�� �����尡 ���� �� �����
	}
	public void run() {
		for (int i=first; i<=second; i++) {
			sum+=i;
			try {
				Thread.sleep(1);							// #1 �� �����尡 �յ��ϰ� ����� �� �ֵ��� ���� ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
