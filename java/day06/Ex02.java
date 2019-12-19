class Ex02 {
  public static void main(String[] args) {
	func1();
	Ex02 a = new Ex02();
	a.func2();
  }

  public static void func1() {
	System.out.println("static method 기능수행");
	return;
  }

  public int func2() {
	System.out.println("non-static method 기능수행");
	return 100;
  }
}