class Ex06 {
	public static void main(String[] args) {
		// 10���� ������ ����
		byte a;
		short b;
		int c;
		long d;

		a = 127;
		b = 32767;
		c = 2147483647;
		d = 922372036854775807L;

		// a = a+1;
		// error: incompatible types: possible lossy conversion from int to byte
		// (byte)a + (int)1 ����� ����ȯ �ʿ�
		a++;
		// -128 >  �����÷ο�� ���� ������ �ս�

		// d = 922372036854775807;
		// error: integer number too large: 922372036854775807
		// ���ͷ� ���� ���� �⺻�� int ������ �ʰ�. ���ͷ��� ���̻� L�� �ٿ� ���ͷ� Ÿ���� �����Ѵ�.

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}