class Ex04 {

public static void main(String[] args) {
	func1(10);
}

public static void func1(int a) {
	a--;
	if (a < 0) {
		System.out.println("func1 run"+a);		
	} else {
		return;
	}
	func1(a);
}

}