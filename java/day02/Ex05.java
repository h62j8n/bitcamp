class Ex05 {
	public static void main(String[] args) {
		int a; // ���� ����
		a = 3; // ���� �ʱ�ȭ
		System.out.println(a);

		a = 'a'; // ������ ����ȯ
		a = (int)3.14; // ����� ����ȯ (3.14�� intŸ������ ����ȯ(=3) �� a�� ����
		System.out.println(a);

		int b = 123; // ���� ����� �ʱ�ȭ
		int c = a+b;
		System.out.println(c);
	}
}