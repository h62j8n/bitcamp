package com.bit.day12;

public interface Inter02 {
	void func01();
}
interface Inter03/* extends Inter02*/ {
	void func02();
}
interface Inter04 extends Inter02, Inter03 {			// �������̽� ���߻��
	void func03();
//	int func02();										// Err. ����Ÿ���� �������̵��� ����
	void func01();										// �׷��� �����ΰ� ���� ������ �������̵��� �ǹ̰� ����.
}