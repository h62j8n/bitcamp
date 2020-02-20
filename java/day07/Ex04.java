class Ex04 {
  public static void main(String[] args) {
	Ex04Car myCar = new Ex04Car();
	myCar.model = "모닝";
	myCar.color = "흰색";
	myCar.max = 150;
	myCar.accel = 20;

	System.out.println("차종 : "+myCar.model+" / "+myCar.color);
	while (myCar.speed<myCar.max) {
		myCar.speedUp();
		System.out.println(myCar.speed+"km");
	}

	myCar = new Ex04Car();
	myCar.model = "아반떼";
	myCar.color = "쥐색";
	myCar.max = 250;
	myCar.accel = 40;

	System.out.println("차종 : "+myCar.model+" / "+myCar.color);
	while (myCar.speed<myCar.max) {
		myCar.speedUp();
		System.out.println(myCar.speed+"km");
	}

	myCar = new Ex04Car();
	myCar.model = "소나타";
	myCar.color = "검정색";
	myCar.max = 300;
	myCar.accel = 60;

	System.out.println(myCar.color+"인 내 차 "+myCar.model+"가 "+myCar.speed+"km로 달린다");
	myCar.speedUp(50);
	System.out.println(myCar.color+"인 내 차 "+myCar.model+"가 "+myCar.speed+"km로 달린다");
	myCar.speedDown(350);
	System.out.println(myCar.color+"인 내 차 "+myCar.model+"가 "+myCar.speed+"km로 달린다");
  }
}

class Ex04Car {
  // 변수-속성 (필드)
  String model;
  String color;
  int speed = 0;
  int max;
  int accel;

  // 메소드 (행위)
  public void speedUp() {
	if (speed+accel <= max) {
		speed += accel;
	} else {
		speed = max;
	}
  }
  public void speedUp(int a) {
	if (speed+a <= max) {
		speed += a;
	} else {
		speed = max;
	}
  }
  public void speedDown() {
	if (speed-accel >= 0) {
		speed -= accel;
	} else {
		speed = 0;
	}
  }
  public void speedDown(int b) {
	if (speed-b >= 0) {
		speed -= b;
	} else {
		speed = 0;
	}
  }
}