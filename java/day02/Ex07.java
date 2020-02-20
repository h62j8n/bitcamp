class Ex07 {
	public static void main(String[] args) {
		float a = 3.14f;
		double b = 3.14;

		b = 3.14f;
		// 3.140000104904175 : 타입 불일치. 변수타입 double이 리터럴타입 float보다 큰 범위로서 허용된다.

		System.out.println(a);
		System.out.println(b);
	}
}