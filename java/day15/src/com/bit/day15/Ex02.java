package com.bit.day15;

class Ball {						// Ball클래스
	String color = "검은색";			// 필드
	
	public void play() {				// 메소드
		System.out.print("굴린다.");
	}
	public void func1() {}
	public void func2() {}
}

class BaseBall extends Ball {		// BaseBall클래스 (Ball클래스 상속)
	String color = "흰색";				// 필드
	
	public void play() {				// 메소드 오버라이드 (.play()메소드의 기능 변경)
		System.out.println("던진다.");
	}
}

class Bowling extends Ball {
	public void play() {				// 메소드 오버라이드 (.play()메소드의 기능 변경)
		System.out.print("핀을 향해");
		super.play();
	}
}

class Box {/*
//	BaseBall ball;					// #a1 BaseBall 필드 생성
//	Object ball;					// > #a3 모든 공을 담을 수 있는 필드 생성
	Ball ball;						// >> #a5 다형성 (부모클래스의 클래스객체 생성)
	
	public void set(BaseBall ball) {	// 공을 담는 메소드
		this.ball = ball;
	}
	public BaseBall get() {				// 공을 꺼내는 메소드
		return this.ball;
	}
*/}

public class Ex02 {/*
	public static void main(String[] args) {
		BaseBall ball1 = new BaseBall();	// #1 야구공 객체 생성
		Bowling ball3 = new Bowling();		// #5 볼링공 객체 생성
		
		Box box = new Box();				// #2 박스 객체 생성
		
		box.set(ball1);						// #3 야구공 객체를 Box 클래스에 담음
		
//		BaseBall ball2 = box.get();				// #a2 Box 클래스에서 야구공 객체를 꺼내서 논다. > 볼링공을 가지고 놀 수가 없음
//		BaseBall ball2 = (BaseBall)box.get();	// > #a4 Box에 오브젝트 필드를 담음으로 인해 형변환이 필수됨.
		Ball ball2 = box.get();					// > #a6 부모클래스 타입의 객체로 간편하게 사용
		ball2.play();
		
	}
*/}
