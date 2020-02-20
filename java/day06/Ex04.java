class Ex04 {
  public static void main(String[] args) {

	int a, b, c, result;
	result = 0;
	char ch = '?';

	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("첫번째 수:\n>");
	a = sc.nextInt();
	System.out.print("두번째 수:\n>");
	b = sc.nextInt();
	System.out.print("1: 더하기 2:빼기 3: 곱하기 4: 나누기\n>");
	c = sc.nextInt();

	Ex04 abc = new Ex04();

	switch (c) {
		case 1:
			result = abc.plus(a, b);
			ch = '+';
			break;
		case 2:
			result = abc.minus(a, b);
			ch = '-';
			break;
		case 3:
			result = abc.multi(a, b);
			ch = 'x';
			break;
	}
	System.out.println(""+a+ch+b+"="+result);
  }
  public int plus(int a, int b) {
	return a+b;
  }
  public int minus(int a, int b) {
	return a-b;
  }
  public int multi(int a, int b) {
	return a*b;
  }
  public void div(int a, int b) {
	return a/b;
  }
}