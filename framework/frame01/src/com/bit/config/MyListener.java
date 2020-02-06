package com.bit.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * web.xml (어노테이션 안하는 경우)
 * <listener-class>com.bit.config.MyListener</listener-class>
 */

@WebListener	// 어노테이션
public class MyListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("WAS destroy");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("WAS init");
	}
}
