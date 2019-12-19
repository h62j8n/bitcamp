package ch06;

public class Ex08 {
	int kind;
	int num;
	
	static int width;
	static int height;
	
	Ex08(int k, int n) {
		this.kind = k;
		this.num = n;
	}
	
	public static void main(String[] args) {
		Ex08 card = new Ex08(1, 1);
		
		System.out.println("클래스변수 : width, height");
		System.out.println("인스턴스변수 : kind, num");
		System.out.println("지역변수 : k, n");
	}
}
