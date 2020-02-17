package com.inf.main;

import com.inf.beans.HelloWorldEn;
import com.inf.beans.HelloWorldKo;

public class MainClass {
	public static void main(String[] args) {
//		HelloWorldEn hello1 = new HelloWorldEn();
//		callMethod(hello1);
		HelloWorldKo hello1 = new HelloWorldKo();
		callMethod(hello1);
		
//		HelloWorldEn hello2 = new HelloWorldEn();
//		callMethod(hello2);
	}
	
//	public static void callMethod(HelloWorldEn hello) {
//		hello.sayHello();
//	}
	public static void callMethod(HelloWorldKo hello) {
		hello.sayHello();
	}
	
	// 자바프로젝트의 문제점 : 기존 클래스를 변경한다면 해당 클래스가 사용된 모든 파일에서 소스를 수정해야만 한다.
}
