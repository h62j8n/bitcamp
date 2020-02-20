package com.bit;

class Ex05p {
  int num = 1234;
  public void func() {
	System.out.println("부모클래스의 기능");
  }
}

class Ex05 extends Ex05p {
  // 오버라이드
  int num = 4321;
  public void func() {
	System.out.println("자식클래스의 기능");

  /* #1 필드는 오버라이드 대상이 아니다 - 증명되지 못한... */
	System.out.println("num = "+num);
	System.out.println("this.num = "+this.num);
	System.out.println("super.num = "+super.num);


  }

  public static void main(String[] args) {
/*	Ex05 me = new Ex05();
	me.func(); // 상속을 통해 부모클래스에 정의된 메소드 func()을 수행할 수 있다.
	System.out.println(me.num);

	this.func();
	super.func();
*/

	final int A = 1234;
	System.out.println("A = "+A);
  }
}