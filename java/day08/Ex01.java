package com.bit;

class Ex01 {
	  static int b = 1234;
	  int a = 100;

	  public static void main(String[] args) {
		  Ex01 my = new Ex01();
		my.plus(20);
		System.out.println("a = "+my.a);
		// 1-3. plus()메소드의 매개변수 및 연산과 무관하게 멤버변수 a값 100 출력
		// 3-3. 멤버변수a+=지역변수a 연산 값 120 출력

		my.plus(20, my);
		System.out.println("a = "+my.a);
		// 3-6. 멤버변수a+=지역변수a(3-3)과 같은 결과 출력

		System.out.println("b = "+b); 			// = 2-2. com.bit.Ex01.b의 생략
	  }

	  public void plus() {
		a++; // 3-1. this.a++;의 생략
	  }
	  public void plus(int a) { 				// 1-1. 지역변수와 전역변수 이름이 동일할 경우
//		a+=a; // 1-2. 멤버변수 a값 100이 아닌, 매개변수로 받은 지역변수 연산 (20+20)
		this.a+=a; // 3-2. 멤버변수a+=지역변수a (100+=20)

		b++;
	  }
	  public void plus(int a, Ex01 my) {
		my.a+=a;								// 3-4. this.a+=a(3-2)와 같은 연산
//		System.out.println(this == my);			// 3-5. this가 my(자기자신 객체)인지 증명
	  }
}