class Ex06 {
	public static void main(String[] args) {
		// 10진수 정수형 변수
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
		// (byte)a + (int)1 명시적 형변환 필요
		a++;
		// -128 >  오버플로우로 인한 데이터 손실

		// d = 922372036854775807;
		// error: integer number too large: 922372036854775807
		// 리터럴 값이 정수 기본형 int 범위를 초과. 리터럴에 접미사 L을 붙여 리터럴 타입을 지정한다.

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}