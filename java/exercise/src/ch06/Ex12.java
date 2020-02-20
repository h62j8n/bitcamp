package ch06;

public class Ex12 {
	public static void main(String[] args) {
		String a = "메소드의 이름이 같다.";
		String b = "매개변수의 개수 또는 타입이 다르다.";
		String c = "리턴타입이 다르다.";
		String d = "매개변수의 이름이 다르다.";
		
		System.out.println("다음 중 오버로딩이 성립하기 위한 조건이 아닌 것을 모두 고르시오.\n");
		System.out.println("a. "+a);
		System.out.println("b. "+b);
		System.out.println("c. "+c+"\n > X : 호출 시점에서 메소드를 구별할 수 없는 리턴타입은 오버로딩과 무관하다.");
		System.out.println("d. "+d+"\n > X : 매개변수명이 다르더라도 매개변수의 갯수와 타입이 같으면 동일한 메소드(중복)에 불과하다.");
	}
}
