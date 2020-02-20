package com.bit.sts04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts04.module.Module01;

public class App {
	
    public static void main( String[] args ){
    	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
    	Module01 module01=(Module01) context.getBean("custom");
    	module01.func01();
    	module01.func02();
    	module01.func03();
 
    }
}
