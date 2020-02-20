class Ex03 {
  public static void main(String[] args) {
	func1();				// #1. func1() 호출

	Ex03 a = new Ex03();	// 클래스영역에서 인스턴스메소드를 호출하기 위해 객체 생성
	a.func3();				// #2. a.func3() 호출
	a.func4();				// #3. a.func4() 호출
  }

  public static void func1() {
	func2();				// 1-1 func2() 호출
	System.out.println("func1()");		// 1-5> "func1()" 출력
  }

  public static void func2() {
	Ex03 b = new Ex03();	// 클래스메소드 내에서 인스턴스메소드를 호출하기 위해 객체 생성
	b.func4();				// 1-2 b.func4() 호출

	System.out.println("func2()");		// 1-4> "func2()" 출력
  }

  public void func3() {
	func4();		// 인스턴스메소드 간에는 객체 생성 없이 호출
						// 2-1 func4() 호출
	System.out.println("func3()");		// 2-3> "func3()" 출력
  }

  public void func4() {
	System.out.println("func4()");		// 1-3> "func4()" 출력
						// 2-2> "func4()" 출력
						// 3-1> "func4()" 출력
  }
}