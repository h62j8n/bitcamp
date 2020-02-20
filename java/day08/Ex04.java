package com.bit;
class Ex04 {
  public static void main(String[] args) {

	Ex04Car my = new Ex04Car("모닝");	// 4 Ex04Car(String model) 생성자를 통해 인스턴트 생성
	my.show();
	my.speedUp();
	my.show();
	my.speedDown();
	my.show();

	Ex04Kia my2 = new Ex04Kia();		// 자식클래스의 인스턴스를 생성할 때 부모클래스의 인스턴스도 생성됨
	my2.show();
	my2.speedUp();
	my2.show();
	my2.speedUp();
	my2.show();
	my2.speedDown();
	my2.show();
	my2.speedDown();
	my2.show();
  }
}

class Ex04Kia extends Ex04Car {			// 5 Ex04Car클래스를 상속받는 Ex04Kia클래스 생성
	String company = "기아";
	int durability = 0; // 내구성

	public Ex04Kia () { // 생성자
		super("중고차");
	}

	public void show() {				// 부모의 메소드를 업그레이드하는 메소드 오버라이드
		System.out.println("내구성 "+durability+"인 "+company+" 회사의 "+model+"(이)가 "+speed+"km로 달린다");
	}
}

class Ex04Car {
	  int speed;						// 1 필드 생성
	  String model;

	  public Ex04Car() {				// 2 생성자 (오버로딩)
		this("승용차");
		// 객체를 생성할 때 모델명 인자를 받지 않을 경우
		// 모델명 "승용차"를 부여하는 동시에 Ex04Car(String model) 호출,
		// Ex04Car(String model)의 speed 값을 받음
	  }
	  public Ex04Car(String model) {
		this.model = model;
		speed = 0;
		// 객체를 생성할 때 모델명 인자를 받을 경우
	  }

	  public void show() {				// 3 메소드
		System.out.println(model+"(이)가 "+speed+"km로 달린다");
	  }
	  public void speedUp() {
		speed += 10;
	  }
	  public void speedDown() {
		speed -= 10;
	  }
	}
