package com.bit.sts04.step01;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterSuccessDecoration implements AfterReturningAdvice{

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("-----------------------------");
	}

}
