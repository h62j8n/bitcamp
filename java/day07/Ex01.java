class Ex01 {
  public static void main(String[] args) {
	func1();			// ������ �޼ҵ� ȣ�� �� Ŭ������ ����
	Ex01B.func1();			// �ٸ� Ŭ������ �ִ� �޼ҵ� ȣ�� �� Ŭ������ �ʿ�

	Ex01B b = new Ex01B();		// Ex01B Ŭ����Ÿ���� ��ü ����
	b.func2();			// Ex01B�� �ν��Ͻ��޼ҵ� func2() ȣ��
	// b.func1();			// ����. ���������� ���� static �޼ҵ带 ȣ���� ��� ���� �� non-static�޼ҵ�� ȥ���� ������ �ִ�.
  }

  // Ŭ���ĸ޼ҵ� (static �޼ҵ�)
  public static void func1() {
	System.out.println("Ex01 static func1");
  }
  // �ν��Ͻ��޼ҵ� (non-static �޼ҵ�)
  public void func2() {
	System.out.println("Ex01 non-static func2");
  }
}

class Ex01B {
  public static void main(String[] args) {
	System.out.println("Ex01B main");
  }
  public static void func1() {
	System.out.println("Ex01B static func1");
  }
  public void func2() {
	System.out.println("Ex01B non-static func2");
  }
}