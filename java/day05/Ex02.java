class Ex02 {

public static void main(String[] args) {
	System.out.println("���� �ε�");
	int a, b, c;
	a = 3;
	b = 2;
	c = plus(a, b);

	System.out.println(a+"+"+b+"="+c);
	System.out.println("���� ��ε�");
}

public static int plus(int a, int b){
	int c;
	c = a+b;
	return c;
}

}