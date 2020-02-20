package ch06;

public class Ex19 {
	public static void change(String str) {
		str += "456";
		// 매개변수 str의 값. 메인 메소드의 str변수에 영향을 주지 않는다.
		System.out.println("in change() : "+str);
	}

	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		System.out.println("in main : " + str);
	}
}
