package com.bit.day13;

public class Ex10 {
	public static void func04() {
		System.out.println("func04");
	}
	public static void func01(final int a) {
		// jdk1.7까진 상수형 변수만 허용 (값을 바꿀수 없게 지정해놓음)
		// jdk1.8부터 상수형이 아니어도 사용 가능
		class Local01 {
			int su1 = 1111;
//			static int su2 = 2222;			// 존재할 수 없음
			static final int su3 = 2222;	// 가능
			
			public Local01() {
				System.out.println("new Local class");
			}
			public void func03() {
				System.out.println(a+"local func03");
				func04();
			}
		}
		Local01 lo1 = new Local01();
		System.out.println(lo1.su1);
		lo1.func03();
	}
	public void func02() {
		class Local01 {
			
		}
	}
	public static void main(String[] args) {
		Ex10.func01(1234);
	}
}
