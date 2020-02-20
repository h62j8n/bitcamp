package ch06;

public class Ex10 {
	public static void main(String[] args) {
		String a = "모든 생성자의 이름은 클래스의 이름과 동일해야 한다.";
		String b = "생성자는 객체를 생성하기 위한 것이다.";
		String c = "클래스에는 반드시 하나 이상의 생성자가 있어야 한다.";
		String d = "생성자가 없는 클래스에는 컴파일러가 기본 생성자를 추가한다.";
		String e = "생성자는 오버로딩 할 수 없다.";
		
		System.out.println("Q. 다음 중 생성자에 대한 설명으로 옳지 않은 것을 모두 고르시오.\n");
		System.out.println("a. "+a);
		System.out.println("b. "+b+"\n > X : 객체 생성 시 생성자를 사용해 해당 객체의 필드값을 초기화 할 수 있다.");
		System.out.println("c. "+c);
		System.out.println("d. "+d);
		System.out.println("e. "+e+"\n > X : 생성자 오버로딩과 생성자를 통한 다른 생성자 호출이 가능하다.");
	}
}
