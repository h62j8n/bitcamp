package ch06;

public class Ex14 {
	public static void main(String[] args) {
		String a = "멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참조할 수 있다.";
		String b = "지역변수는 사용하기 전에 반드시 초기화해야 한다.";
		String c = "초기화 블럭보다 생성자가 먼저 수행된다.";
		String d = "명시적 초기화를 제일 우선적으로 고려해야 한다.";
		String e = "클래스변수보다 인스턴스변수가 먼저 초기화된다.";
		
		System.out.println("다음 중 초기화에 대한 설명으로 옳지 않은 것을 모두 고르시오.\n");
		System.out.println("a. "+a+"\n > 각 타입의 기본 값으로 자동 초기화된다.");
		System.out.println("b. "+b+"\n > 지역변수는 자동 초기화되지 않기 때문에 명시적 초기화해야 사용할 수 있다.");
		System.out.println("c. "+c+"\n > X :");
		System.out.print("   - 인스턴스 초기화블럭 : 객체가 생성될 때마다 모든 생성자의 공통 초기화 코드가 작성된 초기화 블럭이 수행된 후 생성자가 수행된다.\n");
		System.out.print("   - 클래스 초기화블럭 : 프로그램 실행 초기 시점에 수행된다.\n");
		System.out.println("d. "+d);
		System.out.println("e. "+e+"\n > X : 클래스변수는 프로그램 실행 초기 시점에, 인스턴스변수는 인스턴스의 생성 시점에 초기화된다.");
	}
}
