package com.bit.service;

public class Radio implements Machine {
	
	public void on() {
		System.out.println("라디오를 켜다");
	}
	
	public void off() {
		System.out.println("라디오를 끄다");
	}
	
	public void work() {
		System.out.println("주파수를 잡아 스피커로 소리낸다");
	}

}
