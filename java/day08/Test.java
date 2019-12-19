class Test {
  public static void main(String[] args) {
	Car my = new Car();
	System.out.println(my.model+", "+my.speed);
  }
}

class Car {
  int speed;					// 1 필드 생성
  String model;

  public Car() {				// 2 생성자 (오버로딩)
	this("승용차");
	// 객체를 생성할 때 모델명 인자를 받지 않을 경우 Car(String model)의 speed 값을 받음
  }
  public Car(String model) {
	this.model = model;
	speed = 0;
	// 객체를 생성할 때 모델명 인자를 받을 경우 이 생성자대로 진행
  }
}