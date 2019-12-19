package com.bit;

class Ex08Car {
  int speed = 0;
  int max;
  int accel;
  String model;
  String color;

  public Ex08Car(int mx, int a) {
	model = "소나타";
	color = "검정색";
	max = mx;
	accel = a;
  }

  public void speedUp() {
	if (speed+accel <= max) {
		speed += accel;
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
  public void show() {
	System.out.println(color+"인 내 차 "+model+"이(가) "+speed+"km로 달리고 있습니다.");
  }
}

class Ex08 {
  public static void main(String[] args) {
	Ex08Car my = new Ex08Car(300, 20);
/*
	my.color = "흰색";
	my.model = "소나타";
	my.accel = 20;
	my.max = 300;
*/

	for (int i=0; i<20; i++) {
		my.speedUp();
		my.show();
	}
	for (int i=0; i<20; i++) {
		my.speedDown();
		my.show();
	}
  }
}