package ch06;

public class Ex16 {
	public static void main(String[] args) {
		String a = "자동 초기화되므로 별도의 초기화가 필요없다.";
		String b = "지역변수가 선언된 메소드가 종료되면 지역변수도 함께 소멸된다.";
		String c = "메소드의 매개변수로 선언된 변수도 지역변수이다.";
		String d = "클래스변수나 인스턴스변수보다 메모리 부담이 적다.";
		String e = "heap영역에 생성되며 가비지 컬렉터에 의해 소멸된다.";

		System.out.println("다음 중 지역변수에 대한 설명으로 옳지 않은 것을 모두 고르시오.\n");
		System.out.println("a. "+a+"\n > X : a지역변수는 자동 초기화되지 않기 때문에 명시적 초기화해야 사용할 수 있다.");
		System.out.println("b. "+b);
		System.out.println("c. "+c);
		System.out.println("d. "+d);
	}
}
