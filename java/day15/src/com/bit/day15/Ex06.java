package com.bit.day15;

class Box06<T> {
	T num;
	
	public void setNum(T num) {
		this.num = num;
	}
	public T getNum() {
		return num;
	}
}

public class Ex06 {
	public static void main(String[] args) {
//		Box06<Integer> box = new Box06<>();				// 기본형태의 제네릭 사용

		Box06<? super Number> box1 = new Box06<>();		// #1: <"?" : 제네릭을 정하지 않았지만, "super Number"> : 조상클래스로부터 Number를 상속받은 것은 올 수 있다.
		box1.setNum(1111);
		box1.setNum(3.14);
//		box.setNum("aaa");								// #1>: Err. Number타입에 의해 숫자 값은 자유롭게 입력 가능하나 String타입 값은 안됨

		Number num1 = (Number)box1.getNum();				// #1> 사용할 땐 Number클래스 타입으로 형변환해서 사용
		
		Box06<? extends Number> box2 = new Box06<>();	// #2: ????? super와 반대의 관점 (값을 사용하는 관점)
//		box.setNum(1111);								// #2> Err. 값을 입력할 땐 와일드카드에 의해 에러 표시
		Number num = box2.getNum();						// #2> 사용할 땐 캐스팅 없이 사용 가능
		
		Number num2 = ((Box06<? extends Number> )box2).getNum();	// 억지긴 하지만 뫄뫄 이런 뜻
	}
	public static void func(Box06<? extends Number> box2){}			// 위의 뫄뫄 이런거니까. 이 관점에서 생각하면 된다.
}
