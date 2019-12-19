package ch06;

public class Ex11 {
	public static void main(String[] args) {
		String a = "객체 자신을 가리키는 참조변수이다.";
		String b = "클래스 내에서라면 어디서든 사용할 수 있다.";
		String c = "지역변수와 인스턴스 변수를 구별할 때 사용한다.";
		String d = "클래스 메소드 내에서는 사용할 수 없다.";
		
		System.out.println("Q. 다음 중 this에 대한 설명으로 맞지 않은 것을 모두 고르시오.\n");
		System.out.println("a. "+a);
		System.out.println("b. "+b+"\n > X : 인스턴스 메소드 내에서만 사용할 수 있다.");
		System.out.println("c. "+c);
		System.out.println("d. "+d);
	}
}
