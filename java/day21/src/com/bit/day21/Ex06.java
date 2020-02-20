package com.bit.day21;

public class Ex06 implements Runnable {
	public static void main(String[] args) {
		Ex06 work = new Ex06();
		
		Thread thr1 = new Thread(work);				// ����� ��ü�� ���� ������ ����
		Thread thr2 = new Thread(work, "�ι�°");	// �����ڸ� ���� �̸��� �ο��ϴ� 2��° ���
		
		thr1.start();
		thr2.start();
	}

	public void run() {
		Thread thr = Thread.currentThread();
		String name = thr.getName();
		System.out.println(name+"������ ����");
		System.out.print("[ ");
		for (int i=0; i<5; i++) {
			System.out.print(name+i+" ");
		}
		System.out.println("]");
		System.out.println(name+"������ ����");
	}
}
