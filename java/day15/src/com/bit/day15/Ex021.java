package com.bit.day15;
// 다형성 전, 오브젝트 상태에서 제네릭으로 변경
// Ball, BaseBall, Bowling 클래스 이전 페이지에.

class Box1<T> {
	T ball;
	
	public void set(T ball) {
		this.ball = ball;
	}
	public T get() {
		return this.ball;
	}
}

public class Ex021 {
	public static void main(String[] args) {
		BaseBall ball1 = new BaseBall();
		Bowling ball3 = new Bowling();
		
		Box1<BaseBall> box = new Box1<BaseBall>();		// #a. 야구공 담기
//		box.set(ball3);									// #a1> Err. 볼링공은 넣을 수 없음
		box.set(ball1);
		
		BaseBall ball2 = box.get();						// #a2> 야구공 꺼내기 (제네릭으로 인해 야구공만 담을 수 있으므로 형변환 생략 가능) 
		ball2.play();
		
// 이 다음에 모든 공을 담을 수 있게 또 변경됨.
	}
}
