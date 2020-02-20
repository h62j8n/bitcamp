package com.inf.main;

import com.inf.beans.HelloWorld;
import com.inf.beans.HelloWorldEn;
import com.inf.beans.HelloWorldKo;

public class MainClass {
	public static void main(String[] args) {
		// 인터페이스 객체
		HelloWorld hello1 = new HelloWorldEn();
		callMethod(hello1);
		
		HelloWorld hello2 = new HelloWorldEn();
		callMethod(hello2);
		
		HelloWorld hello3 = new HelloWorldKo();
		callMethod(hello3);
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
	
	// 다형성을 활용하여 모든 소스를 수정할 필요는 없게 되었지만, 객체 생성하는 코드만은 변경해야만 한다.
}
