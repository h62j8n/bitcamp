class Ex02 {

  /* 클래스 변수 (전역 변수) */
  static int num1 = 1000;
  static int num4; // 초기화하지 않을 경우 각 자료형에 따른 기본 값.

  /* 인스턴스 변수 (non-static 변수), 필드 */
  int num2 = 2000;
  int num3 = 4321;
  String msg = null;

  public static void main(String[] args) {

	// 클래스 변수에 접근하기
	System.out.println("num1 = "+num1);
	func1();

	// 인스턴스 변수에 접근하기
	Ex02 a = new Ex02(); // 인스턴스 생성
	System.out.println("a.num3 = "+a.num3);

	Ex02 b = new Ex02();
	System.out.println("num4 = "+num4);
  }
  public static void func1() {
	int num3 = 1234;
	System.out.println("f1-num1 = "+num1);
	System.out.println("f1-num3 = "+num3);

	Ex02 b = new Ex02();
	System.out.println("f1-b.num3 = "+b.num3);
  }
}