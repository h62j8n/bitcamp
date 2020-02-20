class Ex06 {
  public static void main(String[] args) {

	int a, b, c;

	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("첫번째 수:\n>");
	a = sc.nextInt();
	System.out.print("두번째 수:\n>");
	b = sc.nextInt();
	System.out.print("1: 더하기 2:빼기 3: 곱하기 4: 나누기\n>");
	c = sc.nextInt();

	if (c == 1) {
		myPrint1(a, '+', b, plus(a, b));
	} else if (c == 2) {
		myPrint1(a, '-', b, minus(a, b));
	} else if (c == 3) {
		myPrint1(a, '-', b, multi(a, b));
	} else if (c == 4) {
		if (a%b == 0) {
			myPrint1(a, '/', b, div1(a, b));
		} else {
			myPrint2(a, '/', b, div2(a, b));
		}
	}
  }
  public static void myPrint1(int a, char ch, int b, int c) {
	System.out.println(a+""+ch+b+"="+c);
  }
  public static void myPrint2(int a, char ch, int b, double c) {
	System.out.println(a+""+ch+b+"="+c);
  }
  public static int plus(int a, int b) {
	return a+b;
  }
  public static int minus(int a, int b) {
	return a-b;
  }
  public static int multi(int a, int b) {
	return a*b;
  }
  public static int div1(int a, int b) {
	return a/b;
  }
  public static double div2(int a, int b) {
	return a*1.0/b;
  }
}