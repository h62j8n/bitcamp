package com.bit.day15;

class Box04<T, V> {
	T num;
	V msg;
	
	public void setNum(T num) {		// 인자를 받아 필드 num의 값으로 반환
		this.num = num;
	}
	public void setMsg(V msg) {		// 인자를 받아 필드 msg의 값으로 반환
		this.msg = msg;
	}
	public T getNum() {				// 필드 num의 값 반환
		return num;
	}
	public V getMsg() {				// 필드 msg의 값 반환
		return msg;
	}
}

public class Ex04 {
	public static void main(String[] args) {
/*
 *		Box04 box = new Box04();				// 제네릭과 노란줄 확인하기
 *		box.setNum(1111);
 *		box.setMsg("환영합니다");
 *		System.out.println(box.getNum());		// warn> Object com.bit.day15.Box04.getNum()
 *		System.out.println(box.getMsg());		//  : 제네릭 캐스팅 없이 사용할 경우 Object
 */
		
		Box04<Integer, String> box = new Box04<Integer, String>();	// 제네릭 T,V의 타입을 지정하여 인스턴스 생성
		box.setNum(1111);
		box.setMsg("환영합니다");
		System.out.println(box.getNum());		// OK> Integer com.bit.day15.Box04.getNum()
		System.out.println(box.getMsg());
	}
}
