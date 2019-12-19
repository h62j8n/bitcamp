package com.bit;

class Ex07 {
	int num;
	String str;

	public static void main(String[] args) {
		final int c;
		c = 1111;
//		c++;			Err : 상수의 값을 바꿀 수 없다.

		java.util.Scanner sc = new java.util.Scanner(System.in);; // java.util패키지의 Scanner클래스(생성자 System.in)

		Ex07 a = new Ex07(2222); // 생성자 호출 (인스턴스 생성)
		System.out.println("a.num : "+a.num);
		// 0 : 인자는 생성자1의 지역변수 num의 값으로 저장됨
		
		Ex07 b = new Ex07("b");
		System.out.println("b.str : "+b.str);
		// b : 인자와 생성자를 통해 인스턴스 b의 str값이 저장됨
		
		b.func(4321);
		System.out.println(a.num);
		// 0 : 필드 num의 기본값 0이 저장되어 있다.
		System.out.println(b.num);
		// 4321 : 인자와 .func() 메소드를 통해 인스턴스 b의 필드 num 값을 저장함
	}

	public Ex07(int n) {		// 생성자1 (필드값 초기화)
		int num = n;
		System.out.println("생성자의 지역변수 num : "+num);
	}
	public Ex07(String s) {		// 생성자2. 리턴값이 없으나 반환타입 작성 생략
		str = s;
	}
	public void func(int n) {	// 메소드. 리턴값이 없으므로 반환타입을 기재
		num = n;
	}
}