package ch06;

public class Ex18 {
	int iv = 10; 
	static int cv = 20;
	int iv2 = cv;
//	static int cv2 = iv;			// A
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv);		// B
	}
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);		// C
	}
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1();			// D
	}
	void instanceMethod2() {
		staticMethod1();			// E
		instanceMethod1();
	}
	public static void main(String[] args) {
		System.out.println("A, B, D : Ŭ���� ���� �Ǵ� �޼ҵ忡�� �ν��Ͻ� ���� �Ǵ� �޼ҵ带 ����� �� ����.");
	}
}
