class Ex03 {
  static int num1 = 1234;
  int num2 = 4321;

  public static void main(String[] args) {
	Ex03 a = new Ex03();

	a.func1();

	System.out.println("num1 = "+num1);
	System.out.println("num2 = "+a.num2);
  }

  public static void func1() {
	System.out.println(num1);

	Ex03 a = new Ex03();

	num1++;
	a.num2++;
	System.out.println(a.num2);
  }

  public void func2() {
	num1++;
	num2++;
  }
}