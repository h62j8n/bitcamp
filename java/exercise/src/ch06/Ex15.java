package ch06;

public class Ex15 {
	public static void main(String[] args) {
		String a = "기본값";
		String b = "명시적 초기화";
		String c = "생성자";
		String d = "초기화 블럭";
		
		System.out.println("인스턴스변수의 초기화 순서가 올바른 것은?\n");
		
		String[] answer = new String[4];
		answer[0] = a;
		answer[1] = b;
		answer[2] = d;
		answer[3] = c;
		
		for (int i=0; i<answer.length; i++) {
			if (i != 0) {System.out.print(" > ");}
			System.out.print(answer[i]);
		}
	}
}
