package com.bit.day12;

class BitException extends Exception {
	public BitException() {
//		super("0���� ���� �� ����");					// ������ �������̵� �׽�Ʈ�� ���� �ּ��ް� Ȯ��
	}
	public BitException(String msg) {
		super(msg);
	}
}

public class Ex11 {
	public static void main(String[] args) {
//		try {
//			int su = 2/0;
//		} catch (ArithmeticException e) {
//			System.out.println(e);
//			System.out.println(e.toString());
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		try {
			int result = div(4,0);
			System.out.println(result);
		} catch (BitException e) {
			System.out.println("0���� ����");
		}
	}
	
//	public static int div(int a, int b) throws ArithmeticException {	// �Ϲ����� �޼ҵ� ����
//		if (b==0) {
//			ArithmeticException err;
//			err = new ArithmeticException();
//			throw err;													// �� �ȿ��� ���ܻ�Ȳ�� �߻��� ��쿡�� throw
//		}
//		return a/b;
//	}
	public static int div(int a, int b) throws BitException {			// ����� ���� Ŭ������ ���� ó��
		if (b==0) {
			BitException err;
			err = new BitException("����Ŭ���� ������ �������̵�");
			throw err;
		}
		return a/b;
	}
}
