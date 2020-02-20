package com.bit.sts04.step01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundDecoration implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(">>>>>");
		Object obj = invocation.proceed();
		System.out.println("<<<<<");
		return obj;
	}

}
