class Ex01 { // 클래스

public static void main(String[] args) { // main 메소드
	System.out.println("시작");
	func1(100); // func1 메소드 호출
	System.out.println("끝");
}

public static void func1(int a) { // func1 메소드
	System.out.println("실행"+a);
}

} // class end