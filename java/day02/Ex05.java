class Ex05 {
	public static void main(String[] args) {
		int a; // 변수 선언
		a = 3; // 변수 초기화
		System.out.println(a);

		a = 'a'; // 묵시적 형변환
		a = (int)3.14; // 명시적 형변환 (3.14를 int타입으로 형변환(=3) 후 a에 대입
		System.out.println(a);

		int b = 123; // 변수 선언과 초기화
		int c = a+b;
		System.out.println(c);
	}
}