class Ex03 {
  public static void main(String[] args) {
	func1();				// #1. func1() ȣ��

	Ex03 a = new Ex03();	// Ŭ������������ �ν��Ͻ��޼ҵ带 ȣ���ϱ� ���� ��ü ����
	a.func3();				// #2. a.func3() ȣ��
	a.func4();				// #3. a.func4() ȣ��
  }

  public static void func1() {
	func2();				// 1-1 func2() ȣ��
	System.out.println("func1()");		// 1-5> "func1()" ���
  }

  public static void func2() {
	Ex03 b = new Ex03();	// Ŭ�����޼ҵ� ������ �ν��Ͻ��޼ҵ带 ȣ���ϱ� ���� ��ü ����
	b.func4();				// 1-2 b.func4() ȣ��

	System.out.println("func2()");		// 1-4> "func2()" ���
  }

  public void func3() {
	func4();		// �ν��Ͻ��޼ҵ� ������ ��ü ���� ���� ȣ��
						// 2-1 func4() ȣ��
	System.out.println("func3()");		// 2-3> "func3()" ���
  }

  public void func4() {
	System.out.println("func4()");		// 1-3> "func4()" ���
						// 2-2> "func4()" ���
						// 3-1> "func4()" ���
  }
}