class Ex01 {
  public static void main(String[] args) {
	func1();			// 내부의 메소드 호출 시 클래스명 생략
	Ex01B.func1();			// 다른 클래스에 있는 메소드 호출 시 클래스명 필요

	Ex01B b = new Ex01B();		// Ex01B 클래스타입의 객체 생성
	b.func2();			// Ex01B의 인스턴스메소드 func2() 호출
	// b.func1();			// 지양. 참조변수를 통해 static 메소드를 호출할 경우 문법 상 non-static메소드로 혼동할 여지가 있다.
  }

  // 클래식메소드 (static 메소드)
  public static void func1() {
	System.out.println("Ex01 static func1");
  }
  // 인스턴스메소드 (non-static 메소드)
  public void func2() {
	System.out.println("Ex01 non-static func2");
  }
}

class Ex01B {
  public static void main(String[] args) {
	System.out.println("Ex01B main");
  }
  public static void func1() {
	System.out.println("Ex01B static func1");
  }
  public void func2() {
	System.out.println("Ex01B non-static func2");
  }
}