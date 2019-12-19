package com.bit.day12;

interface controller {}

interface Machine2 {
	void on();
	void off();
	void work();
}

class Tv2 implements Machine2 {
	public void on() {
		System.out.println("");
	}
	public void off() {
		System.out.println("");
	}
	public void work() {
		System.out.println("");
	}
}

public class Ex07 implements controller {	// 이름만 활용하는 인터페이스
	public static void main(String[] args) {
		Machine2 tv = new Tv2();
		tv.on();
	}
}
