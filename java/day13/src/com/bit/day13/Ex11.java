package com.bit.day13;

interface Inter {
	public void func01();
}
interface Inter02 {
	public void func02();
}
abstract class Cl11 {
	void func04() {}
	abstract void func05();
}
public class Ex11 {
	String msg2 = new String("���ϸӽ�");	// ���ϸӽ� Ŭ������ �ͼ��� Ŭ���� ��ü�� ������ ����
	Object obj3 = new Object() {			// �ʵ�� ����ϴ� ���ϸӽ� Ŭ����
		public String toString() {
			return "���ϸӽ�";
		}
	};										// public, static, final ��� ����� �� �ִ�
	
	public static Inter func() {				// ����Ÿ�� Object > ���Ἥ Inter�� �ٲ�(������)
		class Local11 implements Inter {		// func01()�� ������ �������̽� ����
			public void func01() {
				System.out.println("Local func01");
			}
		} // Local11 end
		
//		Local11 me = new Local11();		// 1�Ϲ��� ����Ŭ���� ��ü����
//		me.func01();
//		new Local11()).func01();		// 2����
		
		
		
//		return new Local11();							// 1. func() : Local11 ��ü�� �����Ͽ� ����
/*		return new class Local11 implements Inter() {	// 2. 1�� Ǯ� ����. (����)
 *			public void func01() {
 *				System.out.println("Local func01");
 *			}
 *		};
 */

/*
 *		return new Inter() {							// 3. 2�� ���� (����� ����)
 *			public void func01() {
 *				System.out.println("Local func01");
 *			}
 *		};
 */

		Inter local = new Inter() {						// 4. 3�� ���� ���� (anonymous class)
			public void func01() {						// �������̽��� ��ӹ޴� Ŭ������ ����
				System.out.println("Local func01");		// �������̽��� �����Ǿ����� ���� �κ��� �����ϰ�
			}											// ��ü�� �����Ѵ�.
		};
		return local;
		
		
		
	} // func end
	
	public static void main(String[] args) {
//		func();
//		Object obj = func();					// ObjectŬ������ func()�� ��� ����
		Inter obj = func();						// Object(����Ŭ���� ���)�� ��������, �������̽� ���
		obj.func01();
		
		Inter02 ele2 = new Inter02() {
			public void func02() {}
			public void func03() {}
		};
		
		Cl11 cl = new Cl11() {
			void func05() {}
		};
		Object obj2 = new Object() {			// ���ú���
			public String toString() {
				return "���ϸӽ�";
			}
		};
		System.out.println(obj2);
	}
}
