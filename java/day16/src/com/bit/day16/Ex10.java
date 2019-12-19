package com.bit.day16;

public class Ex10 {
	protected Object clone() throws CloneNotSupportedException {		// 4. clone()메소드 오버라이드
//		return this;														// me와 같은 객체
		return new Ex10();												// 5. me와는 다른 새로운 객체를 생성하여 clone() 실행
	}
	public static void main(String[] args) {
		Object obj = new Object();
		
//		obj.clone();							// 1. 접근제한 protected에 의해 사용할 수 없음
		Ex10 me = new Ex10();					// 2. 내가 만든 클래스는 Object를 상속하므로 clone() 사용 가능
		try {
			Object you = me.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();				// 3. 그런데 오류가 난다.
		}
		
	}
}
