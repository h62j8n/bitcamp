package com.bit.day15;

class Template {/*
	public static void <T>Box1<T> newInstance(T val) {
		Box1<T> box = new Box1<T>();
		box1.set(val);
		return box1;
	}
*/}

public class Ex03 {/*
	public static void main(String[] args) {
		Box1<BaseBall> box = Template.<BaseBall>newInstance(new BaseBall());
//		Box1<BaseBall> box = Template.<BaseBall>newInstance(new Bowling());		// Err. <BaseBall>newInstance 앞에서 야구로 지정했기 때문에 볼링에 대해 에러 발생
		Box1<Ball> box = Template.<Ball>newInstance(new BaseBall());			// 다형성 <Ball>newInstance을 사용해 야구든 볼링이든 생성 가능
		
		box1.get().play();
	}
*/}
