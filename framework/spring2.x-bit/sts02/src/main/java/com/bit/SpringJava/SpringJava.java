package com.bit.SpringJava;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.service.*;

public class SpringJava {

	public static void main(String[] args) {
		
		org.springframework.context.ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Remote3 obj=(Remote3) ac.getBean("remote");
		obj.func1();
	}

}
