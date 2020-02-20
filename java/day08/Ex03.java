package com.bit;

class Ex03 { // = class Ex03 extends java.lang.Object { 3. 사실은 Object클래스에서 상속받는다는 말이 늘 생략되어 있었다.
  public static void main(String[] args) {

	Ex03 me = new Ex03();
	System.out.println(me);
	System.out.println(me.toString());
	// 2. 참조변수 me를 호출했을 때 불러올 것이 없으니 Object클래스에서 상속받은 toString()을 사용한다.
	// 이에 따라 me.toString() 값(주소의 해시태그값)을 자동으로 불러온다.

	Object obj = new Object();
	System.out.println(obj);
	System.out.println(obj.toString());		// 1. Object클래스에 toString()메소드가 들어있다.
	System.out.println(obj.hashCode());		// toString() 실행 값의 @ 이후의 값을 int형으로 표현한 것
  }
}