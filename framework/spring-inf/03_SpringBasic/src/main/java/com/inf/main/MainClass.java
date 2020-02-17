package com.inf.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inf.beans.HelloWorld;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 로딩
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/inf/config/beans.xml");
		
		
		// xml에 정의한 bean객체의 주소 값을 가져온다.
		// #1.
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		callMethod(hello1);
		
		// #2.
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		
		ctx.close();
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
