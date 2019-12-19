package com.bit;
class Ex02 {

  // 생성자 오버로딩과 생성자 간의 호출
  public Ex02() {
	System.out.println("인자0 생성자 호출 "+this);
	this.func();
  }
  public Ex02(int a) {
	this(); // 인자1 생성자가 인자0 생성자를 호출. 반드시 생성자 내 최상단에 써야 함.
	System.out.println("인자1 생성자 호출 "+this);
	// 두 생성자에서 출력한 this의 주소값이 같으므로 객체가 동일함을 알 수 있다
//	this(); // Err.
  }

  public static void main(String[] args) {
	new Ex02(100); // 참조변수 선언 없이 인스턴스 생성하고 '인자1 생성자'를 호출함
  }

  public void func() {
	System.out.println("func()");
  }
}