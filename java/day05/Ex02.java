class Ex02 {

public static void main(String[] args) {
	System.out.println("메인 로딩");
	int a, b, c;
	a = 3;
	b = 2;
	c = plus(a, b);

	System.out.println(a+"+"+b+"="+c);
	System.out.println("메인 언로딩");
}

public static int plus(int a, int b){
	int c;
	c = a+b;
	return c;
}

}