package com.bit.service;

public class Tv implements Machine{

	public void on() {
		System.out.println("Tv를 켜다");
	}
	
	public void off() {
		System.out.println("Tv를 끄다");
	}
	
	public void work() {
		System.out.println("주파수를 잡아 화면을 전송한다");
	}
}
