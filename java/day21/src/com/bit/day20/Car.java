package com.bit.day20;

//class Car {										// #5 Exception : java.io.NotSerializableException
public class Car implements java.io.Serializable {			// 무분별하게 객체를 찍어 보내는 것을 방지
	long serialVersionUID = 123456L;// !! day20 Car.java에 써야할수도
	// 작성하지 않으면 자동으로 작성된다. ( > 수정될때마다 버전이 바뀜)
	// 버전이 일치해야 전달할 수 있다.
	// 필드값에만 적용됨 (메소드는 제외 대상)
	public int speed;
	transient public String color;								// transient : 이 필드를 io를 통해 전달하지 못하게 제외시킴
	public Car() {
		speed = 100;
		color = "Black";
	}
	public void func() {
		System.out.println("달린다");
	}
	public void func2() {
		System.out.println("test");
	}
}